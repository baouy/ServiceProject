package com.tudou.upms.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.upms.dao.mapper.UpmsLogMapper;
import com.tudou.upms.dao.model.UpmsLog;
import com.tudou.upms.dao.model.UpmsLogExample;

/**
* 降级实现UpmsLogService接口
* Created by tudou on 2017/5/26.
*/
public class UpmsLogServiceMock extends BaseServiceMock<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

}
