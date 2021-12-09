package com.albo.controlop.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.albo.controlop.dto.ErrorExcel;
import com.albo.controlop.dto.ExistenVirtualbo;
import com.albo.controlop.dto.ParamControlPartes;
import com.albo.controlop.dto.PedidoCargaArchivo;
import com.albo.controlop.dto.ResultadoCargaExcel;
import com.albo.controlop.dto.ResultadoComparaSumaVirtu;
import com.albo.controlop.model.Aduana;
import com.albo.controlop.model.DestinatarioParte;
import com.albo.controlop.model.ParteSumaExcel;
import com.albo.controlop.model.Recinto;
import com.albo.controlop.model.UsuarioParte;
import com.albo.controlop.service.IAduanaService;
import com.albo.controlop.service.IDestinatarioParteService;
import com.albo.controlop.service.IEstadoParteService;
import com.albo.controlop.service.IParteSumaService;
import com.albo.controlop.service.IRecintoService;
import com.albo.controlop.service.ITipoCargaParteService;
import com.albo.controlop.service.IUsuarioParteService;
import com.albo.soa.model.VInventarioEgr;
import com.albo.soa.service.alt.IVInventarioEgrAltService;
import com.albo.soa.service.chb.IVInventarioEgrChbService;
import com.albo.soa.service.scz.IVInventarioEgrSczService;
import com.albo.soa.service.vir.IVInventarioEgrVirService;

@RestController
@RequestMapping("/controlOperativo")
public class ControlOperativoController {

	private static final Logger LOGGER = LogManager.getLogger(ControlOperativoController.class);

	@Autowired
	private IAduanaService aduanaService;

	@Autowired
	private IDestinatarioParteService destinatarioParteService;

	@Autowired
	private IEstadoParteService estadoParteService;

	@Autowired
	private ITipoCargaParteService tipoCargaParteService;

	@Autowired
	private IUsuarioParteService usuarioParteService;
	
	@Autowired
	private IParteSumaService parteSumaService;
	
	@Autowired
	private IRecintoService recintoService;
	
	@Autowired
	private IVInventarioEgrAltService vInventarioEgrAltService;
	
	@Autowired
	private IVInventarioEgrChbService vInventarioEgrChbService;
	
	@Autowired
	private IVInventarioEgrSczService vInventarioEgrSczService;
	
	@Autowired
	private IVInventarioEgrVirService vInventarioEgrVirService;

