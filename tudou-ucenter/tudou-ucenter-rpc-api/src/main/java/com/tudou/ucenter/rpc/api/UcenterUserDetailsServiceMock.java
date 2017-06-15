package com.tudou.ucenter.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.ucenter.dao.mapper.UcenterUserDetailsMapper;
import com.tudou.ucenter.dao.model.UcenterUserDetails;
import com.tudou.ucenter.dao.model.UcenterUserDetailsExample;

/**
* 降级实现UcenterUserDetailsService接口
* Created by tudou on 2017/6/15.
*/
public class UcenterUserDetailsServiceMock extends BaseServiceMock<UcenterUserDetailsMapper, UcenterUserDetails, UcenterUserDetailsExample> implements UcenterUserDetailsService {

}
