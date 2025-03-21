package com.jacubavicius.quartz_scheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {

	@Bean 
	public Scheduler scheduler() throws SchedulerException {
		JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
				.withIdentity("job01")
				.storeDurably()
				.build();
		
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger01")
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInMinutes(1)
						.repeatForever())
				.build();
		
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
		
		return scheduler;
	}
}
