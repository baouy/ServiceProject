package com.tudou.upms.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.upms.dao.mapper.UpmsUserOrganizationMapper;
import com.tudou.upms.dao.model.UpmsUserOrganization;
import com.tudou.upms.dao.model.UpmsUserOrganizationExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 降级实现UpmsUserOrganizationService接口
* Created by tudou on 2017/5/27.
*/
public class UpmsUserOrganizationServiceMock extends BaseServiceMock<UpmsUserOrganizationMapper, UpmsUserOrganization, UpmsUserOrganizationExample> implements UpmsUserOrganizationService {

	private static Logger _log = LoggerFactory.getLogger(UpmsUserOrganizationServiceMock.class);

	@Override
	public int organization(String[] organizationIds, int id) {
		_log.info("UpmsUserOrganizationServiceMock => organization");
		return 0;
	}

}
