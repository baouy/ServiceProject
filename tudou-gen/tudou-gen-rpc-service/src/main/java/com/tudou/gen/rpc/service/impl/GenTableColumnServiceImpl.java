package com.tudou.gen.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.gen.dao.mapper.GenTableColumnMapper;
import com.tudou.gen.dao.model.GenTableColumn;
import com.tudou.gen.dao.model.GenTableColumnExample;
import com.tudou.gen.rpc.api.GenTableColumnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* GenTableColumnService实现
* Created by tudou on 2017/9/1.
*/
@Service
@Transactional
@BaseService
public class GenTableColumnServiceImpl extends BaseServiceImpl<GenTableColumnMapper, GenTableColumn, GenTableColumnExample> implements GenTableColumnService {

    private static Logger _log = LoggerFactory.getLogger(GenTableColumnServiceImpl.class);

    @Autowired
    GenTableColumnMapper genTableColumnMapper;

}