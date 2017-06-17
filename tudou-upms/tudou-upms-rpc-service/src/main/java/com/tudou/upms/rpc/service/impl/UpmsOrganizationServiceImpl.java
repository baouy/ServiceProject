package com.tudou.upms.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.upms.dao.mapper.UpmsOrganizationMapper;
import com.tudou.upms.dao.model.UpmsOrganization;
import com.tudou.upms.dao.model.UpmsOrganizationExample;
import com.tudou.upms.rpc.api.UpmsOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsOrganizationService实现
* Created by tudou on 2017/5/27.
*/
@Service
@Transactional
@BaseService
public class UpmsOrganizationServiceImpl extends BaseServiceImpl<UpmsOrganizationMapper, UpmsOrganization, UpmsOrganizationExample> implements UpmsOrganizationService {

    private static Logger _log = LoggerFactory.getLogger(UpmsOrganizationServiceImpl.class);

    @Autowired
    UpmsOrganizationMapper upmsOrganizationMapper;

    @Override
    public UpmsOrganization createUpmsOrganization(UpmsOrganization upmsOrganization) {

        _log.debug("upmsOrganization-",upmsOrganization.toString());
        upmsOrganizationMapper.insertSelective(upmsOrganization);

        return upmsOrganization;
    }
}