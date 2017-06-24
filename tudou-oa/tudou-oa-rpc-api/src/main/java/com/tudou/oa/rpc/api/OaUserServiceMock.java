package com.tudou.oa.rpc.api;

import com.tudou.oa.dao.othermodel.OaUser;

import java.util.List;

/**
 * Created by DavidWang on 2017/6/24.
 */
public class OaUserServiceMock implements OaUserService{


	@Override
	public List<OaUser> selectOaUserList(OaUser oaUser) {
		return null;
	}
}
