package com.tudou.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.tudou.common.base.BaseService;
import com.tudou.upms.dao.model.UpmsPermission;
import com.tudou.upms.dao.model.UpmsPermissionExample;

/**
* UpmsPermissionService接口
* Created by tudou on 2017/5/27.
*/
public interface UpmsPermissionService extends BaseService<UpmsPermission, UpmsPermissionExample> {

	JSONArray getTreeByRoleId(Integer roleId);

	JSONArray getTreeByUserId(Integer usereId, Byte type);

}