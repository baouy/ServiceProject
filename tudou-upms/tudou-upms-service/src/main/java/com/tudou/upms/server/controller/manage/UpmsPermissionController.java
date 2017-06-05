package com.tudou.upms.server.controller.manage;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.tudou.common.base.BaseController;
import com.tudou.common.validator.LengthValidator;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.dao.model.UpmsPermission;
import com.tudou.upms.dao.model.UpmsPermissionExample;
import com.tudou.upms.dao.model.UpmsSystem;
import com.tudou.upms.dao.model.UpmsSystemExample;
import com.tudou.upms.rpc.api.UpmsApiService;
import com.tudou.upms.rpc.api.UpmsPermissionService;
import com.tudou.upms.rpc.api.UpmsSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
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
@Api(value = "权限管理", description = "权限管理")
@RequestMapping("/manage/permission")
public class UpmsPermissionController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(UpmsPermissionController.class);

	@Autowired
	private UpmsPermissionService upmsPermissionService;

	@Autowired
	private UpmsSystemService upmsSystemService;

	@Autowired
	private UpmsApiService upmsApiService;

	@ApiOperation(value = "权限列表")
	@RequiresPermissions("upms:permission:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(
			@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
			@RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
			@RequestParam(required = false, defaultValue = "", value = "search") String search,
			@RequestParam(required = false, defaultValue = "0", value = "type") int type,
			@RequestParam(required = false, defaultValue = "0", value = "systemId") int systemId,
			@RequestParam(required = false, value = "sort") String sort,
			@RequestParam(required = false, value = "order") String order) {
		UpmsPermissionExample upmsPermissionExample = new UpmsPermissionExample();
		UpmsPermissionExample.Criteria criteria = upmsPermissionExample.createCriteria();
		if (0 != type) {
			criteria.andTypeEqualTo((byte) type);
		}
		if (0 != systemId) {
			criteria.andSystemIdEqualTo(systemId);
		}
		if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
			upmsPermissionExample.setOrderByClause(sort + " " + order);
		}
		if (StringUtils.isNotBlank(search)) {
			upmsPermissionExample.or()
					.andNameLike("%" + search + "%");
		}
		List<UpmsPermission> rows = upmsPermissionService.selectByExampleForOffsetPage(upmsPermissionExample, offset, limit);
		long total = upmsPermissionService.countByExample(upmsPermissionExample);
		Map<String, Object> result = new HashMap<>();
		result.put("rows", rows);
		result.put("total", total);
		return result;
	}

	@ApiOperation(value = "角色权限列表")
	@RequiresPermissions("upms:permission:read")
	@RequestMapping(value = "/role/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object role(@PathVariable("id") int id) {
		return upmsPermissionService.getTreeByRoleId(id);
	}

	@ApiOperation(value = "用户权限列表")
	@RequiresPermissions("upms:permission:read")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object user(@PathVariable("id") int id, HttpServletRequest request) {
		return upmsPermissionService.getTreeByUserId(id, NumberUtils.toByte(request.getParameter("type")));
	}

	@ApiOperation(value = "新增权限")
	@RequiresPermissions("upms:permission:create")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Object create(UpmsPermission upmsPermission) {
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsPermission.getName(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
		}
		long time = System.currentTimeMillis();
		upmsPermission.setCtime(time);
		upmsPermission.setOrders(time);
		int count = upmsPermissionService.insertSelective(upmsPermission);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@ApiOperation(value = "删除权限")
	@RequiresPermissions("upms:permission:delete")
	@RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
	@ResponseBody
	public Object delete(@PathVariable("ids") String ids) {
		int count = upmsPermissionService.deleteByPrimaryKeys(ids);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@ApiOperation(value = "修改权限")
	@RequiresPermissions("upms:permission:update")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@PathVariable("id") int id, UpmsPermission upmsPermission) {
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsPermission.getName(), new LengthValidator(1, 20, "名称"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
		}
		upmsPermission.setPermissionId(id);
		int count = upmsPermissionService.updateByPrimaryKeySelective(upmsPermission);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}
}
