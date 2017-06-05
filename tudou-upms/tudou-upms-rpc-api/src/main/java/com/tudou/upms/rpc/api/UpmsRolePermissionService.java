package com.tudou.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.tudou.common.base.BaseService;
import com.tudou.upms.dao.model.UpmsRolePermission;
import com.tudou.upms.dao.model.UpmsRolePermissionExample;

/**
* UpmsRolePermissionService接口
* Created by tudou on 2017/5/27.
*/
public interface UpmsRolePermissionService extends BaseService<UpmsRolePermission, UpmsRolePermissionExample> {

	/**
	 * 角色权限
	 * @param datas 权限数据
	 * @param id 角色id
	 * @return
	 */
	int rolePermission(JSONArray datas, int id);

}