package com.tudou.upms.rpc.service.impl;

import com.tudou.common.annotation.BaseService;
import com.tudou.common.base.BaseServiceImpl;
import com.tudou.upms.dao.mapper.UpmsMarkdownMapper;
import com.tudou.upms.dao.model.UpmsMarkdown;
import com.tudou.upms.dao.model.UpmsMarkdownExample;
import com.tudou.upms.rpc.api.UpmsMarkdownService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsMarkdownService实现
* Created by tudou on 2017/10/17.
*/
@Service
@Transactional
@BaseService
public class UpmsMarkdownServiceImpl extends BaseServiceImpl<UpmsMarkdownMapper, UpmsMarkdown, UpmsMarkdownExample> implements UpmsMarkdownService {

    private static Logger _log = LoggerFactory.getLogger(UpmsMarkdownServiceImpl.class);

    @Autowired
    UpmsMarkdownMapper upmsMarkdownMapper;

}