package com.tudou.scheduler.pojo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class QuartzJobTest implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(new Date()+":----hello world----");
		//ScheduleJob scheduleJob=(ScheduleJob)context.getMergedJobDataMap().get("scheduleJob");
		//System.out.println("任务名称=["+scheduleJob.getJobName()+"]");
		
	}
	

}