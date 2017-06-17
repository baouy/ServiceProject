package com.tudou.upms.rpc.api;

import com.tudou.common.base.BaseServiceMock;
import com.tudou.upms.dao.mapper.UpmsOrganizationMapper;
import com.tudou.upms.dao.model.UpmsOrganization;
import com.tudou.upms.dao.model.UpmsOrganizationExample;

/**
* 降级实现UpmsOrganizationService接口
* Created by tudou on 2017/5/27.
*/
public class UpmsOrganizationServiceMock extends BaseServiceMock<UpmsOrganizationMapper, UpmsOrganization, UpmsOrganizationExample> implements UpmsOrganizationService {

	@Override
	public UpmsOrganization createUpmsOrganization(UpmsOrganization upmsOrganization) {
		return null;
	}
}
