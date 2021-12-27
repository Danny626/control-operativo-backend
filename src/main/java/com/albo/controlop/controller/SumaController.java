package com.albo.controlop.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.albo.controlop.dto.BodyRegistroPartesSuma;
import com.albo.controlop.dto.ErrorParte;
import com.albo.controlop.dto.ParamsLoginSuma;
import com.albo.controlop.dto.RespVerificaTokenSuma;
import com.albo.controlop.dto.ResultLoginSuma;
import com.albo.controlop.dto.ResultTokenSuma;
import com.albo.controlop.dto.ResultadoRegistroPartesSuma;
import com.albo.soa.model.AccessTokenSuma;
import com.albo.soa.model.ParteSuma;
import com.albo.soa.service.alt.IAccessTokenSumaAltService;
import com.albo.soa.service.alt.IParteSumaAltService;
import com.albo.soa.service.chb.IAccessTokenSumaChbService;
import com.albo.soa.service.chb.IParteSumaChbService;
import com.albo.soa.service.scz.IAccessTokenSumaSczService;
import com.albo.soa.service.scz.IParteSumaSczService;
import com.albo.soa.service.vir.IAccessTokenSumaVirService;
import com.albo.soa.service.vir.IParteSumaVirService;
import com.albo.suma.model.ParteSumaProceso;

@RestController
@RequestMapping("/suma")
public class SumaController {

	private static final Logger LOGGER = LogManager.getLogger(SumaController.class);
	private final String URI_LOGIN_SUMA = "/b-sso/rest/autenticar/portal?operador=ip";
	private final String URI_VERIFICA_TOKEN_SUMA = "/b-sso/rest/autenticar/verificar";
	private final String URI_MIS_PARTES_SUMA = "/b-ingreso/api/json/pre/120585022/prms";
	private final String URI_CONTEO_PARTES_SUMA = "/b-ingreso/api/json/pre/120585022/count";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private IParteSumaVirService parteSumaVirService;

	@Autowired
	private IParteSumaAltService parteSumaAltService;

	@Autowired
	private IParteSumaChbService parteSumaChbService;

	@Autowired
	private IParteSumaSczService parteSumaSczService;

	@Autowired
	private IAccessTokenSumaAltService accessTokenSumaAltService;

	@Autowired
	private IAccessTokenSumaChbService accessTokenSumaChbService;

	@Autowired
	private IAccessTokenSumaSczService accessTokenSumaSczService;

	@Autowired
	private IAccessTokenSumaVirService accessTokenSumaVirService;
	
	

