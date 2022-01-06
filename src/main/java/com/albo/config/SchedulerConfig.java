package com.albo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {
	
//	private static final Logger LOGGER = LogManager.getLogger(SchedulerConfig.class);
	
//	@Autowired
//	private ITareaService tareaService;

	
	// obtenemos el valor del cron por recinto
//	public String getCronValue(String codRecinto, String tipoTarea) {
//		String cronValue = "0 30 8 * * ?";
//		
//		Tarea tarea = this.tareaService.buscarPorNombre(codRecinto, tipoTarea);
//		
//        if (tarea != null && !tarea.getCron().isEmpty()) {
//        	cronValue = tarea.getCron();
//        }
//	    return cronValue;
//	}

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
