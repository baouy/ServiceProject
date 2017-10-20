package com.tudou.pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by DavidWang on 2017/6/24.
 */
public class PayRpcServiceApplication {

	private static Logger _log = LoggerFactory.getLogger(PayRpcServiceApplication.class);

	public static void main(String[] args) {
		_log.info(">>>>> tudou-pay-rpc-service 正在启动 <<<<<");
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
		_log.info(">>>>> tudou-pay-rpc-service 启动完成 <<<<<");
	}

}
