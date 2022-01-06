package com.albo.controlop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albo.controlop.impl.ScheduleTaskService;
import com.albo.controlop.model.Tarea;
import com.albo.controlop.service.ITareaService;
import com.albo.exception.ModeloNotFoundException;

@RestController
@RequestMapping("/tarea")
public class TareaController {
	
	private static final Logger LOGGER = LogManager.getLogger(TareaController.class);
	
	@Autowired
	private ITareaService tareaService;
	
	@Autowired
	private ScheduleTaskService scheduleTaskService;
	
	
	@GetMapping(value = "/obtenerTareas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tarea>> listarTareas() {
		List<Tarea> tareas = new ArrayList<>();
		tareas = tareaService.findAll();
		
		return new ResponseEntity<List<Tarea>>(tareas, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/crearTarea", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> crearTarea(@Valid @RequestBody Tarea tarea) {	
		Tarea tareaCreada = this.tareaService.saveOrUpdate(tarea);
		
		if(tareaCreada != null) {
			this.scheduleTaskService.addTaskToScheduler(
					tareaCreada.getId(), 
					() -> System.out.println("my task is running -> 1"), 
					tarea.getCron()
					);
			
			LOGGER.info("Tarea creada");
		} else {
			return new ResponseEntity<>("Error al crear tarea", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(tareaCreada, HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/modificarTarea", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizarTarea(@RequestBody Tarea tarea) {
		Tarea tareaModificada = this.tareaService.saveOrUpdate(tarea);
		
		if(tareaModificada != null) {
			// eliminamos la tarea y la volvemos a crear en el schedule
			this.scheduleTaskService.removeTaskFromScheduler(tarea.getId());
			this.scheduleTaskService.addTaskToScheduler(
					tarea.getId(), 
					() -> System.out.println("my task is running -> 1"), 
					tarea.getCron()
					);			
		} else {
			return new ResponseEntity<>("Error al modificar en BD ó el registro no existe", HttpStatus.NOT_MODIFIED);
		}
		
		return new ResponseEntity<>(tareaModificada, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> eliminarTarea(@PathVariable Long id) {
		if ( this.tareaService.deleteById(id) ) {
			this.scheduleTaskService.removeTaskFromScheduler(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			throw new ModeloNotFoundException("ID: " + id);
		}
	}

}
