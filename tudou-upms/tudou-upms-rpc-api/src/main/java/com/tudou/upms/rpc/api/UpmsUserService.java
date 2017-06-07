package com.tudou.upms.rpc.api;

import com.tudou.common.base.BaseService;
import com.tudou.upms.dao.model.UpmsUser;
import com.tudou.upms.dao.model.UpmsUserExample;

/**
* UpmsUserService接口
* Created by tudou on 2017/5/27.
*/
public interface UpmsUserService extends BaseService<UpmsUser, UpmsUserExample> {

	UpmsUser createUser(UpmsUser upmsUser);

}