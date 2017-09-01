package com.tudou.gen.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.gen.dao.mapper.GenTableMapper;
import com.tudou.gen.dao.model.GenTable;
import com.tudou.gen.dao.model.GenTableExample;

/**
* 降级实现GenTableService接口
* Created by tudou on 2017/9/1.
*/
public class GenTableServiceMock extends BaseServiceMock<GenTableMapper, GenTable, GenTableExample> implements GenTableService {

}
