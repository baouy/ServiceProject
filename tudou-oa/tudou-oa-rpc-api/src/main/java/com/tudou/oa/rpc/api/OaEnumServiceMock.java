package com.tudou.oa.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.oa.dao.mapper.OaEnumMapper;
import com.tudou.oa.dao.model.OaEnum;
import com.tudou.oa.dao.model.OaEnumExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 降级实现OaEnumService接口
* Created by tudou on 2017/6/24.
*/
public class OaEnumServiceMock extends BaseServiceMock<OaEnumMapper, OaEnum, OaEnumExample> implements OaEnumService {

	private static Logger _log = LoggerFactory.getLogger(OaEnumServiceMock.class);

}
