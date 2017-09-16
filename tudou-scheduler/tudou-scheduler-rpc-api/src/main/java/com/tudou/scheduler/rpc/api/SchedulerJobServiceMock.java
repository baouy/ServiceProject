package com.tudou.scheduler.rpc.api;

import com.tudou.scheduler.dao.model.ScheduleJob;
import org.quartz.SchedulerException;

import java.util.List;

public class SchedulerJobServiceMock implements SchedulerJobService{

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
		return null;
	}

	@Override
	public List<ScheduleJob> getScheduleJob(ScheduleJob scheduleJob) throws SchedulerException {
		return null;
	}
}
