package com.albo.controlop.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.albo.controlop.model.Tarea;
import com.albo.controlop.service.ITareaService;

@Service
public class ScheduleTaskService {
	
	private static final Logger LOGGER = LogManager.getLogger(ScheduleTaskService.class);

	// Task Scheduler
    TaskScheduler scheduler;
    
    @Autowired
	private ITareaService tareaService;
    
    @Autowired
	private ScheduleTaskService scheduleTaskService;
    
    @Autowired
	private ProcesoService procesoService;

    // A map for keeping scheduled tasks
    Map<Long, ScheduledFuture<?>> jobsMap = new HashMap<>();

    public ScheduleTaskService(TaskScheduler scheduler) {
        this.scheduler = scheduler;
    }
    
    // Schedule Task to be executed every night at 00 or 12 am
    public void addTaskToScheduler(Long id, Runnable task, String cron) {
    	CronTrigger trigger = new CronTrigger(cron);
        ScheduledFuture<?> scheduledTask = scheduler.schedule(task, trigger);
        jobsMap.put(id, scheduledTask);
    }
    
    // Remove scheduled task
    public void removeTaskFromScheduler(Long id) {
        ScheduledFuture<?> scheduledTask = jobsMap.get(id);
        if (scheduledTask != null) {
            scheduledTask.cancel(true);
            jobsMap.put(id, null);
        }
    }
    
    // A context refresh event listener
    @EventListener({ContextRefreshedEvent.class})
    void contextRefreshedEvent() {
    	// Get all tasks from DB and reschedule them in case of context restarted
    	LOGGER.info("Reprogramando tareas desde BD...");
    	List<Tarea> tareas = this.tareaService.findAll();
    	
    	for(Tarea tarea : tareas) {
    		switch(tarea.getTipo()) {
				case "CARGA_PARTES_SUMA": {
					
					this.scheduleTaskService.addTaskToScheduler(
							tarea.getId(), 
							() -> this.procesoService.procesoCargaParteSuma(tarea), 
							tarea.getCron()
					);
					
					LOGGER.info("Tarea creada -> " + tarea.getNombre());					
					break;
				}
				default: {
					LOGGER.error("Tipo de tarea inexistente");
				}
			}
    	}
    }
}
