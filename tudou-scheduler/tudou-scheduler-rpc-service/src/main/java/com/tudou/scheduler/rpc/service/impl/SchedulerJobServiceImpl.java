package com.tudou.scheduler.rpc.service.impl;

import com.tudou.scheduler.rpc.api.SchedulerJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class SchedulerJobServiceImpl implements SchedulerJobService{

	@Autowired(required = false)
	private SchedulerFactoryBean schedulerFactoryBean;



}
