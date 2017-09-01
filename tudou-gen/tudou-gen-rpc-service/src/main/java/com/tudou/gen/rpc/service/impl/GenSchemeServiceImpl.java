package com.tudou.gen.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.gen.dao.mapper.GenSchemeMapper;
import com.tudou.gen.dao.model.GenScheme;
import com.tudou.gen.dao.model.GenSchemeExample;
import com.tudou.gen.rpc.api.GenSchemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* GenSchemeService实现
* Created by tudou on 2017/9/1.
*/
@Service
@Transactional
@BaseService
public class GenSchemeServiceImpl extends BaseServiceImpl<GenSchemeMapper, GenScheme, GenSchemeExample> implements GenSchemeService {

    private static Logger _log = LoggerFactory.getLogger(GenSchemeServiceImpl.class);

    @Autowired
    GenSchemeMapper genSchemeMapper;

}