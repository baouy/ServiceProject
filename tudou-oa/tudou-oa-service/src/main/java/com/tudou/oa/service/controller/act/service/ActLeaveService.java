package com.tudou.oa.service.controller.act.service;

import com.tudou.oa.dao.model.OaLeave;

/**
 * Created by DavidWang on 2017/8/26.
 */
public interface ActLeaveService {

	public void save(OaLeave oaLeave,boolean type,String taskId,String tag);

}
