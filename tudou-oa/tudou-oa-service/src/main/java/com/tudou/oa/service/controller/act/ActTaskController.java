package com.tudou.oa.service.controller.act;

import com.tudou.common.base.BaseController;
import com.tudou.oa.common.constant.OaResult;
import com.tudou.oa.common.constant.OaResultConstant;
import com.tudou.oa.service.controller.act.service.ActTaskService;
import com.tudou.oa.service.modelvalid.ActTaskValid;
import com.tudou.oa.service.modelvalid.ProcessValid;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流程个人任务相关Controller
 */
@Controller
@RequestMapping(value = "/act/task")
public class ActTaskController extends BaseController {

	@Resource
	private ActTaskService actTaskService;

	@ApiOperation(value = "获取待办列表")
	@RequiresPermissions("oa:office:read")
	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	@ResponseBody
	public Object todoList(@ModelAttribute ActTaskValid act) throws Exception {

		List<ActTaskValid> taskValids = actTaskService.todoList(act);

		return new OaResult(OaResultConstant.SUCCESS,taskValids);
	}


	@ApiOperation(value = "流程列表")
	@RequiresPermissions("oa:office:read")
	@RequestMapping(value = "/process", method = RequestMethod.GET)
	@ResponseBody
	public Object processList(@ModelAttribute ProcessValid processValid) {

		int pc = processValid.getPageCurrent();
		int ps = processValid.getPageSize();

		List<ProcessValid> list = actTaskService.processList(processValid,pc,ps);

		return new OaResult(OaResultConstant.SUCCESS,list,pc,ps,processValid.getMaxunum());
	}

	@ApiOperation(value = "流程列表")
	@RequiresPermissions("oa:office:edit")
	@RequestMapping(value = "form")
	@ResponseBody
	public Object form(@ModelAttribute ActTaskValid act){
		// 获取流程XML上的表单KEY
		String formKey = actTaskService.getFormKey(act.getProcDefId(), act.getTaskDefKey());
		if (formKey.equals("404") || StringUtils.isBlank(formKey)){
			return new OaResult(OaResultConstant.FAILED,"没有表格开启,请联系管理员! 错误key为:"+formKey);
		}else{
			return new OaResult(OaResultConstant.SUCCESS,formKey);
		}

	}

}