	@PostMapping(value = "/loginSuma", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultLoginSuma> loginSuma(@RequestBody ParamsLoginSuma paramsLoginSuma) {

		ResultLoginSuma resultLoginError = new ResultLoginSuma();
		resultLoginError.setSuccess(false);
		resultLoginError.setResult(null);
		
		// buscamos en bd AccessTokenSuma si existe un token registrado para el usuario
		// y si el token es válido aún		
		switch (paramsLoginSuma.getCodRecinto()) {
		case "ALT01": {
			AccessTokenSuma accessTokenSuma = this.accessTokenSumaAltService.buscarPorUsuario(paramsLoginSuma.getBodyLoginSuma().getNombreUsuario());
			
			if(accessTokenSuma != null) {
				
				// verificamos la validez del token
				ResponseEntity<RespVerificaTokenSuma> revisaToken = this.verificaTokenSuma(accessTokenSuma.getToken());
				
				if (revisaToken.getBody().isSuccess() == true) {
					ResultTokenSuma resultTokenSuma = new ResultTokenSuma();
					resultTokenSuma.setToken(accessTokenSuma.getToken());
					resultTokenSuma.setUrl("/portal/listener.html#/listener");
					
					ResultLoginSuma resultLoginSuma = new ResultLoginSuma();
					resultLoginSuma.setSuccess(true);
					resultLoginSuma.setResult(resultTokenSuma);
					
					return new ResponseEntity<ResultLoginSuma>(resultLoginSuma, HttpStatus.OK);
				}
				
				this.eliminaTokenUsuarioSuma(paramsLoginSuma.getBodyLoginSuma().getNombreUsuario(), paramsLoginSuma.getCodRecinto());
				
				return this.procesoRequestLoginSuma(paramsLoginSuma);
			} else {
				return this.procesoRequestLoginSuma(paramsLoginSuma);
			}
		}
		case "CHB01": {
			AccessTokenSuma accessTokenSuma = this.accessTokenSumaChbService.buscarPorUsuario(paramsLoginSuma.getBodyLoginSuma().getNombreUsuario());
			
			if(accessTokenSuma != null) {
				
				// verificamos la validez del token
				ResponseEntity<RespVerificaTokenSuma> revisaToken = this.verificaTokenSuma(accessTokenSuma.getToken());
				
				if (revisaToken.getBody().isSuccess() == true) {
					ResultTokenSuma resultTokenSuma = new ResultTokenSuma();
					resultTokenSuma.setToken(accessTokenSuma.getToken());
					resultTokenSuma.setUrl("/portal/listener.html#/listener");
					
					ResultLoginSuma resultLoginSuma = new ResultLoginSuma();
					resultLoginSuma.setSuccess(true);
					resultLoginSuma.setResult(resultTokenSuma);
					
					return new ResponseEntity<ResultLoginSuma>(resultLoginSuma, HttpStatus.OK);
				}
				
				this.eliminaTokenUsuarioSuma(paramsLoginSuma.getBodyLoginSuma().getNombreUsuario(), paramsLoginSuma.getCodRecinto());
				
				return this.procesoRequestLoginSuma(paramsLoginSuma);
			} else {
				return this.procesoRequestLoginSuma(paramsLoginSuma);
			}
		}
		case "PAM01": {
			AccessTokenSuma accessTokenSuma = this.accessTokenSumaSczService.buscarPorUsuario(paramsLoginSuma.getBodyLoginSuma().getNombreUsuario());
			
			if(accessTokenSuma != null) {
				
				// verificamos la validez del token
				ResponseEntity<RespVerificaTokenSuma> revisaToken = this.verificaTokenSuma(accessTokenSuma.getToken());
				
				if (revisaToken.getBody().isSuccess() == true) {
					ResultTokenSuma resultTokenSuma = new ResultTokenSuma();
					resultTokenSuma.setToken(accessTokenSuma.getToken());
					resultTokenSuma.setUrl("/portal/listener.html#/listener");
					
					ResultLoginSuma resultLoginSuma = new ResultLoginSuma();
					resultLoginSuma.setSuccess(true);
					resultLoginSuma.setResult(resultTokenSuma);
					
					return new ResponseEntity<ResultLoginSuma>(resultLoginSuma, HttpStatus.OK);
				}
				
				this.eliminaTokenUsuarioSuma(paramsLoginSuma.getBodyLoginSuma().getNombreUsuario(), paramsLoginSuma.getCodRecinto());
				
				return this.procesoRequestLoginSuma(paramsLoginSuma);
			} else {
				return this.procesoRequestLoginSuma(paramsLoginSuma);
			}
		}
		case "VIR01": {
			AccessTokenSuma accessTokenSuma = this.accessTokenSumaVirService.buscarPorUsuario(paramsLoginSuma.getBodyLoginSuma().getNombreUsuario());
			
			if(accessTokenSuma != null) {
				
				// verificamos la validez del token
				ResponseEntity<RespVerificaTokenSuma> revisaToken = this.verificaTokenSuma(accessTokenSuma.getToken());
				
				if (revisaToken.getBody().isSuccess() == true) {
					ResultTokenSuma resultTokenSuma = new ResultTokenSuma();
					resultTokenSuma.setToken(accessTokenSuma.getToken());
					resultTokenSuma.setUrl("/portal/listener.html#/listener");
					
					ResultLoginSuma resultLoginSuma = new ResultLoginSuma();
					resultLoginSuma.setSuccess(true);
					resultLoginSuma.setResult(resultTokenSuma);
					
					return new ResponseEntity<ResultLoginSuma>(resultLoginSuma, HttpStatus.OK);
				}
				
				this.eliminaTokenUsuarioSuma(paramsLoginSuma.getBodyLoginSuma().getNombreUsuario(), paramsLoginSuma.getCodRecinto());
				
				return this.procesoRequestLoginSuma(paramsLoginSuma);
			} else {
				return this.procesoRequestLoginSuma(paramsLoginSuma);
			}
		}
		default:
			LOGGER.error("Error. Cód. de recinto no válido");
			return new ResponseEntity<ResultLoginSuma>(resultLoginError, HttpStatus.BAD_REQUEST);
		}
	}
	

	@PostMapping(value = "/registroPartesSuma", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> cargaPartesSuma(@RequestBody BodyRegistroPartesSuma bodyRegistroPartesSuma) {
		
		// armamos la fecha inicial
		LocalDateTime fechaInicialProceso = bodyRegistroPartesSuma.getParamsMisPartesSuma().getFrom().withHour(0).withMinute(0).withSecond(0).withNano(0);
		LOGGER.info("fechaInicialProceso: " + fechaInicialProceso);
		
		// armamos la fecha final
//		LocalDateTime fechaFinalProceso = bodyRegistroPartesSuma.getParamsMisPartesSuma().getTo().withHour(23).withMinute(59).withSecond(59).withNano(999999999);
		LocalDateTime fechaFinalProceso = fechaInicialProceso;
		LOGGER.info("fechaFinalProceso: " + fechaFinalProceso);
		
		bodyRegistroPartesSuma.getParamsMisPartesSuma().setFrom(fechaInicialProceso);
		bodyRegistroPartesSuma.getParamsMisPartesSuma().setTo(fechaFinalProceso);
		
		// hacemos el request de registros suma, recorriendo sus páginas de partes según la fecha
//		Long fechaInicialEpoch = this.localDateTimeToEpochMilliseconds(bodyRegistroPartesSuma.getParamsMisPartesSuma().getFrom());
//		Long fechaFinalEpoch = this.localDateTimeToEpochMilliseconds(bodyRegistroPartesSuma.getParamsMisPartesSuma().getTo());
		
		// verificamos la validez del token
		ParamsLoginSuma paramsLoginSuma = new ParamsLoginSuma();
		paramsLoginSuma.setCodRecinto(bodyRegistroPartesSuma.getCodRecinto());
		paramsLoginSuma.setBodyLoginSuma(bodyRegistroPartesSuma.getBodyLoginSuma());
		
		ResponseEntity<ResultLoginSuma> responseLoginSuma = this.loginSuma(paramsLoginSuma);
		ResultLoginSuma resultLoginSuma = new ResultLoginSuma();
		
		switch (responseLoginSuma.getStatusCode()) {
		case OK:
			resultLoginSuma = responseLoginSuma.getBody();
			bodyRegistroPartesSuma.setToken(resultLoginSuma.getResult().getToken());
			
			// realizamos la consulta de la cantidad de partes existentes en suma 
			ResponseEntity<?> conteoPrSuma = this.conteoPartesSuma(bodyRegistroPartesSuma.getUsuario(), bodyRegistroPartesSuma.getToken(),bodyRegistroPartesSuma.getParamsMisPartesSuma().getTipPre(), fechaInicialProceso, fechaFinalProceso, bodyRegistroPartesSuma.getBodyMisPartesSuma().getEstadoParte());
			
			// realizamos el pedido de partes suma
			ResponseEntity<List<ParteSumaProceso>> listaPartesSumaResultado = this.requestPartesSuma(bodyRegistroPartesSuma, Integer.valueOf(conteoPrSuma.getBody().toString()));

			// guardamos los registros partes suma conseguidos
			ResultadoRegistroPartesSuma resultadoRegistroPartesSuma = this.registroPrmSumaSoa(listaPartesSumaResultado.getBody(), bodyRegistroPartesSuma.getCodRecinto());
			
			// si la consulta del conteo de partes suma es correcto lo establecemoc en totalRegistros
			if(conteoPrSuma.getStatusCode() == HttpStatus.OK) {
				resultadoRegistroPartesSuma.setTotalRegistros(Integer.valueOf(conteoPrSuma.getBody().toString()));
			}
			
			return new ResponseEntity<ResultadoRegistroPartesSuma>(resultadoRegistroPartesSuma, HttpStatus.OK);
		default:
			LOGGER.error("Error login SUMA: " + responseLoginSuma.getStatusCode());
			return new ResponseEntity<String>("Error login SUMA: " + responseLoginSuma.getStatusCode(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping(value = "/verificaTokenSuma/{tk}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespVerificaTokenSuma> verificaTokenSuma(@PathVariable("tk") String tk) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"");
		headers.set("Accept", "application/json, text/plain, */*");
		headers.set("sec-ch-ua-mobile", "?0");
		headers.set("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36");
		headers.set("sec-ch-ua-platform", "\"Windows\"");
		headers.set("Content-Type", "application/json;charset=UTF-8");
//		headers.set("Connection", "keep-alive");
		
		String urlAutenticacion = URI_VERIFICA_TOKEN_SUMA + "/" + tk;

		RequestEntity<?> request = RequestEntity.get(urlAutenticacion).headers(headers).build();

		ResponseEntity<RespVerificaTokenSuma> response = restTemplate.exchange(request, RespVerificaTokenSuma.class);
		
		if(response.getBody().isSuccess() == true) {
			return new ResponseEntity<RespVerificaTokenSuma>(response.getBody(), response.getStatusCode());
		}
		
		return new ResponseEntity<RespVerificaTokenSuma>(new RespVerificaTokenSuma(), response.getStatusCode());
	}
	
	@GetMapping(value = "/conteoPartesSuma", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> conteoPartesSuma(String userName, String token, List<String> listaTipPre, LocalDateTime desde, LocalDateTime hasta, List<String> listaEstadosPartes) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"");
		headers.set("sec-ch-ua-mobile", "?0");
		headers.set("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36");
		headers.set("Content-Type", "application/json;charset=UTF-8");
		headers.set("Accept", "application/json, text/plain, */*");
		headers.set("User", userName);
		headers.set("Auth-Token", token);
		headers.set("sec-ch-ua-platform", "\"Windows\"");
		
		// armado url
		String urlConteoPrm = URI_CONTEO_PARTES_SUMA + "?";

		for (String tipPre : listaTipPre) {
			urlConteoPrm = urlConteoPrm + "&tipPre=" + tipPre;
		}

		urlConteoPrm = urlConteoPrm + "&to="
				+ this.localDateTimeToEpochMilliseconds(hasta)
				+ "&from="
				+ this.localDateTimeToEpochMilliseconds(desde)
				+ "&column=" + "cor";

		RequestEntity<?> request = RequestEntity.post(urlConteoPrm).headers(headers)
				.body(listaEstadosPartes);
	
		ResponseEntity<Integer> response = new ResponseEntity<>(null, HttpStatus.OK);
		
		try {
			response = restTemplate.exchange(request, Integer.class);
		} catch (HttpClientErrorException e) {
			LOGGER.error("Error obteniendo conteo partes suma: " + e.getResponseBodyAsString());
			return new ResponseEntity<String>("Error obteniendo conteo partes suma", response.getStatusCode());
		}
		
		LOGGER.info("El conteo de partes es: " + response.getBody());

		return response;
	}
	
	
	// Realiza el request de partes en suma
	public ResponseEntity<List<ParteSumaProceso>> requestPartesSuma(
			BodyRegistroPartesSuma bodyRegistroPartesSuma, Integer conteoPrmSuma) {
		
		List<ParteSumaProceso> partesSuma = new ArrayList<>();
		boolean buscar = true;
		int pagina = 0;
		
		while(buscar == true) {
			LOGGER.info("Obteniendo página: " + pagina);
			bodyRegistroPartesSuma.getParamsMisPartesSuma().setPage(pagina);
			
			// hacemos una pausa entre requests
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ResponseEntity<List<ParteSumaProceso>> response = this.requestMisPartesSuma(bodyRegistroPartesSuma);
			
			if(response.getStatusCode() == HttpStatus.OK) {
				
				List<ParteSumaProceso> partesSumaTemp = new ArrayList<>();
				partesSumaTemp = response.getBody();
				
				// recorremos los resultados de la página solicitada
				for(ParteSumaProceso ps : partesSumaTemp) {	
					partesSuma.add(ps);
				}
				
				if( pagina < (conteoPrmSuma - 10) ) {
					pagina = pagina + 10;
				} else {
					buscar = false;
				}
			}
			
			if(response.getStatusCode() != HttpStatus.OK) {
				LOGGER.error("/registroPartesSuma => " + response.getStatusCode());
				return new ResponseEntity<List<ParteSumaProceso>>(partesSuma, response.getStatusCode());
			}
		}
		
		return new ResponseEntity<List<ParteSumaProceso>>(partesSuma, HttpStatus.OK);	
	}
	
	public ResponseEntity<ResultLoginSuma> requestLoginSuma(ParamsLoginSuma paramsLoginSuma) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"");
		headers.set("Accept", "application/json, text/plain, */*");
		headers.set("Content-Type", "application/json;charset=UTF-8");
		headers.set("User", paramsLoginSuma.getBodyLoginSuma().getNombreUsuario());
		headers.set("sec-ch-ua-mobile", "?0");
		headers.set("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36");
		headers.set("sec-ch-ua-platform", "\"Windows\"");
		headers.set("Connection", "keep-alive");

		RequestEntity<?> request = RequestEntity.post(URI_LOGIN_SUMA).headers(headers).body(paramsLoginSuma.getBodyLoginSuma());

		ResponseEntity<ResultLoginSuma> response = restTemplate.exchange(request, ResultLoginSuma.class);
		
		return response;
	}

	// registra los partes suma obtenidos de suma en Soa.ParteSuma
	private ResultadoRegistroPartesSuma registroPrmSumaSoa(List<ParteSumaProceso> misPartesSuma, String recCod) {

		ParteSuma parteSumaSoa = new ParteSuma();
		List<ErrorParte> listaError = new ArrayList<>();
		List<ParteSuma> partesSumaGuardados = new ArrayList<>();
		ResultadoRegistroPartesSuma resultadoRegistroPartesSuma = new ResultadoRegistroPartesSuma();

		for (ParteSumaProceso prm : misPartesSuma) {
			parteSumaSoa = new ParteSuma();

			parteSumaSoa.setIdSuma(prm.getId());
			parteSumaSoa.setCor(prm.getCor());
			parteSumaSoa.setFecTra(this.fechaEpochToLocalDateTime(prm.getFecTra()));
			parteSumaSoa.setDstOea(prm.getDst() == null ? null : prm.getDst().isOea());
			parteSumaSoa.setDstCodTipDoc(prm.getDst() == null ? null : prm.getDst().getCodTipDoc());
			parteSumaSoa.setDstNumDoc(prm.getDst() == null ? null : prm.getDst().getNumDoc());
			parteSumaSoa.setDstNomRazSoc(prm.getDst() == null ? null : prm.getDst().getNomRazSoc());
			parteSumaSoa.setEstAct(prm.getEstAct());
			parteSumaSoa.setDatgenNumMan(prm.getDatGen() == null ? null : prm.getDatGen().getNumMan());
			parteSumaSoa.setDatgenNumDocEmb(prm.getDatGen() == null ? null : prm.getDatGen().getNumDocEmb());
			parteSumaSoa.setDatgenFecing(
					prm.getDatGen() == null ? null : this.fechaEpochToLocalDateTime(prm.getDatGen().getFecIng()));
			parteSumaSoa.setDatgenAdurecCod(prm.getDatGen() == null ? null : prm.getDatGen().getAduRec().getCod());
			parteSumaSoa.setIngubimerModregDes(prm.getIngUbiMer() == null ? null
					: (prm.getIngUbiMer().getModReg() == null ? null : prm.getIngUbiMer().getModReg().getDes()));
			parteSumaSoa.setIngubimerTipcarDes(prm.getIngUbiMer() == null ? null
					: (prm.getIngUbiMer().getTipCar() == null ? null : prm.getIngUbiMer().getTipCar().getDes()));
			parteSumaSoa.setIngubimerAlmCod(prm.getIngUbiMer() == null ? null
					: (prm.getIngUbiMer().getAlm() == null ? null : prm.getIngUbiMer().getAlm().getCod()));
			parteSumaSoa.setIngubimerAlmDes(prm.getIngUbiMer() == null ? null
					: (prm.getIngUbiMer().getAlm() == null ? null : prm.getIngUbiMer().getAlm().getDes()));
			parteSumaSoa.setIngubimerSecCod(prm.getIngUbiMer() == null ? null
					: (prm.getIngUbiMer().getSec() == null ? null : prm.getIngUbiMer().getSec().getCod()));
			parteSumaSoa.setIngubimerSecDes(prm.getIngUbiMer() == null ? null
					: (prm.getIngUbiMer().getSec() == null ? null : prm.getIngUbiMer().getSec().getDes()));
			parteSumaSoa.setIngubimerEmipreCod(prm.getIngUbiMer() == null ? null
					: (prm.getIngUbiMer().getEmiPre() == null ? null : prm.getIngUbiMer().getEmiPre().getCod()));
			parteSumaSoa.setIngubimerEmipreDes(prm.getIngUbiMer() == null ? null
					: (prm.getIngUbiMer().getEmiPre() == null ? null : prm.getIngUbiMer().getEmiPre().getDes()));
			parteSumaSoa.setInftecDocfirUsrfir(prm.getInfTec() == null ? null
					: (prm.getInfTec().getDocFir() == null ? null : prm.getInfTec().getDocFir().get(0).getUsrFir()));
			parteSumaSoa.setInftecDocfirFecfir(this.fechaEpochToLocalDateTime(prm.getInfTec() == null ? null
					: (prm.getInfTec().getDocFir() == null ? null : prm.getInfTec().getDocFir().get(0).getFecFir())));
			parteSumaSoa
					.setContotsobfalCanrec(prm.getConTotSobFal() == null ? null : prm.getConTotSobFal().getCanRec());
			parteSumaSoa
					.setContotsobfalPesrec(prm.getConTotSobFal() == null ? null : prm.getConTotSobFal().getPesRec());
			parteSumaSoa.setFechaRegistro(LocalDateTime.now());
			parteSumaSoa.setSync(false);
			
			// realizamos el guardado de acuerdo al recinto
			switch (recCod) {
			case "ALT01": {
				try {
					// verificamos si el parte suma ya existe
					ParteSuma psExistente = this.parteSumaAltService.buscarPorPrmSuma(parteSumaSoa.getCor());
					
					if(psExistente == null) {
						
						if (this.parteSumaAltService.saveOrUpdate(parteSumaSoa) == null) {
							listaError.add(new ErrorParte(parteSumaSoa.getCor(), "Error registrando ParteSuma"));
							LOGGER.error("Error registrando ParteSuma: " + parteSumaSoa.getCor());
						} else {
							partesSumaGuardados.add(parteSumaSoa);
						}
						
					} else {
						// verificamos los estados y los modificamos según el caso
						if(!psExistente.getEstAct().equals("CONCLUIDO") && !psExistente.getEstAct().equals(parteSumaSoa.getEstAct())) {
							
							psExistente.setEstAct(parteSumaSoa.getEstAct());
							
							if (this.parteSumaAltService.saveOrUpdate(psExistente) == null) {
								listaError.add(new ErrorParte(psExistente.getCor(), "Error modificando ParteSuma"));
								LOGGER.error("Error modificando ParteSuma: " + psExistente.getCor());
							} else {
								partesSumaGuardados.add(psExistente);
							}
						}
					}
							
				} catch (RollbackException e) {
					listaError.add(new ErrorParte(parteSumaSoa.getCor(), "ParteSuma ya registrado"));
					LOGGER.info("ParteSuma ya registrado: " + parteSumaSoa.getCor());
				}

				break;
			}
			case "CHB01": {
				try {
					// verificamos si el parte suma ya existe
					ParteSuma psExistente = this.parteSumaChbService.buscarPorPrmSuma(parteSumaSoa.getCor());
					
					if(psExistente == null) {
						
						if (this.parteSumaChbService.saveOrUpdate(parteSumaSoa) == null) {
							listaError.add(new ErrorParte(parteSumaSoa.getCor(), "Error registrando ParteSuma"));
							LOGGER.error("Error registrando ParteSuma: " + parteSumaSoa.getCor());
						} else {
							partesSumaGuardados.add(parteSumaSoa);
						}
						
					} else {
						// verificamos los estados y los modificamos según el caso
						if(!psExistente.getEstAct().equals("CONCLUIDO") && !psExistente.getEstAct().equals(parteSumaSoa.getEstAct())) {
							
							psExistente.setEstAct(parteSumaSoa.getEstAct());
							
							if (this.parteSumaChbService.saveOrUpdate(psExistente) == null) {
								listaError.add(new ErrorParte(psExistente.getCor(), "Error modificando ParteSuma"));
								LOGGER.error("Error modificando ParteSuma: " + psExistente.getCor());
							} else {
								partesSumaGuardados.add(psExistente);
							}
						}
					}
							
				} catch (RollbackException e) {
					listaError.add(new ErrorParte(parteSumaSoa.getCor(), "ParteSuma ya registrado"));
					LOGGER.info("ParteSuma ya registrado: " + parteSumaSoa.getCor());
				}

				break;
			}
			case "PAM01": {
				try {
					// verificamos si el parte suma ya existe
					ParteSuma psExistente = this.parteSumaSczService.buscarPorPrmSuma(parteSumaSoa.getCor());
					
					if(psExistente == null) {
						
						if (this.parteSumaSczService.saveOrUpdate(parteSumaSoa) == null) {
							listaError.add(new ErrorParte(parteSumaSoa.getCor(), "Error registrando ParteSuma"));
							LOGGER.error("Error registrando ParteSuma: " + parteSumaSoa.getCor());
						} else {
							partesSumaGuardados.add(parteSumaSoa);
						}
						
					} else {
						// verificamos los estados y los modificamos según el caso
						if(!psExistente.getEstAct().equals("CONCLUIDO") && !psExistente.getEstAct().equals(parteSumaSoa.getEstAct())) {
							
							psExistente.setEstAct(parteSumaSoa.getEstAct());
							
							if (this.parteSumaSczService.saveOrUpdate(psExistente) == null) {
								listaError.add(new ErrorParte(psExistente.getCor(), "Error modificando ParteSuma"));
								LOGGER.error("Error modificando ParteSuma: " + psExistente.getCor());
							} else {
								partesSumaGuardados.add(psExistente);
							}
						}
					}
							
				} catch (RollbackException e) {
					listaError.add(new ErrorParte(parteSumaSoa.getCor(), "ParteSuma ya registrado"));
					LOGGER.info("ParteSuma ya registrado: " + parteSumaSoa.getCor());
				}

				break;
			}
			case "VIR01": {
				try {
					// verificamos si el parte suma ya existe
					ParteSuma psExistente = this.parteSumaVirService.buscarPorPrmSuma(parteSumaSoa.getCor());
					
					if(psExistente == null) {
						
						if (this.parteSumaVirService.saveOrUpdate(parteSumaSoa) == null) {
							listaError.add(new ErrorParte(parteSumaSoa.getCor(), "Error registrando ParteSuma"));
							LOGGER.error("Error registrando ParteSuma: " + parteSumaSoa.getCor());
						} else {
							partesSumaGuardados.add(parteSumaSoa);
						}
						
					} else {
						// verificamos los estados y los modificamos según el caso
						if(!psExistente.getEstAct().equals("CONCLUIDO") && !psExistente.getEstAct().equals(parteSumaSoa.getEstAct())) {
							
							psExistente.setEstAct(parteSumaSoa.getEstAct());
							
							if (this.parteSumaVirService.saveOrUpdate(psExistente) == null) {
								listaError.add(new ErrorParte(psExistente.getCor(), "Error modificando ParteSuma"));
								LOGGER.error("Error modificando ParteSuma: " + psExistente.getCor());
							} else {
								partesSumaGuardados.add(psExistente);
							}
						}
					}
							
				} catch (RollbackException e) {
					listaError.add(new ErrorParte(parteSumaSoa.getCor(), "ParteSuma ya registrado"));
					LOGGER.info("ParteSuma ya registrado: " + parteSumaSoa.getCor());
				}

				break;
			}
			default:
				LOGGER.error("Error. Cód. de recinto no válido");
			}
		}

//		resultadoRegistroPartesSuma.setTotalRegistros(misPartesSuma.size());
		resultadoRegistroPartesSuma.setRegistrosNoGuardados(listaError.size());
		resultadoRegistroPartesSuma.setRegistrosGuardados(partesSumaGuardados.size());
		resultadoRegistroPartesSuma.setRegistrosError(listaError);
		resultadoRegistroPartesSuma.setPartesSumaGuardados(partesSumaGuardados);

		return resultadoRegistroPartesSuma;
	}

	private ResponseEntity<List<ParteSumaProceso>> requestMisPartesSuma(BodyRegistroPartesSuma bodyRegistroPartesSuma) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"");
		headers.set("sec-ch-ua-mobile", "?0");
		headers.set("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36");
		headers.set("Content-Type", "application/json;charset=UTF-8");
		headers.set("Accept", "application/json, text/plain, */*");
		headers.set("User", bodyRegistroPartesSuma.getUsuario());
		headers.set("Auth-Token", bodyRegistroPartesSuma.getToken());
		headers.set("sec-ch-ua-platform", "\"Windows\"");

		// armado url
		String urlPrm = URI_MIS_PARTES_SUMA + "?" + "page=" + bodyRegistroPartesSuma.getParamsMisPartesSuma().getPage()
				+ "&size=" + bodyRegistroPartesSuma.getParamsMisPartesSuma().getSize() + "&search="
				+ bodyRegistroPartesSuma.getParamsMisPartesSuma().getSearch();

		for (String tipPre : bodyRegistroPartesSuma.getParamsMisPartesSuma().getTipPre()) {
			urlPrm = urlPrm + "&tipPre=" + tipPre;
		}

		urlPrm = urlPrm + "&to="
				+ this.localDateTimeToEpochMilliseconds(bodyRegistroPartesSuma.getParamsMisPartesSuma().getTo())
				+ "&from="
				+ this.localDateTimeToEpochMilliseconds(bodyRegistroPartesSuma.getParamsMisPartesSuma().getFrom())
				+ "&column=" + bodyRegistroPartesSuma.getParamsMisPartesSuma().getColumn();

		RequestEntity<?> request = RequestEntity.post(urlPrm).headers(headers)
				.body(bodyRegistroPartesSuma.getBodyMisPartesSuma().getEstadoParte());
	
		ResponseEntity<List<ParteSumaProceso>> response = new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
		
		try {
			response = restTemplate.exchange(request,
					new ParameterizedTypeReference<List<ParteSumaProceso>>() {
					});
		} catch (HttpClientErrorException e) {
			LOGGER.error("Error obteniendo partes suma: " + e.getResponseBodyAsString());
			LOGGER.error("Header error: " + response.getHeaders());
			return new ResponseEntity<List<ParteSumaProceso>>(new ArrayList<>(), response.getStatusCode());
		}

		return response;
	}

	// convierte una fecha epoch a LocalDateTime
	public LocalDateTime fechaEpochToLocalDateTime(Long fechaEpoch) {
		if(fechaEpoch == null) return null;
		return Instant.ofEpochMilli(fechaEpoch).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	// convierte una fecha LocalDateTime a un formato epoch
	public Long localDateTimeToEpochMilliseconds(LocalDateTime fechaTime) {
		Instant instant = fechaTime.atZone(ZoneId.systemDefault()).toInstant();
		return instant.toEpochMilli();
	}
	
	public Boolean eliminaTokenUsuarioSuma(String usuario, String codRecinto) {
		Boolean flagEliminado = false;
		
		switch (codRecinto) {
		case "ALT01": {
			AccessTokenSuma accessTokenSuma = this.accessTokenSumaAltService.buscarPorUsuario(usuario);
			
			if(accessTokenSuma == null) return false;
			
			flagEliminado = this.accessTokenSumaAltService.deleteById(accessTokenSuma.getId());
			break;
		}
		case "CHB01": {
			AccessTokenSuma accessTokenSuma = this.accessTokenSumaChbService.buscarPorUsuario(usuario);
			
			if(accessTokenSuma == null) return false;
			
			flagEliminado = this.accessTokenSumaChbService.deleteById(accessTokenSuma.getId());
			break;
		}
		case "PAM01": {
			AccessTokenSuma accessTokenSuma = this.accessTokenSumaSczService.buscarPorUsuario(usuario);
			
			if(accessTokenSuma == null) return false;
			
			flagEliminado = this.accessTokenSumaSczService.deleteById(accessTokenSuma.getId());
			break;
		}
		case "VIR01": {
			AccessTokenSuma accessTokenSuma = this.accessTokenSumaVirService.buscarPorUsuario(usuario);
			
			if(accessTokenSuma == null) return false;
			
			flagEliminado = this.accessTokenSumaVirService.deleteById(accessTokenSuma.getId());
			break;
		}
		default:
			LOGGER.error("Error. Cód. de recinto no válido");
			return false;
		}
		
		return flagEliminado;
	}
	
	private ResponseEntity<ResultLoginSuma> procesoRequestLoginSuma(ParamsLoginSuma paramsLoginSuma) {
		ResponseEntity<ResultLoginSuma> response = this.requestLoginSuma(paramsLoginSuma);

		switch (response.getStatusCode()) {
		case OK:
			AccessTokenSuma accessTokenSumaGuardar = new AccessTokenSuma();
			accessTokenSumaGuardar.setUsuario(paramsLoginSuma.getBodyLoginSuma().getNombreUsuario());
			accessTokenSumaGuardar.setToken(response.getBody().getResult().getToken());
			
			this.accessTokenSumaAltService.saveOrUpdate(accessTokenSumaGuardar);
			return new ResponseEntity<ResultLoginSuma>(response.getBody(), HttpStatus.OK);
		default:
			LOGGER.error("Error login SUMA: " + response.getStatusCode());
			return new ResponseEntity<ResultLoginSuma>(response.getBody(), HttpStatus.BAD_REQUEST);
		}
	}

}
