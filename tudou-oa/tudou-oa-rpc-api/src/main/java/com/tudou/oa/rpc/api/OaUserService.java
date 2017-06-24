package com.tudou.oa.rpc.api;

import com.tudou.oa.dao.othermodel.OaUser;

import java.util.List;

/**
 * Created by DavidWang on 2017/6/24.
 */
public interface OaUserService {

	List<OaUser> selectOaUserList(OaUser oaUser);


}
