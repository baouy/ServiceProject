package com.tudou.upms.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.upms.dao.mapper.UpmsRoleMapper;
import com.tudou.upms.dao.model.UpmsRole;
import com.tudou.upms.dao.model.UpmsRoleExample;
import com.tudou.upms.rpc.api.UpmsRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsRoleService实现
* Created by tudou on 2017/5/27.
*/
@Service
@Transactional
@BaseService
public class UpmsRoleServiceImpl extends BaseServiceImpl<UpmsRoleMapper, UpmsRole, UpmsRoleExample> implements UpmsRoleService {

    private static Logger _log = LoggerFactory.getLogger(UpmsRoleServiceImpl.class);

    @Autowired
    UpmsRoleMapper upmsRoleMapper;

}