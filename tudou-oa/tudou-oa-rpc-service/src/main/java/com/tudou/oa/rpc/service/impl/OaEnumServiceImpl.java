package com.tudou.oa.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.oa.dao.mapper.OaEnumMapper;
import com.tudou.oa.dao.model.OaEnum;
import com.tudou.oa.dao.model.OaEnumExample;
import com.tudou.oa.rpc.api.OaEnumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* OaEnumService实现
* Created by tudou on 2017/6/24.
*/
@Service
@Transactional
@BaseService
public class OaEnumServiceImpl extends BaseServiceImpl<OaEnumMapper, OaEnum, OaEnumExample> implements OaEnumService {

    private static Logger _log = LoggerFactory.getLogger(OaEnumServiceImpl.class);

    @Autowired
    OaEnumMapper oaEnumMapper;
}