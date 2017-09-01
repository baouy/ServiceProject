package com.tudou.gen.server.interceptor;

import com.tudou.upms.rpc.api.UpmsApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录信息拦截器
 */
public class GenInterceptor extends HandlerInterceptorAdapter {

    private static Logger _log = LoggerFactory.getLogger(GenInterceptor.class);

    @Autowired
    UpmsApiService upmsApiService;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 过滤ajax
//        if (null != request.getHeader("X-Requested-With") && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
//            return true;
//        }
        // 登录信息
//        Subject subject = SecurityUtils.getSubject();
//        String username = "upms_"+ subject.getPrincipal();
//        UpmsUser upmsUser = (UpmsUser) SerializeUtil.deserialize(RedisUtil.get(username.getBytes()));
//        if (upmsUser == null){
//            upmsUser = upmsApiService.selectUpmsUserByUsername(subject.getPrincipal().toString());
//            RedisUtil.set(username.getBytes(), SerializeUtil.serialize(upmsUser), 1800);
//        }
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
