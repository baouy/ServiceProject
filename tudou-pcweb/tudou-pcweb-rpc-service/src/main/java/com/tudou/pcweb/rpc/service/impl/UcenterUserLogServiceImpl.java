package com.tudou.pcweb.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.pcweb.dao.mapper.UcenterUserLogMapper;
import com.tudou.pcweb.dao.model.UcenterUserLog;
import com.tudou.pcweb.dao.model.UcenterUserLogExample;
import com.tudou.pcweb.rpc.api.UcenterUserLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UcenterUserLogService实现
* Created by tudou on 2017/9/12.
*/
@Service
@Transactional
@BaseService
public class UcenterUserLogServiceImpl extends BaseServiceImpl<UcenterUserLogMapper, UcenterUserLog, UcenterUserLogExample> implements UcenterUserLogService {

    private static Logger _log = LoggerFactory.getLogger(UcenterUserLogServiceImpl.class);

    @Autowired
    UcenterUserLogMapper ucenterUserLogMapper;

}