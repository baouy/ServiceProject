package com.tudou.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.tudou.common.base.BaseServiceMock;
import com.tudou.upms.dao.mapper.UpmsUserPermissionMapper;
import com.tudou.upms.dao.model.UpmsUserPermission;
import com.tudou.upms.dao.model.UpmsUserPermissionExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 降级实现UpmsUserPermissionService接口
* Created by tudou on 2017/5/27.
*/
public class UpmsUserPermissionServiceMock extends BaseServiceMock<UpmsUserPermissionMapper, UpmsUserPermission, UpmsUserPermissionExample> implements UpmsUserPermissionService {

	private static Logger _log = LoggerFactory.getLogger(UpmsUserPermissionServiceMock.class);

	@Override
	public int permission(JSONArray datas, int id) {
		_log.info("UpmsUserPermissionServiceMock => permission");
		return 0;
	}

}
