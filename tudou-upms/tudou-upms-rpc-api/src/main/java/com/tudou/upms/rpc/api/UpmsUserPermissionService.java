package com.tudou.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.tudou.common.base.BaseService;
import com.tudou.upms.dao.model.UpmsUserPermission;
import com.tudou.upms.dao.model.UpmsUserPermissionExample;

/**
* UpmsUserPermissionService接口
* Created by tudou on 2017/5/27.
*/
public interface UpmsUserPermissionService extends BaseService<UpmsUserPermission, UpmsUserPermissionExample> {

	/**
	 * 用户权限
	 * @param datas 权限数据
	 * @param id 用户id
	 * @return
	 */
	int permission(JSONArray datas, int id);

}