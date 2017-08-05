/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.tudou.upms.act.ext;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.GroupManager;

/**
 * Activiti User Entity Service Factory
 */
public class ActUserEntityServiceFactory implements SessionFactory {

	private ActUserEntityService actUserEntityService;

	public Class<?> getSessionType() {
		// 返回原始的UserIdentityManager类型
		return UserIdentityManager.class;
	}

	public Session openSession() {
		// 返回自定义的UserEntityManager实例
		return actUserEntityService;
	}

	@Autowired
	public void setActUserEntityService(ActUserEntityService actUserEntityService) {
		this.actUserEntityService = actUserEntityService;
	}

}
