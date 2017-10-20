package com.tudou.scheduler.server.controller;

import com.tudou.common.base.BaseController;
import com.tudou.scheduler.common.constant.SchedulerResult;
import com.tudou.scheduler.common.constant.SchedulerResultConstant;
import com.tudou.scheduler.dao.model.ScheduleJob;
import com.tudou.scheduler.rpc.api.SchedulerJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
	@RequiresPermissions("qrtz:scheduler:read")
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

	@ApiOperation(value = "任务调度详情")
	@RequiresPermissions("qrtz:scheduler:update")
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody
	public Object detail(@ModelAttribute ScheduleJob scheduleJob) {
		try {
			List<ScheduleJob> jobList = schedulerJobService.getScheduleJob(scheduleJob);
			return new SchedulerResult(SchedulerResultConstant.SUCCESS,jobList.get(0));
		}catch (Exception e){
			return new SchedulerResult(SchedulerResultConstant.SERVICE_ERROR,null);
		}
	}

	@ApiOperation(value = "任务调度保存")
	@RequiresPermissions(value = {"qrtz:scheduler:create","qrtz:scheduler:update"} , logical = Logical.OR)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@ModelAttribute ScheduleJob scheduleJob) {
		try {
			schedulerJobService.scheduleSingleJob(scheduleJob);
			return new SchedulerResult(SchedulerResultConstant.SUCCESS,null);
		}catch (Exception e){
			return new SchedulerResult(SchedulerResultConstant.SERVICE_ERROR,null);
		}
	}

	@ApiOperation(value = "暂停任务")
	@RequiresPermissions("qrtz:scheduler:pause")
	@RequestMapping(value = "/pause", method = RequestMethod.POST)
	@ResponseBody
	public Object pause(@ModelAttribute ScheduleJob scheduleJob) {
		try {
			schedulerJobService.pauseJob(scheduleJob);
			return new SchedulerResult(SchedulerResultConstant.SUCCESS,null);
		}catch (Exception e){
			return new SchedulerResult(SchedulerResultConstant.SERVICE_ERROR,null);
		}
	}

	@ApiOperation(value = "恢复任务")
	@RequiresPermissions("qrtz:scheduler:restore")
	@RequestMapping(value = "/restore", method = RequestMethod.POST)
	@ResponseBody
	public Object restore(@ModelAttribute ScheduleJob scheduleJob) {
		try {
			schedulerJobService.resumeJob(scheduleJob);
			return new SchedulerResult(SchedulerResultConstant.SUCCESS,null);
		}catch (Exception e){
			return new SchedulerResult(SchedulerResultConstant.SERVICE_ERROR,null);
		}
	}

	@ApiOperation(value = "删除任务")
	@RequiresPermissions("qrtz:scheduler:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@ModelAttribute ScheduleJob scheduleJob) {
		try {
			schedulerJobService.deleteJob(scheduleJob);
			return new SchedulerResult(SchedulerResultConstant.SUCCESS,null);
		}catch (Exception e){
			return new SchedulerResult(SchedulerResultConstant.SERVICE_ERROR,null);
		}
	}

	@ApiOperation(value = "运行一次任务")
	@RequiresPermissions("qrtz:scheduler:trigger")
	@RequestMapping(value = "/trigger", method = RequestMethod.POST)
	@ResponseBody
	public Object trigger(@ModelAttribute ScheduleJob scheduleJob) {
		try {
			schedulerJobService.triggerJob(scheduleJob);
			return new SchedulerResult(SchedulerResultConstant.SUCCESS,null);
		}catch (Exception e){
			return new SchedulerResult(SchedulerResultConstant.SERVICE_ERROR,null);
		}
	}


}
