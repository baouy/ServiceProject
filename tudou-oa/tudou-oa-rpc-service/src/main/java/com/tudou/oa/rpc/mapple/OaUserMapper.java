package com.tudou.oa.rpc.mapple;

import com.tudou.oa.dao.othermodel.OaUser;

import java.util.List;

/**
 * Created by DavidWang on 2017/6/24.
 */
public interface OaUserMapper {

	public List<OaUser> selectOaUserList(OaUser oaUser);


}
