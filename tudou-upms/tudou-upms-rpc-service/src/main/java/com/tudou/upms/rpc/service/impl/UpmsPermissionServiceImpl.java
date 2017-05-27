package com.tudou.upms.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.upms.dao.mapper.UpmsPermissionMapper;
import com.tudou.upms.dao.model.UpmsPermission;
import com.tudou.upms.dao.model.UpmsPermissionExample;
import com.tudou.upms.rpc.api.UpmsPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsPermissionService实现
* Created by tudou on 2017/5/27.
*/
@Service
@Transactional
@BaseService
public class UpmsPermissionServiceImpl extends BaseServiceImpl<UpmsPermissionMapper, UpmsPermission, UpmsPermissionExample> implements UpmsPermissionService {

    private static Logger _log = LoggerFactory.getLogger(UpmsPermissionServiceImpl.class);

    @Autowired
    UpmsPermissionMapper upmsPermissionMapper;

}