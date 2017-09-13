package com.tudou.pcweb.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.pcweb.dao.mapper.UcenterUserDetailsMapper;
import com.tudou.pcweb.dao.model.UcenterUserDetails;
import com.tudou.pcweb.dao.model.UcenterUserDetailsExample;
import com.tudou.pcweb.rpc.api.UcenterUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UcenterUserDetailsService实现
* Created by tudou on 2017/9/12.
*/
@Service
@Transactional
@BaseService
public class UcenterUserDetailsServiceImpl extends BaseServiceImpl<UcenterUserDetailsMapper, UcenterUserDetails, UcenterUserDetailsExample> implements UcenterUserDetailsService {

    private static Logger _log = LoggerFactory.getLogger(UcenterUserDetailsServiceImpl.class);

    @Autowired
    UcenterUserDetailsMapper ucenterUserDetailsMapper;

}