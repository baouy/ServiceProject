package com.tudou.upms.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.upms.dao.mapper.UpmsRolePermissionMapper;
import com.tudou.upms.dao.model.UpmsRolePermission;
import com.tudou.upms.dao.model.UpmsRolePermissionExample;
import com.tudou.upms.rpc.api.UpmsRolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsRolePermissionService实现
* Created by tudou on 2017/5/27.
*/
@Service
@Transactional
@BaseService
public class UpmsRolePermissionServiceImpl extends BaseServiceImpl<UpmsRolePermissionMapper, UpmsRolePermission, UpmsRolePermissionExample> implements UpmsRolePermissionService {

    private static Logger _log = LoggerFactory.getLogger(UpmsRolePermissionServiceImpl.class);

    @Autowired
    UpmsRolePermissionMapper upmsRolePermissionMapper;

}