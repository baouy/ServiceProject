package com.tudou.pcweb.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.pcweb.dao.mapper.UcenterUserMapper;
import com.tudou.pcweb.dao.model.UcenterUser;
import com.tudou.pcweb.dao.model.UcenterUserExample;
import com.tudou.pcweb.rpc.api.UcenterUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UcenterUserService实现
* Created by tudou on 2017/9/12.
*/
@Service
@Transactional
@BaseService
public class UcenterUserServiceImpl extends BaseServiceImpl<UcenterUserMapper, UcenterUser, UcenterUserExample> implements UcenterUserService {

    private static Logger _log = LoggerFactory.getLogger(UcenterUserServiceImpl.class);

    @Autowired
    UcenterUserMapper ucenterUserMapper;

}