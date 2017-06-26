package com.tudou.oa.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.oa.dao.mapper.OaViewUserMapper;
import com.tudou.oa.dao.model.OaViewUser;
import com.tudou.oa.dao.model.OaViewUserExample;
import com.tudou.oa.rpc.api.OaViewUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* OaViewUserService实现
* Created by tudou on 2017/6/26.
*/
@Service
@Transactional
@BaseService
public class OaViewUserServiceImpl extends BaseServiceImpl<OaViewUserMapper, OaViewUser, OaViewUserExample> implements OaViewUserService {

    private static Logger _log = LoggerFactory.getLogger(OaViewUserServiceImpl.class);

    @Autowired
    OaViewUserMapper oaViewUserMapper;

}