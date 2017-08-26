package com.tudou.oa.service.controller.act.ext;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.GroupIdentityManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Activiti Group Entity Factory
 */
public class ActGroupEntityServiceFactory implements SessionFactory {

	private ActGroupEntityService actGroupEntityService;
	
	public Class<?> getSessionType() {
		// 返回原始的GroupIdentityManager类型
		return GroupIdentityManager.class;
	}

	public Session openSession() {
		// 返回自定义的GroupEntityManager实例
		return actGroupEntityService;
	}

	@Autowired
	public void setActGroupEntityService(ActGroupEntityService actGroupEntityService) {
		this.actGroupEntityService = actGroupEntityService;
	}

}
