package com.tudou.upms.rpc.api;

import com.tudou.common.base.BaseService;
import com.tudou.upms.dao.model.UpmsUserOrganization;
import com.tudou.upms.dao.model.UpmsUserOrganizationExample;

/**
* UpmsUserOrganizationService接口
* Created by tudou on 2017/5/27.
*/
public interface UpmsUserOrganizationService extends BaseService<UpmsUserOrganization, UpmsUserOrganizationExample> {

	/**
	 * 用户组织
	 * @param organizationIds 组织ids
	 * @param id 用户id
	 * @return
	 */
	int organization(String[] organizationIds, int id);

}