package com.tudou.upms.server.controller.act;

import com.tudou.common.base.BaseController;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.server.controller.act.service.ActModelService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.activiti.engine.repository.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
//	@RequiresPermissions("act:model:edit")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object modelList(String category) {

		List<Model> models = actModelService.modelList(category);

		return new UpmsResult(UpmsResultConstant.SUCCESS,models);

	}

	@ApiOperation(value = "创建模型")
//	@RequiresPermissions("act:model:edit")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public void create(String name, String key, String description, String category,
					   HttpServletRequest request, HttpServletResponse response) {
		try {
			Model modelData = actModelService.create(name, key, description, category);
			response.sendRedirect(request.getContextPath() + "/act/process-editor/modeler.jsp?modelId=" + modelData.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
