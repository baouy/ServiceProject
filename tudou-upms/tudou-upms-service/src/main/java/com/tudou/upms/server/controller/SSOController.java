package com.tudou.upms.server.controller;
import com.tudou.common.util.MD5Util;
import com.tudou.common.util.PropertiesFileUtil;
import com.tudou.common.util.RedisUtil;
import com.tudou.upms.client.shiro.session.UpmsSession;
import com.tudou.upms.client.shiro.session.UpmsSessionDao;
import com.tudou.upms.client.util.SerializableUtil;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
import com.tudou.upms.dao.model.UpmsSystemExample;
import com.tudou.upms.dao.model.UpmsUser;
import com.tudou.upms.rpc.api.UpmsApiService;
import com.tudou.upms.rpc.api.UpmsSystemService;
import com.tudou.upms.rpc.api.UpmsUserService;
import com.tudou.upms.server.modelvalid.SetPasswordValid;
import com.tudou.upms.server.modelvalid.SsoLoginValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

/**
 * 单点登录管理
 * Created by DavidWang on 2017/5/26.
 */
@Controller
@RequestMapping("/sso")
@Api(value = "单点登录管理", description = "单点登录管理")
public class SSOController {

	private final static Logger _log = LoggerFactory.getLogger(SSOController.class);
	// 全局会话key
	private final static String TUDOU_UPMS_SERVER_SESSION_ID = "tudou-upms-server-session-id";
	// 全局会话key列表
	private final static String TUDOU_UPMS_SERVER_SESSION_IDS = "tudou-upms-server-session-ids";
	// code key
	private final static String TUDOU_UPMS_SERVER_CODE = "tudou-upms-server-code";

	private final static String TUDOU_UPMS_SHIRO_SESSION_ID = "tudou-upms-shiro-session-id";

	@Autowired
	UpmsSessionDao upmsSessionDao;

	@Resource
	UpmsApiService upmsApiService;

	@Resource
	UpmsUserService upmsUserService;

	@Autowired
	UpmsSystemService upmsSystemService;

