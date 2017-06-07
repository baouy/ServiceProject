package com.tudou.upms.rpc.api;

import com.tudou.common.base.BaseService;
import com.tudou.upms.dao.model.UpmsUserRole;
import com.tudou.upms.dao.model.UpmsUserRoleExample;

/**
* UpmsUserRoleService接口
* Created by tudou on 2017/5/27.
*/
public interface UpmsUserRoleService extends BaseService<UpmsUserRole, UpmsUserRoleExample> {

	/**
	 * 用户角色
	 * @param roleIds 角色ids
	 * @param id 用户id
	 * @return
	 */
	int role(String[] roleIds, int id);

}