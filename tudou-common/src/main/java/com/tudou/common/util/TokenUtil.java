package com.tudou.common.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Created by DavidWang on 2017/8/26.
 */
public class TokenUtil{

	public static String getUserName(){
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		return username;
	}

	public static Object getUserObject(){
		return SerializeUtil.deserialize(RedisUtil.get(getUserName().getBytes()));
	}

}
