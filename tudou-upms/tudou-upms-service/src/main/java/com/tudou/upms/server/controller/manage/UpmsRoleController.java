package com.tudou.upms.server.controller.manage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.tudou.common.base.BaseController;
import com.tudou.common.validator.LengthValidator;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.dao.model.UpmsRole;
import com.tudou.upms.dao.model.UpmsRoleExample;
import com.tudou.upms.rpc.api.UpmsRolePermissionService;
import com.tudou.upms.rpc.api.UpmsRoleService;
import com.tudou.upms.server.modelvalid.UpmsRoleValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DavidWang on 2017/6/5.
 */
@Controller
@Api(value = "角色管理", description = "角色管理")
@RequestMapping("/manage/role")
public class UpmsRoleController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(UpmsRoleController.class);

	@Autowired
	private UpmsRoleService upmsRoleService;

	@Autowired
	private UpmsRolePermissionService upmsRolePermissionService;

	@ApiOperation(value = "角色权限")
	@RequiresPermissions("upms:role:permission")
	@RequestMapping(value = "/permission/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object permission(@PathVariable("id") int id, HttpServletRequest request) {
		JSONArray datas = JSONArray.parseArray(request.getParameter("datas"));
		int result = upmsRolePermissionService.rolePermission(datas, id);
		return new UpmsResult(UpmsResultConstant.SUCCESS, result);
	}

	@ApiOperation(value = "角色列表")
	@RequiresPermissions("upms:role:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(@ModelAttribute  UpmsRoleValid upmsRoleValid) {
		UpmsRoleExample upmsRoleExample = new UpmsRoleExample();
		UpmsRoleExample.Criteria criteria = upmsRoleExample.createCriteria();
		if (upmsRoleValid.getRoleId() != null){
			criteria.andRoleIdEqualTo(upmsRoleValid.getRoleId());
		}
		if (upmsRoleValid.getName() != null){
			criteria.andNameLike("%"+ upmsRoleValid.getName() +"%");
		}
		if (upmsRoleValid.getTitle() != null){
			criteria.andTitleLike("%"+ upmsRoleValid.getTitle() + "%");
		}
		if (upmsRoleValid.getDescription() != null){
			criteria.andDescriptionLike("%"+ upmsRoleValid.getDescription() + "%");
		}

		List<UpmsRole> rows = upmsRoleService.selectByExampleForOffsetPage(upmsRoleExample, upmsRoleValid.getPageCurrent(), upmsRoleValid.getPageSize());
		long total = upmsRoleService.countByExample(upmsRoleExample);
		Map<String, Object> result = new HashMap<>();
		result.put("data", rows);
		result.put("total", total);
		return result;
	}

	@ApiOperation(value = "新增角色")
	@RequiresPermissions("upms:role:create")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Object create(@RequestParam String json) {
		List<UpmsRole> upmsRoles = JSON.parseArray(json, UpmsRole.class);
		UpmsRole upmsRole = upmsRoles.get(0);
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsRole.getName(), new LengthValidator(1, 20, "名称"))
				.on(upmsRole.getTitle(), new LengthValidator(1, 20, "标题"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
		}
		long time = System.currentTimeMillis();
		upmsRole.setCtime(time);
		upmsRole.setOrders(time);
		int count = upmsRoleService.insertSelective(upmsRole);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@ApiOperation(value = "删除角色")
	@RequiresPermissions("upms:role:delete")
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestParam String roleId) {
		int count = upmsRoleService.deleteByPrimaryKeys(roleId);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}


	@ApiOperation(value = "修改角色")
	@RequiresPermissions("upms:role:update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@RequestParam String json) {
		List<UpmsRole> upmsRoles = JSON.parseArray(json, UpmsRole.class);
		UpmsRole upmsRole = upmsRoles.get(0);
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsRole.getName(), new LengthValidator(1, 20, "名称"))
				.on(upmsRole.getTitle(), new LengthValidator(1, 20, "标题"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
		}
		upmsRole.setRoleId(upmsRole.getRoleId());
		int count = upmsRoleService.updateByPrimaryKeySelective(upmsRole);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}
}
