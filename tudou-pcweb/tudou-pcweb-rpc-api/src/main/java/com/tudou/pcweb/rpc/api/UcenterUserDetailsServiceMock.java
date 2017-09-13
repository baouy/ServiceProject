package com.tudou.pcweb.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.pcweb.dao.mapper.UcenterUserDetailsMapper;
import com.tudou.pcweb.dao.model.UcenterUserDetails;
import com.tudou.pcweb.dao.model.UcenterUserDetailsExample;

/**
* 降级实现UcenterUserDetailsService接口
* Created by tudou on 2017/9/12.
*/
public class UcenterUserDetailsServiceMock extends BaseServiceMock<UcenterUserDetailsMapper, UcenterUserDetails, UcenterUserDetailsExample> implements UcenterUserDetailsService {

}
