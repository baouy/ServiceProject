package com.tudou.upms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by DavidWang on 2017/5/27.
 */
public class UpmsRpcServiceApplication {

	private static Logger _log = LoggerFactory.getLogger(UpmsRpcServiceApplication.class);

	public static void main(String[] args) {
		_log.info(">>>>> tudou-upms-rpc-service 正在启动 <<<<<");
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
		_log.info(">>>>> tudou-upms-rpc-service 启动完成 <<<<<");
	}

}
