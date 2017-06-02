package com.tudou.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * Created by DavidWang on 2017/5/31.
 */
public class TudouErpUtil  implements InitializingBean, ServletContextAware {

	private static Logger _log = LoggerFactory.getLogger(TudouErpUtil.class);

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		_log.info("===== 开始拷贝tudou-erp-web =====");
		String resources = servletContext.getRealPath("resources/erp");
		String outpushPath = servletContext.getRealPath("resources");
		_log.info("tudou-ui/erp 拷贝到: {}", resources);
		CpUtil.copy(resources,"ServiceProject","/tudou-ui/tudou-erp-web/erp",outpushPath);
	}


}
