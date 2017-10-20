package com.tudou.oa.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.oa.dao.mapper.OaNotifyMapper;
import com.tudou.oa.dao.model.OaNotify;
import com.tudou.oa.dao.model.OaNotifyExample;
import com.tudou.oa.rpc.api.OaNotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* OaNotifyService实现
* Created by tudou on 2017/9/12.
*/
@Service
@Transactional
@BaseService
public class OaNotifyServiceImpl extends BaseServiceImpl<OaNotifyMapper, OaNotify, OaNotifyExample> implements OaNotifyService {

    private static Logger _log = LoggerFactory.getLogger(OaNotifyServiceImpl.class);

    @Autowired
    OaNotifyMapper oaNotifyMapper;

}