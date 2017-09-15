package com.tudou.scheduler.server;

import com.tudou.common.base.BaseInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统接口
 */
public class Initialize implements BaseInterface {

	private static Logger _log = LoggerFactory.getLogger(Initialize.class);

	@Override
	public void init() {
		_log.info(">>>>> 系统初始化");
	}

}
