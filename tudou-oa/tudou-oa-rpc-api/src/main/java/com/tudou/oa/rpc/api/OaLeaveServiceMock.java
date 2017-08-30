package com.tudou.oa.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.oa.dao.mapper.OaLeaveMapper;
import com.tudou.oa.dao.model.OaLeave;
import com.tudou.oa.dao.model.OaLeaveExample;

/**
* 降级实现OaLeaveService接口
* Created by tudou on 2017/8/26.
*/
public class OaLeaveServiceMock extends BaseServiceMock<OaLeaveMapper, OaLeave, OaLeaveExample> implements OaLeaveService {

}
