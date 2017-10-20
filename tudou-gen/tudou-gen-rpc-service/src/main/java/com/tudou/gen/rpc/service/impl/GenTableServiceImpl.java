package com.tudou.gen.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.gen.dao.mapper.GenTableMapper;
import com.tudou.gen.dao.model.GenTable;
import com.tudou.gen.dao.model.GenTableExample;
import com.tudou.gen.rpc.api.GenTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* GenTableService实现
* Created by tudou on 2017/9/1.
*/
@Service
@Transactional
@BaseService
public class GenTableServiceImpl extends BaseServiceImpl<GenTableMapper, GenTable, GenTableExample> implements GenTableService {

    private static Logger _log = LoggerFactory.getLogger(GenTableServiceImpl.class);

    @Autowired
    GenTableMapper genTableMapper;

}