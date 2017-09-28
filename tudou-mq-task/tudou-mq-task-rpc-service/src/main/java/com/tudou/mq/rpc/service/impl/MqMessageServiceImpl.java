package com.tudou.mq.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.mq.dao.mapper.MqMessageMapper;
import com.tudou.mq.dao.model.MqMessage;
import com.tudou.mq.dao.model.MqMessageExample;
import com.tudou.mq.rpc.api.MqMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* MqMessageService实现
* Created by tudou on 2017/9/28.
*/
@Service
@Transactional
@BaseService
public class MqMessageServiceImpl extends BaseServiceImpl<MqMessageMapper, MqMessage, MqMessageExample> implements MqMessageService {

    private static Logger _log = LoggerFactory.getLogger(MqMessageServiceImpl.class);

    @Autowired
    MqMessageMapper mqMessageMapper;

}