package com.tudou.upms.server.controller;

import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.dao.model.UpmsPermission;
import com.tudou.upms.dao.model.UpmsSystem;
import com.tudou.upms.dao.model.UpmsSystemExample;
import com.tudou.upms.dao.model.UpmsUser;
import com.tudou.upms.rpc.api.UpmsApiService;
import com.tudou.upms.rpc.api.UpmsSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by DavidWang on 2017/6/3.
 */
@Controller
@RequestMapping("/manage")
@Api(value = "后台管理", description = "后台管理")
public class ManageController {

	private static Logger _log = LoggerFactory.getLogger(ManageController.class);

	@Autowired
	private UpmsSystemService upmsSystemService;

	@Autowired
	private UpmsApiService upmsApiService;

	@ApiOperation(value = "后台管理菜单")
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	@ResponseBody
	public Object menu() {
		// 已注册系统
		UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
		upmsSystemExample.createCriteria()
				.andStatusEqualTo((byte) 1);
		List<UpmsSystem> upmsSystems = upmsSystemService.selectByExample(upmsSystemExample);

		HashMap modelMap = new HashMap();
		modelMap.put("upmsSystems", upmsSystems);
		// 当前登录用户权限
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(username);
		List<UpmsPermission> upmsPermissions = upmsApiService.selectUpmsPermissionByUpmsUserId(upmsUser.getUserId());
		modelMap.put("upmsPermissions", upmsPermissions);

		return new UpmsResult(UpmsResultConstant.SUCCESS,modelMap);
	}

	@ApiOperation(value = "后台管理菜单")
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	@ResponseBody
	public Object permissions_403() {
		return new UpmsResult(UpmsResultConstant.PERMISSIONS_403,"无权限操作");
	}

	@ApiOperation(value = "服务器异常")
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	@ResponseBody
	public Object permissions_error() {
		return new UpmsResult(UpmsResultConstant.SERVICE_ERROR,"服务器异常,请联系开发人员");
	}

}
