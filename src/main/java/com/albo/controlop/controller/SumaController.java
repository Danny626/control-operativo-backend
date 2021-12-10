package com.albo.controlop.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.albo.controlop.dto.BodyLoginSuma;
import com.albo.controlop.dto.ResultLoginSuma;

@RestController
@RequestMapping("/suma")
public class SumaController {

	private static final Logger LOGGER = LogManager.getLogger(SumaController.class);
	private final String URI_LOGIN_SUMA = "/b-sso/rest/autenticar/portal?operador=ip";

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping(
			value = "/loginSuma", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> loginSuma(@RequestBody BodyLoginSuma bodyLoginSuma) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"");
		headers.set("Accept", "application/json, text/plain, */*");
		headers.set("Content-Type", "application/json;charset=UTF-8");
		headers.set("User", bodyLoginSuma.getNombreUsuario());
		headers.set("sec-ch-ua-mobile", "?0");
		headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36");
		headers.set("sec-ch-ua-platform", "\"Windows\"");
		
		headers.set("Connection", "keep-alive");
//		headers.set("Accept-Encoding", "gzip, deflate, br");
		
		RequestEntity<?> request = RequestEntity
			     .post(URI_LOGIN_SUMA)
			     .headers(headers)
			     .body(bodyLoginSuma);

		ResponseEntity<ResultLoginSuma> response = restTemplate.exchange(
				request,
				ResultLoginSuma.class);

		switch (response.getStatusCode()) {
		case OK:
			return new ResponseEntity<>(response, HttpStatus.OK);
		default:
			LOGGER.error("Error login SUMA: " + response.getStatusCode());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping(
			value = "/descargaPartesSuma", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> servicioLoginSuma() {

		return null;
	}

}
