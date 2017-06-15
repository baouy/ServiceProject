package com.tudou.ucenter.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.ucenter.dao.mapper.UcenterUserMapper;
import com.tudou.ucenter.dao.model.UcenterUser;
import com.tudou.ucenter.dao.model.UcenterUserExample;

/**
* 降级实现UcenterUserService接口
* Created by tudou on 2017/6/15.
*/
public class UcenterUserServiceMock extends BaseServiceMock<UcenterUserMapper, UcenterUser, UcenterUserExample> implements UcenterUserService {

}
