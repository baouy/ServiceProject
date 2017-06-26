package com.tudou.oa.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.oa.dao.mapper.OaViewUserMapper;
import com.tudou.oa.dao.model.OaViewUser;
import com.tudou.oa.dao.model.OaViewUserExample;

/**
* 降级实现OaViewUserService接口
* Created by tudou on 2017/6/26.
*/
public class OaViewUserServiceMock extends BaseServiceMock<OaViewUserMapper, OaViewUser, OaViewUserExample> implements OaViewUserService {

}
