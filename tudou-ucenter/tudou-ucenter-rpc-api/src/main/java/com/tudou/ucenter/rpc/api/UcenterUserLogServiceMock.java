package com.tudou.ucenter.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.ucenter.dao.mapper.UcenterUserLogMapper;
import com.tudou.ucenter.dao.model.UcenterUserLog;
import com.tudou.ucenter.dao.model.UcenterUserLogExample;

/**
* 降级实现UcenterUserLogService接口
* Created by tudou on 2017/6/15.
*/
public class UcenterUserLogServiceMock extends BaseServiceMock<UcenterUserLogMapper, UcenterUserLog, UcenterUserLogExample> implements UcenterUserLogService {

}
