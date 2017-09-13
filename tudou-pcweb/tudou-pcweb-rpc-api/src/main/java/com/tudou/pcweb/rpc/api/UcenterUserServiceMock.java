package com.tudou.pcweb.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.pcweb.dao.mapper.UcenterUserMapper;
import com.tudou.pcweb.dao.model.UcenterUser;
import com.tudou.pcweb.dao.model.UcenterUserExample;

/**
* 降级实现UcenterUserService接口
* Created by tudou on 2017/9/12.
*/
public class UcenterUserServiceMock extends BaseServiceMock<UcenterUserMapper, UcenterUser, UcenterUserExample> implements UcenterUserService {

}
