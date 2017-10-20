package com.tudou.oa.service.controller.act;

import com.tudou.common.base.BaseController;
import com.tudou.oa.common.constant.OaResult;
import com.tudou.oa.common.constant.OaResultConstant;
import com.tudou.oa.service.controller.act.service.ActProcessService;
import com.tudou.oa.service.modelvalid.ProcessRunValid;
import com.tudou.oa.service.modelvalid.ProcessValid;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.repository.Model;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 流程定义相关Controller
 */
@Controller
@RequestMapping(value = "/act/process")
public class ActProcessController extends BaseController {

	@Resource
	private ActProcessService actProcessService;

	/**
	 * 流程定义列表
	 */
	@ApiOperation(value = "流程列表")
	@RequiresPermissions("act:process:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object processList(@ModelAttribute ProcessValid processValid) {

		int pc = processValid.getPageCurrent();
		int ps = processValid.getPageSize();

		List<ProcessValid> list = actProcessService.processList(processValid,pc,ps);

		return new OaResult(OaResultConstant.SUCCESS,list,pc,ps,processValid.getMaxunum());
	}

	/**
	 * 运行中的实例列表
	 */
	@ApiOperation(value = "运行中的实例列表")
	@RequiresPermissions("act:process:read")
	@RequestMapping(value = "running")
	@ResponseBody
	public Object runningList(@ModelAttribute ProcessRunValid processRunValid) {

		int pc = processRunValid.getPageCurrent();
		int ps = processRunValid.getPageSize();

		List<ProcessRunValid> list = actProcessService.runningList(processRunValid,pc,ps);

		return new OaResult(OaResultConstant.SUCCESS,list,pc,ps,processRunValid.getMaxnum());
	}


	/**
	 * 将部署的流程转换为模型
	 * @param procDefId
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws XMLStreamException
	 */
	@ApiOperation(value = "部署的流程转换为模型")
	@RequiresPermissions("act:process:model")
	@RequestMapping(value = "convert/toModel")
	@ResponseBody
	public Object convertToModel(String procDefId) throws UnsupportedEncodingException, XMLStreamException {
		Model modelData = actProcessService.convertToModel(procDefId);
		return new OaResult(OaResultConstant.SUCCESS,"转换模型成功，模型ID="+modelData.getId());
	}

	/**
	 * 挂起、激活流程实例
	 */
	@ApiOperation(value = "挂起、激活流程")
	@RequiresPermissions("act:process:suspended")
	@RequestMapping(value = "update/{state}")
	@ResponseBody
	public Object updateState(@PathVariable("state") String state, String procDefId) {
		String message = actProcessService.updateState(state, procDefId);
		return new OaResult(OaResultConstant.SUCCESS,message);
	}

	/**
	 * 删除部署的流程，级联删除流程实例
	 * @param deploymentId 流程部署ID
	 */
	@ApiOperation(value = "删除流程")
	@RequiresPermissions("act:process:delete")
	@RequestMapping(value = "delete")
	@ResponseBody
	public Object delete(String deploymentId) {
		actProcessService.deleteDeployment(deploymentId);
		return new OaResult(OaResultConstant.SUCCESS,null);
	}

	/**
	 * 读取资源，通过部署ID
	 * @param procDefId  流程定义ID
	 * @param proInsId 流程实例ID
	 * @param resType 资源类型(xml|image)
	 * @param response
	 * @throws Exception
	 */
	@RequiresPermissions("act:process:read")
	@RequestMapping(value = "resource/read")
	public void resourceRead(String procDefId, String proInsId, String resType, HttpServletResponse response) throws Exception {
		InputStream resourceAsStream = actProcessService.resourceRead(procDefId, proInsId, resType);
		byte[] b = new byte[1024];
		int len = -1;
		while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}

	/**
	 * 部署流程 - 保存
	 * @param file
	 * @return
	 */
	@ApiOperation(value = "部署流程")
	@RequiresPermissions("act:process:read")
	@RequestMapping(value = "/deploy", method=RequestMethod.POST)
	@ResponseBody
	public Object deploy(String category, MultipartFile file) {
		int num = actProcessService.deploy(category, file);
		if (num == 0){
			return new OaResult(OaResultConstant.FAILED,"部署失败");
		}else if(num == 2){
			return new OaResult(OaResultConstant.FAILED,"不支持的文件类型");
		}else{
			return new OaResult(OaResultConstant.SUCCESS,"操作成功");
		}
	}

	/**
	 * 删除流程实例
	 * @param procInsId 流程实例ID
	 * @param reason 删除原因
	 */
	@ApiOperation(value = "删除流程实例")
	@RequiresPermissions("act:process:edit")
	@RequestMapping(value = "deleteProcIns")
	@ResponseBody
	public Object deleteProcIns(String procInsId, String reason) {

		actProcessService.deleteProcIns(procInsId, reason);

		return new OaResult(OaResultConstant.SUCCESS,"操作成功");
	}



}
