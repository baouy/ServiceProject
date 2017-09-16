package com.tudou.scheduler.server.controller;

import com.tudou.common.base.BaseController;
import com.tudou.scheduler.common.constant.SchedulerResult;
import com.tudou.scheduler.common.constant.SchedulerResultConstant;
import com.tudou.scheduler.dao.model.ScheduleJob;
import com.tudou.scheduler.rpc.api.SchedulerJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "任务调度管理", description = "任务调度管理")
@RequestMapping("/manage/qrtz")
public class SchedulerController extends BaseController{

	@Autowired
	private SchedulerJobService schedulerJobService;

	@ApiOperation(value = "任务调度列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(@ModelAttribute ScheduleJob scheduleJob) {
		try {
			List<ScheduleJob> scheduleJobs = schedulerJobService.getAllJobs();
			return new SchedulerResult(SchedulerResultConstant.SUCCESS,scheduleJobs);
		}catch (Exception e){
			return new SchedulerResult(SchedulerResultConstant.SERVICE_ERROR,null);
		}
	}




}
