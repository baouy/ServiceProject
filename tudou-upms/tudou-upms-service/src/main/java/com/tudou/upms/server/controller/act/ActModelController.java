package com.tudou.upms.server.controller.act;

import com.tudou.common.base.BaseController;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.server.controller.act.service.ActModelService;
import com.tudou.upms.server.modelvalid.ModelValid;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.activiti.engine.repository.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 流程模型相关Controller
 */
@Controller
@RequestMapping(value = "/act/model")
public class ActModelController extends BaseController {

	@Autowired
	private ActModelService actModelService;

	/**
	 * 流程模型列表
	 */
	@ApiOperation(value = "模型列表")
	@RequiresPermissions("act:model:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object modelList(@ModelAttribute ModelValid modelValid) {

		int pc = modelValid.getPageCurrent();
		int ps = modelValid.getPageSize();
		List<Model> models = actModelService.modelList(modelValid,pc,ps);

		return new UpmsResult(UpmsResultConstant.SUCCESS,models,modelValid.getPageSize(),modelValid.getPageCurrent(),modelValid.getMaxnum());
	}

	@ApiOperation(value = "创建模型")
	@RequiresPermissions(value = {"act:model:create","act:model:update"}, logical = Logical.OR)
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Object create(@ModelAttribute ModelValid modelValid) {
		try {
			Model modelData = actModelService.create(modelValid.getName(), modelValid.getKey(), modelValid.getDescription(), modelValid.getCategory());
			return new UpmsResult(UpmsResultConstant.SUCCESS,"/act/process-editor/modeler.jsp?modelId=" + modelData.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new UpmsResult(UpmsResultConstant.PERMISSIONS_403,null);
	}

	@ApiOperation(value = "部署模型")
	@RequiresPermissions("act:model:deploy")
	@RequestMapping(value = "/deploy",method = RequestMethod.POST)
	@ResponseBody
	public Object deploy(@RequestParam  String id) {
		String message = actModelService.deploy(id);
		return new UpmsResult(UpmsResultConstant.SUCCESS,message);
	}


	@ApiOperation(value = "导出模型")
	@RequiresPermissions("act:model:export")
	@RequestMapping(value = "/export",method = RequestMethod.GET)
	public void export(@RequestParam String id, HttpServletResponse response) {
		actModelService.export(id, response);
	}


	@ApiOperation(value = "删除模型")
	@RequiresPermissions("act:model:delete")
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestParam String id) {
		actModelService.delete(id);
		return new UpmsResult(UpmsResultConstant.SUCCESS,"删除成功");
	}

}