	@PostMapping(value = "/cargaArchivo", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> cargaArchivo(PedidoCargaArchivo paquete) {

		Map<Integer, List<String>> data = this.readExcelFile(paquete.getFile());
		List<ParteSumaExcel> partesSuma = new ArrayList<>();
		List<ErrorExcel> errores = new ArrayList<>();
		int[] contadorError = {0};
		int[] contadorProcesadosCorrectos = {0};
		
		Optional<Recinto> recinto = this.recintoService.findById(paquete.getCodRecinto());
		
		if(recinto.isEmpty()) {
			return new ResponseEntity<String>("Error. Código de recinto incorrecto o no está registrado", HttpStatus.BAD_REQUEST);
		}

		data.forEach((key, value) -> {
			contadorError[0] = 0;

			// celda PR
			ParteSumaExcel parte = this.procesarPR(value.get(1));
			
			// si no se registró el cód. aduana mandamos error
			if(parte.getAduana() == null) {
				errores.add(new ErrorExcel(Integer.valueOf(value.get(0)), "Error al registrar el código de aduana"));
				return;
			}

			// celda fechaRecepcion
			parte.setFechaRecepcion(this.procesarFechaRecepcion(value.get(2)));

			// celda estado PR
			this.estadoParteService.findById(value.get(3)).ifPresentOrElse(
					val -> parte.setEstadoParte(val),
					() -> LOGGER.error("Error estado parte no registrado: " + value.get(3)));

			// celda nro manifiesto
			parte.setNroManifiesto(value.get(4));

			// celda registro manifiesto
			parte.setRegistroManifiesto(value.get(5));

			// celda documento de embarque
			parte.setDocumentoEmbarque(value.get(6));

			// celda documento relacionado
			parte.setDocumentoRelacionado(value.get(7));

			// celda placa/patente
			parte.setPlacaPatente(value.get(8));

			// celda destinatario
			DestinatarioParte destinatarioParte = this.procesarDestinatarioParte(value.get(9));
			
			if(destinatarioParte == null) {
				errores.add(new ErrorExcel(Integer.valueOf(value.get(0)), "Error al registrar el destinatario"));
				return;
			} else {
				parte.setDestinatarioParte(destinatarioParte);
			}

			// celda tipo de carga
			this.tipoCargaParteService.findById(value.get(10)).ifPresentOrElse(
					val -> parte.setTipoCargaParte(val),
					() -> LOGGER.error("Error tipoCargaParte no registrado: " + value.get(10)));
			
			// celda usuario
			UsuarioParte usuarioParte = this.procesarUsuarioParte(value.get(11));
			
			if(usuarioParte.getNombre() == null) {
				errores.add(new ErrorExcel(Integer.valueOf(value.get(0)), "Error al registrar el usuario del parte"));
				return;
			} else {
				parte.setUsuarioParte(usuarioParte);
			}
			
			if(contadorError[0] == 0) {
				// control registros repetidos
				if(this.parteSumaService.buscarPorRegistroRepetido(parte.getParteRecepcion(), parte.getEstadoParte(),
						parte.getFechaRecepcion(), parte.getNroManifiesto(), parte.getRegistroManifiesto(), 
						parte.getDocumentoEmbarque(), parte.getDocumentoRelacionado(), parte.getPlacaPatente()) != null) {
					
					errores.add(new ErrorExcel(Integer.valueOf(value.get(0)), "Error, registro PR ya existe"));
				} else {
					parte.setEstado("ACT");
					parte.setRecinto(recinto.get());
					parte.setFechaRegistro(LocalDateTime.now());
					
					ParteSumaExcel parteCreado = this.parteSumaService.saveOrUpdate(parte);
					contadorProcesadosCorrectos[0]++;
					
					if(parteCreado == null) {
						errores.add(new ErrorExcel(Integer.valueOf(value.get(0)), "Error al registrar la fila"));
					} else {
						partesSuma.add(parteCreado);
					}					
				}
			}

		});
		
		LOGGER.info("Total registros: " + data.size());
		LOGGER.info("Procesados sin error: " + contadorProcesadosCorrectos[0]);
		LOGGER.info("Registros guardados: " + partesSuma.size());
		LOGGER.info("Registros con error (no guardados): " + errores.size());
		
		ResultadoCargaExcel resultadoCargaExcel = new ResultadoCargaExcel();
		resultadoCargaExcel.setPartesSuma(partesSuma);
		resultadoCargaExcel.setProcesadosSinError(contadorProcesadosCorrectos[0]);
		resultadoCargaExcel.setRegistrosGuardados(partesSuma.size());
		resultadoCargaExcel.setRegistrosNoGuardados(errores.size());
		resultadoCargaExcel.setTotalRegistros(data.size());
		resultadoCargaExcel.setRegistrosError(errores);
		resultadoCargaExcel.setResponseCode(HttpStatus.OK);
		resultadoCargaExcel.setUploadStatus("success");
		return new ResponseEntity<ResultadoCargaExcel>(resultadoCargaExcel, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/controlPartes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> controlPartes(@Valid @RequestBody ParamControlPartes paramControlPartes) { 
		
		// armamos la fecha inicial
		LocalDateTime fechaInicioProceso = this.fechaStringToLocalDateTime(paramControlPartes.getFechaInicial() + " 00:00:00");
		LOGGER.info("fechaInicioProceso: " + fechaInicioProceso);

		// armamos la fecha final
		LocalDateTime fechaFinalProceso = this.fechaStringToLocalDateTime(paramControlPartes.getFechaFinal() + " 23:59:59");
		LOGGER.info("fechaFinalProceso: " + fechaFinalProceso);
		
		// buscamos los partes en el rango de fechas de recepción dadas
		List<ParteSumaExcel> partesSuma = new ArrayList<ParteSumaExcel>();
		partesSuma = this.parteSumaService.buscarPorFechaRecepcion(fechaInicioProceso, fechaFinalProceso);
		
		ResultadoComparaSumaVirtu resultadoComparaSumaVirtu;
		String fechaSalida = paramControlPartes.getFechaSalida().replace("-", "/");
		String fechaInicio = paramControlPartes.getFechaInicial().replace("-", "/");
		String fechaFinal = paramControlPartes.getFechaFinal().replace("-", "/");
		
		// buscar si existen en virtualbo cada registro de partesSuma
		switch (paramControlPartes.getCodRecinto()) {
		case "ALT01": {
			
			LOGGER.info("El ALTO");
			
			List<VInventarioEgr> inventarioEgresos = this.vInventarioEgrAltService.listarVInventarioEgr(
					fechaSalida, paramControlPartes.getCodRecinto(), "ACT", fechaInicio, fechaFinal);
			
			resultadoComparaSumaVirtu = this.compararPartesSumaVirtualbo(partesSuma, inventarioEgresos);
		
			break;
		}
		case "CHB01": {
			
			LOGGER.info("COCHABAMBA");
			
			List<VInventarioEgr> inventarioEgresos = this.vInventarioEgrChbService.listarVInventarioEgr(
					fechaSalida, paramControlPartes.getCodRecinto(), "ACT", fechaInicio, fechaFinal);
			
			resultadoComparaSumaVirtu = this.compararPartesSumaVirtualbo(partesSuma, inventarioEgresos);
			
			break;
		}
		case "PAM01": {
			
			LOGGER.info("PAMPA");
			
			List<VInventarioEgr> inventarioEgresos = this.vInventarioEgrSczService.listarVInventarioEgr(
					fechaSalida, paramControlPartes.getCodRecinto(), "ACT", fechaInicio, fechaFinal);
			
			resultadoComparaSumaVirtu = this.compararPartesSumaVirtualbo(partesSuma, inventarioEgresos);
			
			break;
		}
		case "VIR01": {
			LOGGER.info("VIRU VIRU");
			
			List<VInventarioEgr> inventarioEgresos = this.vInventarioEgrVirService.listarVInventarioEgr(
					fechaSalida, paramControlPartes.getCodRecinto(), "ACT", fechaInicio, fechaFinal);
			
			resultadoComparaSumaVirtu = this.compararPartesSumaVirtualbo(partesSuma, inventarioEgresos);
			
			break;
		}
		default:
			return new ResponseEntity<String>("Error. Código de recinto sin tratamiento", HttpStatus.BAD_REQUEST);
		}
				
		
		return new ResponseEntity<ResultadoComparaSumaVirtu>(resultadoComparaSumaVirtu, HttpStatus.OK);
	}
	
	
	private ResultadoComparaSumaVirtu compararPartesSumaVirtualbo(List<ParteSumaExcel> partesSuma, List<VInventarioEgr> listaEgresos) {
		
		ResultadoComparaSumaVirtu resultadoComparaSumaVirtu = new ResultadoComparaSumaVirtu();
		List<ExistenVirtualbo> listaOficialExistenVirtu = new ArrayList<>();
		List<ParteSumaExcel> listaNoExistenSuma = new ArrayList<>();
//		List<VInventarioEgr> listaExistenVirtualbo = new ArrayList<>();
//		List<ParteSuma> listaDifierenSuma = new ArrayList<>();
		
		for(ParteSumaExcel ps : partesSuma) {
			String aduanaParteSuma = ps.getAduana().getAduCod().toString();
			String gestionParteSuma = ps.getGestion().toString();
			String nroRegParteSuma = ps.getNroRegistroParte();
			
			boolean psAgregado = false;
			
			for(VInventarioEgr vie: listaEgresos) {
				
				// comparamos si el registro de suma existe en virtualbo
				if(aduanaParteSuma.equals(vie.getInvAduana()) && 
						gestionParteSuma.equals(vie.getInvGestion()) && 
						nroRegParteSuma.equals(vie.getInvNroreg())) {
					
					
//					if(vieAgregado == false) {
						// agrupamos los elementos de la lista por salida segun el parte inventario
						int bultosSaldoVirtu = 0;
						
						for(VInventarioEgr vie2: listaEgresos) {
							if(vie.getInvParte().equals(vie2.getInvParteS())) {
								bultosSaldoVirtu = bultosSaldoVirtu + vie2.getBultoSaldo().intValue();
							}
						}
						
//						vieAgregado = true;
						psAgregado = true;
//						listaExistenVirtualbo.add(vie);
						
						listaOficialExistenVirtu.add(new ExistenVirtualbo(bultosSaldoVirtu, vie));
						break;
//					}
					
				}
			}
			
			if(psAgregado == false) {
				listaNoExistenSuma.add(ps);				
			}
		}
		
		System.out.println("listaOficialExistenVirtu: " + listaOficialExistenVirtu.size());
		System.out.println("listaNoExistenVirtu: " + listaNoExistenSuma.size());
		
		resultadoComparaSumaVirtu.setListaExistenVirtu(listaOficialExistenVirtu);
		resultadoComparaSumaVirtu.setListaNoExistenSuma(listaNoExistenSuma);
		
		return resultadoComparaSumaVirtu;
	}
	
	public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
	    return java.sql.Timestamp.valueOf(dateToConvert);
	}
	
	private UsuarioParte procesarUsuarioParte(String usuario) {
		
		if(usuario.equals(" ")) {
			return null;
		}
		
		UsuarioParte usuarioParte = new UsuarioParte();
		
		this.usuarioParteService.findById(usuario).ifPresentOrElse(
				val -> {
					usuarioParte.setNombre(val.getNombre());
				},
				() -> {
					if ( this.registrarUsuarioParte(usuario) != null ) {
						usuarioParte.setNombre(usuario);					
					} else {
						usuarioParte.setNombre(null);
					}
				});
		
		return usuarioParte;
	}
	
	private UsuarioParte registrarUsuarioParte(String usuario) {
		UsuarioParte usuarioParte = new UsuarioParte();
		usuarioParte.setNombre(usuario);
		
		UsuarioParte usuarioParteCreado = this.usuarioParteService.saveOrUpdate(usuarioParte);
		
		if(usuarioParteCreado == null) {
			LOGGER.error("Error registrando usuarioParte: " + usuario);
			return null;
		}
		
		return usuarioParte;
	}

	private DestinatarioParte procesarDestinatarioParte(String destinatario) {
		
		if(destinatario.equals(" ")) {
			return null;
		}
		
		DestinatarioParte destinatarioParte = this.destinatarioParteService.buscarPorNombre(destinatario);
		
		if (destinatarioParte == null) {
			LOGGER.info("Info destinatario parte no registrado: " + destinatario);
			
			// si no lo encontramos lo creamos
			destinatarioParte = new DestinatarioParte();
			destinatarioParte.setNombre(destinatario);
			destinatarioParte = this.destinatarioParteService.saveOrUpdate(destinatarioParte);
			
			if (destinatarioParte == null) {
				LOGGER.info("Error registrando Destinatario: " + destinatario);
				return null;
			}
		}
		
		return destinatarioParte;
	}

	private LocalDateTime procesarFechaRecepcion(String fecha) {
		LocalDateTime dateTime = LocalDateTime.parse(fecha);

		return dateTime;
	}

	// se procesa el PR devolviendo el objeto ParteSuma con los datos de
	// parteRecepcion, gestion, nroRegistroParte y aduana llenados
	private ParteSumaExcel procesarPR(String pr) {		
		ParteSumaExcel parte = new ParteSumaExcel();

		// separamos la cadena de texto del PR
		String[] cadenaParte = pr.split("-");
		
		this.aduanaService.findById(Integer.valueOf(cadenaParte[2])).ifPresentOrElse(
				value -> parte.setAduana(value),
				() -> {
					LOGGER.error("Error código de aduana no registrado: " + cadenaParte[2]);
					Aduana aduanaCreada = this.registrarAduana(Integer.valueOf(cadenaParte[2]));
					if(aduanaCreada != null) {
						parte.setAduana(aduanaCreada);
					} else {
						LOGGER.error("Error al registrtar código de aduana: " + cadenaParte[2]);
						parte.setAduana(null);
					}
				});

		parte.setGestion(Integer.valueOf(cadenaParte[1]));
		parte.setParteRecepcion(pr);
		parte.setNroRegistroParte(cadenaParte[3]);

		return parte;
	}
	
	private Aduana registrarAduana(Integer codAduana) {
		Aduana aduana = new Aduana();
		aduana.setAduCod(codAduana);
		aduana.setAduEstado("ACT");
		
		Aduana aduanaCreada = this.aduanaService.saveOrUpdate(aduana);
		
		if(aduanaCreada == null) {
			LOGGER.error("Error registrando aduana: " + codAduana);
			return null;
		}
		
		return aduana;
	}

	// lee un archivo excel con los datos de los partes de suma
	private Map<Integer, List<String>> readExcelFile(MultipartFile excelFile) {
		try {
			InputStream file = new BufferedInputStream(excelFile.getInputStream());
			Workbook workbook = new XSSFWorkbook(file);

			Sheet sheet = workbook.getSheetAt(0);

			Map<Integer, List<String>> data = new HashMap<>();
			int i = 0;
			for (Row row : sheet) {
				data.put(i, new ArrayList<String>());
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case STRING:
						data.get(Integer.valueOf(i)).add(cell.getRichStringCellValue().getString());
						break;
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							data.get(i).add(
									this.convertToLocalDateTimeViaSqlTimestamp(
											cell.getDateCellValue()).toString()
									);
						} else {
							data.get(i).add(this.formatNumeric(cell.getNumericCellValue()));
						}
						break;
					case BOOLEAN:
						data.get(i).add(cell.getBooleanCellValue() + "");
						break;
					case FORMULA:
						data.get(i).add(cell.getCellFormula() + "");
						break;
					default:
						data.get(Integer.valueOf(i)).add(" ");
					}
				}
				i++;
			}

			if (workbook != null) {
				workbook.close();
			}

			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	LocalDateTime convertToLocalDateTimeViaSqlTimestamp(Date dateToConvert) {
	    return new java.sql.Timestamp(
	      dateToConvert.getTime()).toLocalDateTime();
	}
	
	public String formatNumeric(double valor) {
		DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.getDefault()));
		df.setMaximumFractionDigits(340); //340 = DecimalFormat.DOUBLE_FRACTION_DIGITS

		return df.format(valor);
	}
	
	/**
	 * funcion q convierte un texto con la fecha a LocalDateTime
	 */
	public LocalDateTime fechaStringToLocalDateTime(String cadenaFecha) {
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime fechaconvertida = LocalDateTime.parse(cadenaFecha, formatoFecha);
		return fechaconvertida;
	}
	
	public Date fechaStringToDate(String cadenaFecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
		try {
//			Date date = formatter.parse(cadenaFecha);
			return formatter.parse(cadenaFecha);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
