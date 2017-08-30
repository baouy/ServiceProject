package com.tudou.oa.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.oa.dao.mapper.OaLeaveMapper;
import com.tudou.oa.dao.model.OaLeave;
import com.tudou.oa.dao.model.OaLeaveExample;
import com.tudou.oa.rpc.api.OaLeaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* OaLeaveService实现
* Created by tudou on 2017/8/26.
*/
@Service
@Transactional
@BaseService
public class OaLeaveServiceImpl extends BaseServiceImpl<OaLeaveMapper, OaLeave, OaLeaveExample> implements OaLeaveService {

    private static Logger _log = LoggerFactory.getLogger(OaLeaveServiceImpl.class);

    @Autowired
    OaLeaveMapper oaLeaveMapper;

}