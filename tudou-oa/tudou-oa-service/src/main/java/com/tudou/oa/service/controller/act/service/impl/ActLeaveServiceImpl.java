package com.tudou.oa.service.controller.act.service.impl;

import com.google.common.collect.Maps;
import com.tudou.common.util.IdGen;
import com.tudou.common.util.TokenUtil;
import com.tudou.oa.dao.model.OaLeave;
import com.tudou.oa.dao.model.OaViewUser;
import com.tudou.oa.rpc.api.OaLeaveService;
import com.tudou.oa.service.controller.act.service.ActLeaveService;
import com.tudou.oa.service.controller.act.service.ActTaskService;
import com.tudou.oa.service.controller.act.utils.Collections3;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * Created by DavidWang on 2017/8/26.
 */
@Service("actLeaveService")
@Transactional(readOnly = true)
public class ActLeaveServiceImpl implements ActLeaveService{

	public static final String[] PD_LEAVE = new String[]{"leave", "oa_leave"};

	@Autowired
	private OaLeaveService oaLeaveService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	protected TaskService taskService;
	@Autowired
	protected HistoryService historyService;
	@Autowired
	protected RepositoryService repositoryService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private ActTaskService actTaskService;


	/**
	 * 获取流程详细及工作流参数
	 * @param id
	 */
//	@SuppressWarnings("unchecked")
//	public OaLeave get(String id) {
//		OaLeave leave = oaLeaveService.selectByPrimaryKey(Integer.valueOf(id));
//		Map<String,Object> variables=null;
//		HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(leave.getProcessInstanceId()).singleResult();
//		if(historicProcessInstance!=null) {
//			variables = Collections3.extractToMap(historyService.createHistoricVariableInstanceQuery().processInstanceId(historicProcessInstance.getId()).list(), "variableName", "value");
//		} else {
//			variables = runtimeService.getVariables(runtimeService.createProcessInstanceQuery().processInstanceId(leave.getProcessInstanceId()).active().singleResult().getId());
//		}
//		leave.setVariables(variables);
//		return leave;
//	}

	/**
	 * 启动流程
	 */
	@Transactional(readOnly = false)
	public void save(OaLeave oaLeave,boolean type,String taskId,String tag){

		// 保存业务数据
		if (StringUtils.isBlank(oaLeave.getId())){
			oaLeave.setId(IdGen.uuid());
			oaLeave.setApplyTime(new Date());
			String name = TokenUtil.getUserName();
			oaLeave.setCreateBy(name);
			oaLeave.setCreateDate(new Date());
			oaLeave.setUpdateBy(name);
			oaLeave.setUpdateDate(new Date());
			oaLeaveService.insertSelective(oaLeave);

			OaViewUser oaViewUser = (OaViewUser) TokenUtil.getUserObject();
			// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
			identityService.setAuthenticatedUserId(oaViewUser.getUserId().toString());
			// 启动流程
			String businessKey = oaLeave.getId().toString();
			Map<String, Object> variables = Maps.newHashMap();
			variables.put("title",name+"[请假单]");
			variables.put("type", "leave");
			variables.put("busId", businessKey);
			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PD_LEAVE[0], businessKey, variables);
			// 更新流程实例ID
			oaLeave.setProcessInstanceId(processInstance.getId());
			oaLeaveService.updateByPrimaryKeySelective(oaLeave);

		}else{
			oaLeave.setUpdateBy(TokenUtil.getUserName());
			oaLeave.setUpdateDate(new Date());
			oaLeaveService.updateByPrimaryKeySelective(oaLeave);
			String remarks = (type?"[同意]":"[驳回]")+oaLeave.getRemarks();
			Map<String, Object> vars = Maps.newHashMap();
			vars.put(tag, type);
			actTaskService.complete(taskId, oaLeave.getProcessInstanceId(), remarks, vars);

		}


	}

}
