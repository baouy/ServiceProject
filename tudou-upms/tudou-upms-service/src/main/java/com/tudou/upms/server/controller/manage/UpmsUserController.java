package com.tudou.upms.server.controller.manage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.tudou.common.base.BaseController;
import com.tudou.common.util.MD5Util;
import com.tudou.common.util.StringUtil;
import com.tudou.common.validator.LengthValidator;
import com.tudou.common.validator.NotNullValidator;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.dao.model.*;
import com.tudou.upms.rpc.api.*;
import com.tudou.upms.server.modelvalid.OrganizationValid;
import com.tudou.upms.server.modelvalid.UserValid;
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
import java.util.UUID;

/**
 * Created by DavidWang on 2017/6/7.
 */
@Controller
@Api(value = "用户管理", description = "用户管理")
@RequestMapping("/manage/user")
public class UpmsUserController extends BaseController {

	private static Logger _log = LoggerFactory.getLogger(UpmsUserController.class);

	@Autowired
	private UpmsUserService upmsUserService;

	@Autowired
	private UpmsRoleService upmsRoleService;

	@Autowired
	private UpmsOrganizationService upmsOrganizationService;

	@Autowired
	private UpmsUserOrganizationService upmsUserOrganizationService;

	@Autowired
	private UpmsUserRoleService upmsUserRoleService;

	@Autowired
	private UpmsUserPermissionService upmsUserPermissionService;


	@ApiOperation(value = "组织列表")
	@RequiresPermissions("upms:user:organization")
	@RequestMapping(value = "/organization_list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(@ModelAttribute OrganizationValid organizationValid) {
		UpmsOrganizationExample upmsOrganizationExample = new UpmsOrganizationExample();
		UpmsOrganizationExample.Criteria criteria = upmsOrganizationExample.createCriteria();
		if (organizationValid.getOrganizationId() != null){
			criteria.andOrganizationIdEqualTo(organizationValid.getOrganizationId());
		}
		if (!StringUtils.isBlank(organizationValid.getName())){
			criteria.andNameLike("%"+ organizationValid.getName() +"%");
		}
		if (!StringUtils.isBlank(organizationValid.getDescription())){
			criteria.andDescriptionLike("%"+ organizationValid.getDescription() +"%");
		}

		List<UpmsOrganization> rows = upmsOrganizationService.selectByExample(upmsOrganizationExample);
		return new UpmsResult(UpmsResultConstant.SUCCESS,rows);
	}

	@ApiOperation(value = "用户组织")
	@RequiresPermissions("upms:user:organization")
	@RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object organization(@PathVariable("id") int id) {
		UpmsUserOrganizationExample upmsUserOrganizationExample = new UpmsUserOrganizationExample();
		upmsUserOrganizationExample.createCriteria()
				.andUserIdEqualTo(id);
		List<UpmsUserOrganization> upmsUserOrganizations = upmsUserOrganizationService.selectByExample(upmsUserOrganizationExample);
		return new UpmsResult(UpmsResultConstant.SUCCESS, upmsUserOrganizations);
	}

	@ApiOperation(value = "用户组织")
	@RequiresPermissions("upms:user:organization")
	@RequestMapping(value = "/organization/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object organization(@PathVariable("id") int id,@RequestParam(value = "organizationId[]") String [] organizationId) {
		upmsUserOrganizationService.organization(organizationId, id);
		return new UpmsResult(UpmsResultConstant.SUCCESS, "");
	}

	@ApiOperation(value = "用户角色")
	@RequiresPermissions("upms:user:role")
	@RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object role(@PathVariable("id") int id) {
		// 用户拥有角色
		UpmsUserRoleExample upmsUserRoleExample = new UpmsUserRoleExample();
		upmsUserRoleExample.createCriteria()
				.andUserIdEqualTo(id);
		List<UpmsUserRole> upmsUserRoles = upmsUserRoleService.selectByExample(upmsUserRoleExample);
		return new UpmsResult(UpmsResultConstant.SUCCESS, upmsUserRoles);
	}

	@ApiOperation(value = "用户角色")
	@RequiresPermissions("upms:user:role")
	@RequestMapping(value = "/role_list", method = RequestMethod.GET)
	@ResponseBody
	public Object role_list() {
		// 所有角色
		List<UpmsRole> upmsRoles = upmsRoleService.selectByExample(new UpmsRoleExample());
		return new UpmsResult(UpmsResultConstant.SUCCESS, upmsRoles);
	}

	@ApiOperation(value = "用户角色")
	@RequiresPermissions("upms:user:role")
	@RequestMapping(value = "/role/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object role(@PathVariable("id") int id,@RequestParam(value = "roleIds[]") String [] roleIds) {
		upmsUserRoleService.role(roleIds, id);
		return new UpmsResult(UpmsResultConstant.SUCCESS, "");
	}

