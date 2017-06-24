package com.meiwo.oa.service.controller.manage;

import com.tudou.common.base.BaseController;
import com.tudou.oa.rpc.api.OaUserDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DavidWang on 2017/6/24.
 */
@Controller
@Api(value = "OA枚举管理", description = "OA枚举管理")
@RequestMapping("/manage/oauserdetail")
public class OaUserDetailsController extends BaseController{

	private static Logger _log = LoggerFactory.getLogger(OaUserDetailsController.class);

	@Autowired
	private OaUserDetailsService oaUserDetailsService;

	@ApiOperation(value = "用户列表")
	@RequiresPermissions("upms:oa_userdetail:read")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list() {

		return null;
	}


}
