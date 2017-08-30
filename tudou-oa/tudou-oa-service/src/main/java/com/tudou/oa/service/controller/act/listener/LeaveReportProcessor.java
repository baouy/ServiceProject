package com.tudou.oa.service.controller.act.listener;

import com.tudou.oa.dao.model.OaLeave;
import com.tudou.oa.rpc.api.OaLeaveService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 销假后处理器
 */
@Service
@Transactional
public class LeaveReportProcessor implements TaskListener {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private OaLeaveService oaLeaveService;
	
	/**
	 * 销假完成后执行，保存实际开始和结束时间
	 */
	public void notify(DelegateTask delegateTask) {
		String processInstanceId = delegateTask.getProcessInstanceId();
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
		OaLeave oaLeave = new OaLeave();
		oaLeave.setId(processInstance.getBusinessKey());
		oaLeave.setRealityStartTime(new Date());
		oaLeave.setRealityEndTime(new Date());
		oaLeaveService.updateByPrimaryKeySelective(oaLeave);

	}

}
