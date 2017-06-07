package com.tudou.upms.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.upms.dao.mapper.UpmsUserRoleMapper;
import com.tudou.upms.dao.model.UpmsUserRole;
import com.tudou.upms.dao.model.UpmsUserRoleExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 降级实现UpmsUserRoleService接口
* Created by tudou on 2017/5/27.
*/
public class UpmsUserRoleServiceMock extends BaseServiceMock<UpmsUserRoleMapper, UpmsUserRole, UpmsUserRoleExample> implements UpmsUserRoleService {

	private static Logger _log = LoggerFactory.getLogger(UpmsUserRoleServiceMock.class);

	@Override
	public int role(String[] roleIds, int id) {
		_log.info("UpmsUserRoleServiceMock => role");
		return 0;
	}

}
