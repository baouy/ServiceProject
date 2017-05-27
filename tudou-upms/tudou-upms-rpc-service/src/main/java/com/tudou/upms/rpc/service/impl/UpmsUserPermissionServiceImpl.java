package com.tudou.upms.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.upms.dao.mapper.UpmsUserPermissionMapper;
import com.tudou.upms.dao.model.UpmsUserPermission;
import com.tudou.upms.dao.model.UpmsUserPermissionExample;
import com.tudou.upms.rpc.api.UpmsUserPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsUserPermissionService实现
* Created by tudou on 2017/5/27.
*/
@Service
@Transactional
@BaseService
public class UpmsUserPermissionServiceImpl extends BaseServiceImpl<UpmsUserPermissionMapper, UpmsUserPermission, UpmsUserPermissionExample> implements UpmsUserPermissionService {

    private static Logger _log = LoggerFactory.getLogger(UpmsUserPermissionServiceImpl.class);

    @Autowired
    UpmsUserPermissionMapper upmsUserPermissionMapper;

}