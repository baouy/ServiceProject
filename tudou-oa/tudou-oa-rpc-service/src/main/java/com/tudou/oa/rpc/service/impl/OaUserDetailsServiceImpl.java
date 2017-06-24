package com.tudou.oa.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.oa.dao.mapper.OaUserDetailsMapper;
import com.tudou.oa.dao.model.OaUserDetails;
import com.tudou.oa.dao.model.OaUserDetailsExample;
import com.tudou.oa.rpc.api.OaUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* OaUserDetailsService实现
* Created by tudou on 2017/6/24.
*/
@Service
@Transactional
@BaseService
public class OaUserDetailsServiceImpl extends BaseServiceImpl<OaUserDetailsMapper, OaUserDetails, OaUserDetailsExample> implements OaUserDetailsService {

    private static Logger _log = LoggerFactory.getLogger(OaUserDetailsServiceImpl.class);

    @Autowired
    OaUserDetailsMapper oaUserDetailsMapper;


}