	@ApiOperation(value = "认证中心首页")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request) throws Exception {
		String appid = request.getParameter("appid");
		String backurl = request.getParameter("backurl");
		if (StringUtils.isBlank(appid)) {
			throw new RuntimeException("无效访问！");
		}
		// 判断请求认证系统是否注册
		UpmsSystemExample upmsSystemExample = new UpmsSystemExample();
		upmsSystemExample.createCriteria()
				.andNameEqualTo(appid);
		long count = upmsSystemService.countByExample(upmsSystemExample);
		if (0 == count) {
			throw new RuntimeException(String.format("未注册的系统:%s", appid));
		}
		return "redirect:/sso/login?backurl=" + URLEncoder.encode(backurl, "utf-8");
	}

	@ApiOperation(value = "授权失败登录")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String serverSessionId = session.getId().toString();
		// 判断是否已登录，如果已登录，则回跳
		String code = RedisUtil.get(TUDOU_UPMS_SERVER_SESSION_ID + "_" + serverSessionId);
		// code校验值
		if (StringUtils.isNotBlank(code)) {
			// 回跳
			String backurl = request.getParameter("backurl");
			String username = (String) subject.getPrincipal();
			if (StringUtils.isBlank(backurl)) {
				backurl = "/";
			} else {
				if (backurl.contains("?")) {
					backurl += "&upms_code=" + code + "&upms_username=" + username;
				} else {
					backurl += "?upms_code=" + code + "&upms_username=" + username;
				}
			}
			_log.debug("认证中心帐号通过，带code回跳：{}", backurl);
			return "redirect:" + backurl;
		}

		return "redirect:" +"/sso/failure";
	}


	@ApiOperation(value = "登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@ModelAttribute @Valid SsoLoginValid ssoLoginValid, BindingResult bindingResult) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		String sessionId = session.getId().toString();
		// 判断是否已登录，如果已登录，则回跳，防止重复登录
		String hasCode = RedisUtil.get(TUDOU_UPMS_SERVER_SESSION_ID + "_" + sessionId);
		// code校验值
		if (StringUtils.isBlank(hasCode)) {
			// 使用shiro认证
			UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(ssoLoginValid.getUsername(), ssoLoginValid.getPassword());
			try {
				usernamePasswordToken.setRememberMe(ssoLoginValid.getRememberMe());
				usernamePasswordToken.setHost(session.getHost());
				subject.login(usernamePasswordToken);
			} catch (UnknownAccountException e) {
				return new UpmsResult(UpmsResultConstant.INVALID_USERNAME, "帐号不存在！");
			} catch (IncorrectCredentialsException e) {
				return new UpmsResult(UpmsResultConstant.INVALID_PASSWORD, "密码错误！");
			} catch (LockedAccountException e) {
				return new UpmsResult(UpmsResultConstant.INVALID_ACCOUNT, "帐号已锁定！");
			}
			// 更新session状态
			upmsSessionDao.updateStatus(sessionId, UpmsSession.OnlineStatus.on_line);
			// 全局会话sessionId列表，供会话管理
			RedisUtil.lpush(TUDOU_UPMS_SERVER_SESSION_IDS, sessionId.toString());
			// 默认验证帐号密码正确，创建code
			String code = UUID.randomUUID().toString();

			int seconds = ssoLoginValid.getRememberMe() ? Integer.valueOf(PropertiesFileUtil.getInstance("tudou-upms-client").get("tudou.upms.rememberMe.timeout")):Integer.valueOf(PropertiesFileUtil.getInstance("tudou-upms-client").get("tudou.upms.session.timeout"))/1000;

			// 全局会话的code
			RedisUtil.set(TUDOU_UPMS_SERVER_SESSION_ID + "_" + sessionId, code, seconds);

			// 全局会话的code
			RedisUtil.set(TUDOU_UPMS_SERVER_SESSION_ID + "_" + sessionId, code, (int) subject.getSession().getTimeout() / 1000);
			// code校验值
			RedisUtil.set(TUDOU_UPMS_SERVER_CODE + "_" + code, code, (int) subject.getSession().getTimeout() / 1000);
		}
		return new UpmsResult(UpmsResultConstant.SUCCESS, subject.getSession().getTimeout());
	}

	@ApiOperation(value = "修改密码")
	@RequestMapping(value = "/set_password", method = RequestMethod.POST)
	@ResponseBody
	public Object set_password(@ModelAttribute @Valid SetPasswordValid setPasswordValid) {
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(username);
		String md5 = MD5Util.MD5(setPasswordValid.getPassword() + upmsUser.getSalt());
		if (!upmsUser.getPassword().equals(md5)) {
			return new UpmsResult(UpmsResultConstant.INVALID_PASSWORD, "密码错误");
		}
		upmsUser.setPassword(MD5Util.MD5(setPasswordValid.getNpassword() + upmsUser.getSalt()));
		upmsUserService.updateByPrimaryKey(upmsUser);
		return new UpmsResult(UpmsResultConstant.SUCCESS, null);
	}


	@ApiOperation(value = "校验code")
	@RequestMapping(value = "/code", method = RequestMethod.POST)
	@ResponseBody
	public Object code(HttpServletRequest request) {
		String codeParam = request.getParameter("code");
		String code = RedisUtil.get(TUDOU_UPMS_SERVER_CODE + "_" + codeParam);
		if (StringUtils.isBlank(codeParam) || !codeParam.equals(code)) {
			new UpmsResult(UpmsResultConstant.FAILED, "无效code");
		}
		return new UpmsResult(UpmsResultConstant.SUCCESS, code);
	}

	@ApiOperation(value = "校验失败退出")
	@RequestMapping(value = "/failure", method = RequestMethod.GET)
	@ResponseBody
	public Object failure(HttpServletRequest request) {
		return new UpmsResult(UpmsResultConstant.VERIFY_FAILURE, "验证失效");
	}

	@ApiOperation(value = "退出登录")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public Object logout() {
		// shiro退出登录
		SecurityUtils.getSubject().logout();

		return new UpmsResult(UpmsResultConstant.SUCCESS, null);
	}

}
