package com.bhawesh;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
@ComponentScan(basePackages="com.bhawesh.*")
public class ScheduledJobsConfig implements SchedulingConfigurer{

	@Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
       
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
    	
    	 ThreadPoolTaskScheduler scheduledExecutorService = new ThreadPoolTaskScheduler();
         // always set the poolsize
         scheduledExecutorService.setPoolSize(10);
         // for logging add a threadNamePrefix
         scheduledExecutorService.setThreadNamePrefix("myTaskScheduler-");
         // do not wait for completion of the task
         scheduledExecutorService.setWaitForTasksToCompleteOnShutdown(true);

       
         return scheduledExecutorService;
    }
    

}
