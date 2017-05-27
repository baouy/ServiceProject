package com.tudou.upms.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.upms.dao.mapper.UpmsSystemMapper;
import com.tudou.upms.dao.model.UpmsSystem;
import com.tudou.upms.dao.model.UpmsSystemExample;

/**
* 降级实现UpmsSystemService接口
* Created by tudou on 2017/5/27.
*/
public class UpmsSystemServiceMock extends BaseServiceMock<UpmsSystemMapper, UpmsSystem, UpmsSystemExample> implements UpmsSystemService {

}
