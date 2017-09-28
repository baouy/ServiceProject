package com.tudou.mq.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.mq.dao.mapper.MqMessageMapper;
import com.tudou.mq.dao.model.MqMessage;
import com.tudou.mq.dao.model.MqMessageExample;

/**
* 降级实现MqMessageService接口
* Created by tudou on 2017/9/28.
*/
public class MqMessageServiceMock extends BaseServiceMock<MqMessageMapper, MqMessage, MqMessageExample> implements MqMessageService {

}
