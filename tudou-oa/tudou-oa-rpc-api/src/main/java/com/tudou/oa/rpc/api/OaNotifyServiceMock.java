package com.tudou.oa.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.oa.dao.mapper.OaNotifyMapper;
import com.tudou.oa.dao.model.OaNotify;
import com.tudou.oa.dao.model.OaNotifyExample;

/**
* 降级实现OaNotifyService接口
* Created by tudou on 2017/9/12.
*/
public class OaNotifyServiceMock extends BaseServiceMock<OaNotifyMapper, OaNotify, OaNotifyExample> implements OaNotifyService {

}
