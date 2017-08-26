package com.tudou.oa.service.controller.act;

import com.tudou.common.base.BaseController;
import com.tudou.oa.common.constant.OaResult;
import com.tudou.oa.common.constant.OaResultConstant;
import com.tudou.oa.service.controller.act.service.ActModelService;
import com.tudou.oa.service.modelvalid.ModelValid;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.repository.Model;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 流程模型相关Controller
 */
@Controller
@RequestMapping(value = "/act/model")
public class ActModelController extends BaseController {

	@Resource
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

		return new OaResult(OaResultConstant.SUCCESS,models,modelValid.getPageSize(),modelValid.getPageCurrent(),modelValid.getMaxnum());
	}

	@ApiOperation(value = "创建模型")
	@RequiresPermissions(value = {"act:model:create","act:model:update"}, logical = Logical.OR)
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Object create(@ModelAttribute ModelValid modelValid) {
		try {
			Model modelData = actModelService.create(modelValid.getName(), modelValid.getKey(), modelValid.getDescription(), modelValid.getCategory());
			return new OaResult(OaResultConstant.SUCCESS,"/act/process-editor/modeler.jsp?modelId=" + modelData.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new OaResult(OaResultConstant.PERMISSIONS_403,null);
	}

	@ApiOperation(value = "部署模型")
	@RequiresPermissions("act:model:deploy")
	@RequestMapping(value = "/deploy",method = RequestMethod.POST)
	@ResponseBody
	public Object deploy(@RequestParam  String id) {
		String message = actModelService.deploy(id);
		return new OaResult(OaResultConstant.SUCCESS,message);
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
		return new OaResult(OaResultConstant.SUCCESS,"删除成功");
	}

}
