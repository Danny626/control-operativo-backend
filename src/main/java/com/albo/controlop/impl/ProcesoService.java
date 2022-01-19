package com.albo.controlop.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.albo.controlop.controller.SumaController;
import com.albo.controlop.controller.TareaController;
import com.albo.controlop.dto.BodyRegistroPartesSuma;
import com.albo.controlop.dto.ResultadoRegistroPartesSuma;
import com.albo.controlop.model.Tarea;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public class ProcesoService {
	
	private static final Logger LOGGER = LogManager.getLogger(TareaController.class);
	
	@Autowired
	private SumaController sumaController;
	
	@Bean 
	ObjectMapper objectMapper() { 
		ObjectMapper objectMapper = new ObjectMapper(); 
		objectMapper.registerModule(new JavaTimeModule()); 
		return objectMapper; 
	}

	// realiza el proceso de carga de partes Suma
	public void procesoCargaParteSuma(Tarea tarea) {
		
		BodyRegistroPartesSuma bodyRegistroPartesSuma = new BodyRegistroPartesSuma();
//		ObjectMapper objectMapper = new ObjectMapper();
		
//		Tarea tarea = this.tareaService.buscarPorNombre(codRecinto, tipoTarea);
		
		try {
			bodyRegistroPartesSuma = this.objectMapper().readValue(tarea.getBody(), BodyRegistroPartesSuma.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			LOGGER.error("Error. El cuerpo para el registro de partes suma no es correcto");
		}
		
		ResponseEntity<Object> responseCargaPS = this.sumaController.cargaPartesSuma(bodyRegistroPartesSuma);
		
		if(responseCargaPS.getStatusCode() != HttpStatus.OK) {
			LOGGER.error(responseCargaPS.getBody());
		} else {
			ResultadoRegistroPartesSuma resultadoRegistroPartesSuma = (ResultadoRegistroPartesSuma) responseCargaPS.getBody(); 
			LOGGER.info("Recinto: " + tarea.getRecinto().getRecCod() + ". " + resultadoRegistroPartesSuma.getRegistrosGuardados() + " registros guardados o modificados de " + resultadoRegistroPartesSuma.getTotalRegistros());
		}
	}
}
