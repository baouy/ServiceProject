package com.tudou.oa.service.interceptor;

import com.tudou.common.util.RedisUtil;
import com.tudou.common.util.SerializeUtil;
import com.tudou.oa.dao.model.OaViewUser;
import com.tudou.oa.dao.model.OaViewUserExample;
import com.tudou.oa.rpc.api.OaViewUserService;
import com.tudou.upms.dao.model.*;
import com.tudou.upms.rpc.api.UpmsApiService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.zookeeper.server.util.SerializeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DavidWang on 2017/6/16.
 */
public class OaInterceptor extends HandlerInterceptorAdapter {

	private static Logger _log = LoggerFactory.getLogger(OaInterceptor.class);

	@Autowired
	UpmsApiService upmsApiService;
	@Autowired
	OaViewUserService oaViewUserService;


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 过滤ajax
//        if (null != request.getHeader("X-Requested-With") && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
//            return true;
//        }
		// 登录信息
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		if (RedisUtil.get(username.getBytes()) == null){
			OaViewUserExample oaViewUserExample = new OaViewUserExample();
			OaViewUserExample.Criteria  criteria = oaViewUserExample.createCriteria();
			criteria.andUsernameEqualTo(username);
			OaViewUser oaViewUser = oaViewUserService.selectByExample(oaViewUserExample).get(0);
			RedisUtil.set(username.getBytes(), SerializeUtil.serialize(oaViewUser), 1800);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
