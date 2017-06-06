package com.tudou.upms.server.controller;
import com.tudou.common.util.RedisUtil;
import com.tudou.upms.client.shiro.session.UpmsSession;
import com.tudou.upms.client.shiro.session.UpmsSessionDao;
import com.tudou.upms.common.constant.UpmsResult;
import com.tudou.upms.common.constant.UpmsResultConstant;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

	@Autowired
	UpmsSessionDao upmsSessionDao;

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
			// 全局会话的code
			RedisUtil.set(TUDOU_UPMS_SERVER_SESSION_ID + "_" + sessionId, code, (int) subject.getSession().getTimeout() / 1000);
			// code校验值
			RedisUtil.set(TUDOU_UPMS_SERVER_CODE + "_" + code, code, (int) subject.getSession().getTimeout() / 1000);
		}

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
