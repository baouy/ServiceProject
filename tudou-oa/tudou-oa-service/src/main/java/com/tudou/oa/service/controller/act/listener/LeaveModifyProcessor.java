package com.tudou.oa.service.controller.act.listener;

import com.tudou.common.util.TokenUtil;
import com.tudou.oa.dao.model.OaLeave;
import com.tudou.oa.rpc.api.OaLeaveService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


/**
 * 调整请假内容处理器
 */
@Service
@Transactional
public class LeaveModifyProcessor implements TaskListener {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private OaLeaveService oaLeaveService;

	@Autowired
	private RuntimeService runtimeService;

	//delegateTask.getVariable("leaveType") 得到Map<String, Object> key的值
	public void notify(DelegateTask delegateTask) {
//		String processInstanceId = delegateTask.getProcessInstanceId();
//		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
//		OaLeave oaLeave = new OaLeave();
//		oaLeave.setId(processInstance.getBusinessKey());
//		oaLeave.setLeaveType((String) delegateTask.getVariable("leaveType"));
//		oaLeave.setStartTime((Date) delegateTask.getVariable("startTime"));
//		oaLeave.setEndTime((Date) delegateTask.getVariable("endTime"));
//		oaLeave.setReason((String) delegateTask.getVariable("reason"));
//		oaLeave.setUpdateBy(TokenUtil.getUserName());
//		oaLeave.setUpdateDate(new Date());
//		oaLeaveService.updateByPrimaryKeySelective(oaLeave);
	}

}