	@ApiOperation(value = "用户权限")
	@RequiresPermissions("upms:user:permission")
	@RequestMapping(value = "/permission/{id}", method = RequestMethod.GET)
	public String permission(@PathVariable("id") int id, ModelMap modelMap) {
		UpmsUser user = upmsUserService.selectByPrimaryKey(id);
		modelMap.put("user", user);
		return "/manage/user/permission.jsp";
	}

	@ApiOperation(value = "用户权限")
	@RequiresPermissions("upms:user:permission")
	@RequestMapping(value = "/permission/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Object permission(@PathVariable("id") int id, HttpServletRequest request) {
		JSONArray datas = JSONArray.parseArray(request.getParameter("datas"));
		upmsUserPermissionService.permission(datas, id);
		return new UpmsResult(UpmsResultConstant.SUCCESS, datas.size());
	}

	@ApiOperation(value = "用户列表")
	@RequiresPermissions("upms:user:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(@ModelAttribute UserValid userValid) {
		UpmsUserExample upmsUserExample = new UpmsUserExample();
		UpmsUserExample.Criteria criteria = upmsUserExample.createCriteria();
		if (userValid.getUserId() != null){
			criteria.andUserIdEqualTo(userValid.getUserId());
		}
		if (!StringUtils.isBlank(userValid.getUsername())){
			criteria.andUsernameLike("%"+ userValid.getUsername() +"%");
		}
		if (!StringUtils.isBlank(userValid.getRealname())){
			criteria.andRealnameLike("%"+ userValid.getRealname() +"%");
		}
		if (!StringUtils.isBlank(userValid.getAvatar())){
			criteria.andAvatarLike("%"+ userValid.getAvatar() +"%");
		}
		if (!StringUtils.isBlank(userValid.getPhone())){
			criteria.andPhoneLike("%"+ userValid.getPhone() +"%");
		}
		if (!StringUtils.isBlank(userValid.getEmail())){
			criteria.andEmailLike("%"+ userValid.getEmail() +"%");
		}
		if (userValid.getSex() != null){
			criteria.andSexEqualTo(userValid.getSex());
		}
		if (userValid.getLocked() != null){
			criteria.andLockedEqualTo(userValid.getLocked());
		}

		List<UpmsUser> rows = upmsUserService.selectByExampleForOffsetPage(upmsUserExample, userValid.getPageCurrent(), userValid.getPageSize());
		int total = upmsUserService.countByExample(upmsUserExample);
		return new UpmsResult(UpmsResultConstant.SUCCESS,rows,userValid.getPageSize(),userValid.getPageCurrent(),total);
	}

	@ApiOperation(value = "新增用户")
	@RequiresPermissions("upms:user:create")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Object create(@RequestParam String json) {
		UpmsUser upmsUser = JSON.parseArray(json,UpmsUser.class).get(0);
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsUser.getUsername(), new LengthValidator(1, 20, "帐号"))
				.on(upmsUser.getRealname(), new NotNullValidator("姓名"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
		}
		long time = System.currentTimeMillis();
		String salt = UUID.randomUUID().toString().replaceAll("-", "");
		upmsUser.setSalt(salt);
		upmsUser.setPassword(MD5Util.MD5("123456" + upmsUser.getSalt()));
		upmsUser.setCtime(time);
		upmsUser = upmsUserService.createUser(upmsUser);
		if (null == upmsUser) {
			return new UpmsResult(UpmsResultConstant.FAILED, "帐号名已存在！");
		}
		_log.info("新增用户，主键：userId={}", upmsUser.getUserId());
		return new UpmsResult(UpmsResultConstant.SUCCESS, 1);
	}

	@ApiOperation(value = "删除用户")
	@RequiresPermissions("upms:user:delete")
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestParam String userId) {
		int count = upmsUserService.deleteByPrimaryKeys(userId);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}

	@ApiOperation(value = "修改用户")
	@RequiresPermissions("upms:user:update")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@RequestParam String json) {
		UpmsUser upmsUser = JSON.parseArray(json,UpmsUser.class).get(0);
		ComplexResult result = FluentValidator.checkAll()
				.on(upmsUser.getUsername(), new LengthValidator(1, 20, "帐号"))
				.on(upmsUser.getRealname(), new NotNullValidator("姓名"))
				.doValidate()
				.result(ResultCollectors.toComplex());
		if (!result.isSuccess()) {
			return new UpmsResult(UpmsResultConstant.INVALID_LENGTH, result.getErrors());
		}
		// 不允许直接改密码
		upmsUser.setPassword(null);
		upmsUser.setUserId(upmsUser.getUserId());
		int count = upmsUserService.updateByPrimaryKeySelective(upmsUser);
		return new UpmsResult(UpmsResultConstant.SUCCESS, count);
	}
}
