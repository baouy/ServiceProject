package com.tudou.scheduler.rpc.service.impl;

import com.tudou.scheduler.dao.model.ScheduleJob;
import com.tudou.scheduler.rpc.api.SchedulerJobService;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SchedulerJobServiceImpl implements SchedulerJobService{

	@Autowired(required = false)
	private SchedulerFactoryBean schedulerFactoryBean;


	@Override
	public void scheduleCronJobs() throws SchedulerException {

	}

	@Override
	public List<ScheduleJob> getRunningJobs() throws SchedulerException {
		return null;
	}

	@Override
	public void pauseJob(ScheduleJob scheduleJob) throws SchedulerException {

	}

	@Override
	public void resumeJob(ScheduleJob scheduleJob) throws SchedulerException {

	}

	@Override
	public void deleteJob(ScheduleJob scheduleJob) throws SchedulerException {

	}

	@Override
	public void triggerJob(ScheduleJob scheduleJob) throws SchedulerException {

	}

	@Override
	public void rescheduleJob(ScheduleJob scheduleJob) throws SchedulerException {

	}

	@Override
	public void scheduleCronNewJob(ScheduleJob scheduleJob) throws SchedulerException, ClassNotFoundException {

	}

	@Override
	public void scheduleSingleJob(ScheduleJob scheduleJob) throws SchedulerException, ClassNotFoundException {

	}

	@Override
	public void scheduleCronSingleJob(ScheduleJob scheduleJob) throws SchedulerException, ClassNotFoundException {

	}

	@Override
	public List getAllJobs() throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
		Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
		List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();
		for (JobKey jobKey : jobKeys) {
			List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
			for (Trigger trigger : triggers) {
				ScheduleJob job = new ScheduleJob();
				job.setJobId(jobKey.getGroup() + "_" + jobKey.getName());
//				if (!StrUtil.isEmpty(jobId)&&job.getJobId().indexOf(jobId) == -1) {
//					continue;
//				}
				job.setJobName(jobKey.getName());
				job.setJobGroup(jobKey.getGroup());
				job.setDesc(trigger.getDescription());
//				job.setJobClass(scheduler.getJobDetail(jobKey).getJobClass().getName());
				Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
				job.setJobStatus(triggerState.name());

				if (trigger instanceof CronTrigger) {
					job = getCronJob(job, trigger);
				} else if (trigger instanceof SimpleTrigger) {
					SimpleTrigger simpleTrigger = (SimpleTrigger) trigger;
					job.setTriggerType("SimpleTrigger");
					job.setStartTime(simpleTrigger.getStartTime());
					job.setEndTime(simpleTrigger.getEndTime());
					String repeatType = null;
					if (simpleTrigger.getDescription() != null && simpleTrigger.getDescription().indexOf("repeatType:") > -1) {
						repeatType = simpleTrigger.getDescription().substring(
								simpleTrigger.getDescription().indexOf("repeatType:") + 11);
					}
					job.setRepeatType(repeatType);
					job.setRepeatCount(simpleTrigger.getRepeatCount());
					job.setRepeatInterval((int) simpleTrigger.getRepeatInterval());
					if (repeatType != null && repeatType.indexOf("Secondly") > -1)
						job.setRepeatIntervalStr(((int) simpleTrigger.getRepeatInterval() / 1000) + "秒");
					else if (repeatType != null && repeatType.indexOf("Minutely") > -1)
						job.setRepeatIntervalStr((int) simpleTrigger.getRepeatInterval() / 60000 + "分钟");
					else if (repeatType != null && repeatType.indexOf("Hourly") > -1)
						job.setRepeatIntervalStr((int) simpleTrigger.getRepeatInterval() / 3600000 + "小时");
					job.setTriggerName(simpleTrigger.getKey().getName());
					job.setTriggerGroup(simpleTrigger.getKey().getGroup());
					int index=job.getDesc().indexOf(";repeatType:")>-1?job.getDesc().indexOf(";repeatType:"):job.getDesc().length();
					job.setDesc(job.getDesc().substring(0,index));
				}
				jobList.add(job);
			}
		}
		return jobList;
	}

	@Override
	public List<ScheduleJob> getScheduleJob(ScheduleJob scheduleJob) throws SchedulerException {
		return null;
	}

	public ScheduleJob getCronJob(ScheduleJob job, Trigger trigger) {
		CronTrigger cronTrigger = (CronTrigger) trigger;
		String cronExpression = cronTrigger.getCronExpression();
		job.setCronExpression(cronExpression);
		job.setTriggerType("CronTrigger");
		job.setStartTime(cronTrigger.getStartTime());
		job.setEndTime(cronTrigger.getEndTime());
		job.setTriggerName(cronTrigger.getKey().getName());
		job.setTriggerGroup(cronTrigger.getKey().getGroup());
		return job;
	}
}
