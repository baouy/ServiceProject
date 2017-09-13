package com.tudou.pcweb.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.pcweb.dao.mapper.UcenterUserOauthMapper;
import com.tudou.pcweb.dao.model.UcenterUserOauth;
import com.tudou.pcweb.dao.model.UcenterUserOauthExample;
import com.tudou.pcweb.rpc.api.UcenterUserOauthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UcenterUserOauthService实现
* Created by tudou on 2017/9/12.
*/
@Service
@Transactional
@BaseService
public class UcenterUserOauthServiceImpl extends BaseServiceImpl<UcenterUserOauthMapper, UcenterUserOauth, UcenterUserOauthExample> implements UcenterUserOauthService {

    private static Logger _log = LoggerFactory.getLogger(UcenterUserOauthServiceImpl.class);

    @Autowired
    UcenterUserOauthMapper ucenterUserOauthMapper;

}