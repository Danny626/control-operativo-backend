package com.albo.config;

import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import com.albo.controlop.controller.SumaController;
import com.albo.controlop.dto.BodyRegistroPartesSuma;
import com.albo.controlop.dto.ResultadoRegistroPartesSuma;
import com.albo.controlop.model.Tarea;
import com.albo.controlop.service.ITareaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {
	
	private static final Logger LOGGER = LogManager.getLogger(SchedulerConfig.class);
	private static final String tipoCargaPartesSuma = "CARGA_PARTES_SUMA";
	
	@Autowired
	private SumaController sumaController;
	
	@Autowired
	private ITareaService tareaService;

	
//	@Scheduled(cron = "0 30 8 * * ?")
	public void taskCargarPartesSumaAlt() {		
		this.procesoCargaParteSuma("ALT01", tipoCargaPartesSuma);		
	}
	
	public void taskCargarPartesSumaChb() {		
		this.procesoCargaParteSuma("CHB01", tipoCargaPartesSuma);		
	}
	
	public void taskCargarPartesSumaVir() {		
		this.procesoCargaParteSuma("VIR01", tipoCargaPartesSuma);		
	}
	
	public void taskCargarPartesSumaScz() {		
		this.procesoCargaParteSuma("SCZ01", tipoCargaPartesSuma);		
	}
	
	public void taskCargarPartesSumaTam() {		
		this.procesoCargaParteSuma("TAM01", tipoCargaPartesSuma);		
	}
	
	public void taskCargarPartesSumaScr() {		
		this.procesoCargaParteSuma("SCR01", tipoCargaPartesSuma);		
	}
	
	public void taskCargarPartesSumaYac() {		
		this.procesoCargaParteSuma("YAC01", tipoCargaPartesSuma);		
	}
	
	public void taskCargarPartesSumaVil() {		
		this.procesoCargaParteSuma("VIL01", tipoCargaPartesSuma);		
	}
	
	public void taskCargarPartesSumaAva() {		
		this.procesoCargaParteSuma("AVA01", tipoCargaPartesSuma);		
	}
	
	public void taskCargarPartesSumaBer() {		
		this.procesoCargaParteSuma("BER01", tipoCargaPartesSuma);		
	}
	
	public void taskCargarPartesSumaPsg() {		
		this.procesoCargaParteSuma("PSG01", tipoCargaPartesSuma);		
	}
	
	// realiza el proceso de carga de partes Suma
	private void procesoCargaParteSuma(String codRecinto, String tipoTarea) {
		BodyRegistroPartesSuma bodyRegistroPartesSuma = new BodyRegistroPartesSuma();
		ObjectMapper objectMapper = new ObjectMapper();
		
		Tarea tarea = this.tareaService.buscarPorNombre(codRecinto, tipoTarea);
		try {
			bodyRegistroPartesSuma = objectMapper.readValue(tarea.getBody(), BodyRegistroPartesSuma.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			LOGGER.error("Error. El cuerpo par el registro de partes suma no es correcto");
		}
		
		ResponseEntity<Object> responseCargaPS = this.sumaController.cargaPartesSuma(bodyRegistroPartesSuma);
		
		if(responseCargaPS.getStatusCode() != HttpStatus.OK) {
			LOGGER.error(responseCargaPS.getBody());
		} else {
			ResultadoRegistroPartesSuma resultadoRegistroPartesSuma = (ResultadoRegistroPartesSuma) responseCargaPS.getBody(); 
			LOGGER.info("Recinto: " + codRecinto + ". " + resultadoRegistroPartesSuma.getRegistrosGuardados() + " registros guardados o modificados de " + resultadoRegistroPartesSuma.getTotalRegistros());
		}
	}
	
	// obtenemos el valor del cron por recinto
	public String getCronValue(String codRecinto, String tipoTarea) {
		String cronValue = "0 30 8 * * ?";
		
		Tarea tarea = this.tareaService.buscarPorNombre(codRecinto, tipoTarea);
		
        if (tarea != null && !tarea.getCron().isEmpty()) {
        	cronValue = tarea.getCron();
        }
	    return cronValue;
	}

//	@Override
//	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//		taskRegistrar.addTriggerTask(new Runnable() {
//            @Override
//            public void run() {
//            	System.out.println("Running Schedular..." + Calendar.getInstance().getTime());
//            }
//        }, new Trigger() {
//            @Override
//            public Date nextExecutionTime(TriggerContext triggerContext) {
//            	Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
//            	LOGGER.info("Útima ejecución de tarea: " + lastActualExecutionTime);
//            	
//                String cron = getCronValue("ALT01", tipoCargaPartesSuma);
//                LOGGER.info(cron);
//                CronTrigger trigger = new CronTrigger(cron);
//                Date nextExec = trigger.nextExecutionTime(triggerContext);
//                return nextExec;
//            }
//        });
//	}
	
	@Bean
	public TaskScheduler taskScheduler() {
	    ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
	    threadPoolTaskScheduler.setPoolSize(11);
	    threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
	    return threadPoolTaskScheduler;
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// TODO Auto-generated method stub		
	}

}
