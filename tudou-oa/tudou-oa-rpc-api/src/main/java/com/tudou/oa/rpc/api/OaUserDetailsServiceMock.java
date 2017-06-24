package com.tudou.oa.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.oa.dao.mapper.OaUserDetailsMapper;
import com.tudou.oa.dao.model.OaUserDetails;
import com.tudou.oa.dao.model.OaUserDetailsExample;

/**
* 降级实现OaUserDetailsService接口
* Created by tudou on 2017/6/24.
*/
public class OaUserDetailsServiceMock extends BaseServiceMock<OaUserDetailsMapper, OaUserDetails, OaUserDetailsExample> implements OaUserDetailsService {

}
