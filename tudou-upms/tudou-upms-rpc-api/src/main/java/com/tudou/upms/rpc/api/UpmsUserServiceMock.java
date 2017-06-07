package com.tudou.upms.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.upms.dao.mapper.UpmsUserMapper;
import com.tudou.upms.dao.model.UpmsUser;
import com.tudou.upms.dao.model.UpmsUserExample;

/**
* 降级实现UpmsUserService接口
* Created by tudou on 2017/5/27.
*/
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

	@Override
	public UpmsUser createUser(UpmsUser upmsUser) {
		return null;
	}

}
