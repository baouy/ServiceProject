package com.tudou.oa.service.controller.act.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tudou.common.util.TokenUtil;
import com.tudou.oa.dao.model.OaViewUser;
import com.tudou.oa.service.controller.act.service.ActTaskService;
import com.tudou.oa.service.controller.act.utils.ProcessDefCache;
import com.tudou.oa.service.controller.act.utils.TimeUtils;
import com.tudou.oa.service.modelvalid.ActHistoicFlowValid;
import com.tudou.oa.service.modelvalid.ActTaskValid;
import com.tudou.oa.service.modelvalid.ProcessValid;
import com.tudou.upms.dao.model.UpmsUser;
import com.tudou.upms.rpc.api.UpmsUserService;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.*;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.*;


/**
 * 流程定义相关Service
 * @author ThinkGem
 * @version 2013-11-03
 */
@Service
@Transactional(readOnly = true)
public class ActTaskServiceImpl implements ActTaskService{

	@Autowired
	private ProcessEngineFactoryBean processEngineFactory;
	@Autowired
	private ProcessEngine processEngine;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private FormService formService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private UpmsUserService upmsUserService;

	/**
	 * 获取待办列表
	 * @return
	 */
	public List<ActTaskValid> todoList(ActTaskValid act){

		OaViewUser oaViewUser = (OaViewUser) TokenUtil.getUserObject();

		List<ActTaskValid> result = new ArrayList<ActTaskValid>();

		// =============== 已经签收的任务  ===============
		TaskQuery todoTaskQuery = taskService.createTaskQuery().taskAssignee(oaViewUser.getUserId().toString()).active()
				.includeProcessVariables().orderByTaskCreateTime().desc();

		// 设置查询条件
		if (StringUtils.isNotBlank(act.getProcDefKey())){
			todoTaskQuery.processDefinitionKey(act.getProcDefKey());
		}
		if (act.getBdate() != null){
			todoTaskQuery.taskCreatedAfter(new Date(act.getBdate()));
		}
		if (act.getEdate() != null){
			todoTaskQuery.taskCreatedBefore(new Date(act.getEdate()));
		}

		// 查询列表
		List<Task> todoList = todoTaskQuery.list();
		for (Task task : todoList) {
			ActTaskValid e = new ActTaskValid();
			e.setTaskName(task.getName());
			e.setAssignee(task.getAssignee());
			e.setTaskId(task.getId());
			e.setTaskDefKey(task.getTaskDefinitionKey());
			e.setTaskCreateTime(task.getCreateTime());
			e.setExecutionId(task.getExecutionId());
			e.setProcInsId(task.getProcessInstanceId());
			e.setProcDefId(task.getProcessDefinitionId());
			e.setVars(task.getProcessVariables());
			ProcessDefinition processDefinition = ProcessDefCache.get(task.getProcessDefinitionId());
			e.setProcDefName(processDefinition.getName());
			e.setProcDefVersion(processDefinition.getVersion());
			e.setStatus("todo");
			result.add(e);
		}

		// =============== 等待签收的任务  ===============
		TaskQuery toClaimQuery = taskService.createTaskQuery().taskCandidateUser(oaViewUser.getUserId().toString())
				.includeProcessVariables().active().orderByTaskCreateTime().desc();

		// 设置查询条件
		if (StringUtils.isNotBlank(act.getProcDefKey())){
			toClaimQuery.processDefinitionKey(act.getProcDefKey());
		}
		if (act.getBeginDate() != null){
			toClaimQuery.taskCreatedAfter(act.getBeginDate());
		}
		if (act.getEndDate() != null){
			toClaimQuery.taskCreatedBefore(act.getEndDate());
		}

		// 查询列表
		List<Task> toClaimList = toClaimQuery.list();
		for (Task task : toClaimList) {
			ActTaskValid e = new ActTaskValid();
			e.setTaskName(task.getName());
			e.setAssignee(task.getAssignee());
			e.setTaskId(task.getId());
			e.setTaskDefKey(task.getTaskDefinitionKey());
			e.setTaskCreateTime(task.getCreateTime());
			e.setExecutionId(task.getExecutionId());
			e.setProcInsId(task.getProcessInstanceId());
			e.setProcDefId(task.getProcessDefinitionId());
			e.setVars(task.getProcessVariables());
			ProcessDefinition processDefinition = ProcessDefCache.get(task.getProcessDefinitionId());
			e.setProcDefName(processDefinition.getName());
			e.setProcDefVersion(processDefinition.getVersion());
			e.setStatus("claim");
			result.add(e);
		}
		return result;
	}


	/**
	 * 获取流程列表
	 */
	public List<ProcessValid> processList(ProcessValid processValid, int pc, int ps) {
		/*
		 * 保存两个对象，一个是ProcessDefinition（流程定义），一个是Deployment（流程部署）
		 */
	    ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery()
	    		.latestVersion().active().orderByProcessDefinitionKey().asc();
	    
	    if (StringUtils.isNotEmpty(processValid.getCategory())){
	    	processDefinitionQuery.processDefinitionCategory(processValid.getCategory());
		}

		if (StringUtils.isNotEmpty(processValid.getKey())) {
			processDefinitionQuery.processDefinitionKeyLike(processValid.getKey());
		}

		if (StringUtils.isNotEmpty(processValid.getName())) {
			processDefinitionQuery.processDefinitionNameLike(processValid.getName());
		}

		if (processValid.getVersion() != null) {
			processDefinitionQuery.processDefinitionVersion(processValid.getVersion());
		}

		long maxnum = processDefinitionQuery.count();
		processValid.setMaxunum(maxnum);
	    
	    List<ProcessDefinition> processDefinitionList = processDefinitionQuery.listPage(pc, ps);
		List<ProcessValid> list = new ArrayList<ProcessValid>();
	    for (ProcessDefinition processDefinition : processDefinitionList) {

			ProcessValid processValid1 = new ProcessValid();
			processValid1.setId(processDefinition.getId());
			processValid1.setKey(processDefinition.getKey());
			processValid1.setName(processDefinition.getName());
			processValid1.setVersion(processDefinition.getVersion());
			processValid1.setCategory(processDefinition.getCategory());
			processValid1.setDiagramResourceName(processDefinition.getDiagramResourceName());
			String deploymentId = processDefinition.getDeploymentId();
			Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
			processValid1.setDeploymentTime(deployment.getDeploymentTime());
			list.add(processValid1);
	    }

		return list;
	}

	/**
	 * 获取流程表单（首先获取任务节点表单KEY，如果没有则取流程开始节点表单KEY）
	 * @return
	 */
	public String getFormKey(String procDefId, String taskDefKey){
		String formKey = "";
		if (StringUtils.isNotBlank(procDefId)){
			if (StringUtils.isNotBlank(taskDefKey)){
				try{
					formKey = formService.getTaskFormKey(procDefId, taskDefKey);
				}catch (Exception e) {
					formKey = "";
				}
			}
			if (StringUtils.isBlank(formKey)){
				formKey = formService.getStartFormKey(procDefId);
			}
			if (StringUtils.isBlank(formKey)){
				formKey = "404";
			}
		}

		return formKey;
	}

	/**
	 * 获取流程实例对象
	 * @param procInsId
	 * @return
	 */
	@Transactional(readOnly = false)
	public ProcessInstance getProcIns(String procInsId) {
		return runtimeService.createProcessInstanceQuery().processInstanceId(procInsId).singleResult();
	}

	/**
	 * 签收任务
	 * @param taskId 任务ID
	 * @param userId 签收用户ID（用户登录名）
	 */
	@Transactional(readOnly = false)
	public void claim(String taskId, String userId){
		taskService.claim(taskId, userId);
	}

	/**
	 * 提交任务, 并保存意见
	 * @param taskId 任务ID
	 * @param procInsId 流程实例ID，如果为空，则不保存任务提交意见
	 * @param comment 任务提交意见的内容
	 * @param vars 任务变量
	 */
	@Transactional(readOnly = false)
	public void complete(String taskId, String procInsId, String comment, Map<String, Object> vars){
		complete(taskId, procInsId, comment, "", vars);
	}

	/**
	 * 提交任务, 并保存意见
	 * @param taskId 任务ID
	 * @param procInsId 流程实例ID，如果为空，则不保存任务提交意见
	 * @param comment 任务提交意见的内容
	 * @param title			流程标题，显示在待办任务标题
	 * @param vars 任务变量
	 */
	@Transactional(readOnly = false)
	public void complete(String taskId, String procInsId, String comment, String title, Map<String, Object> vars){
		// 添加意见
		if (StringUtils.isNotBlank(procInsId) && StringUtils.isNotBlank(comment)){
			taskService.addComment(taskId, procInsId, comment);
		}

		// 设置流程变量
		if (vars == null){
			vars = Maps.newHashMap();
		}

		// 设置流程标题
		if (StringUtils.isNotBlank(title)){
			vars.put("title", title);
		}

		// 提交任务
		taskService.complete(taskId, vars);
	}

	/**
	 * 获取流转历史列表
	 * @param procInsId 流程实例
	 * @param startAct 开始活动节点名称
	 * @param endAct 结束活动节点名称
	 */
	public List<ActHistoicFlowValid> histoicFlowList(String procInsId, String startAct, String endAct){
		List<ActHistoicFlowValid> actList = Lists.newArrayList();
		List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery().processInstanceId(procInsId)
				.orderByHistoricActivityInstanceStartTime().asc().orderByHistoricActivityInstanceEndTime().asc().list();

		boolean start = false;
		Map<String, Integer> actMap = Maps.newHashMap();

		for (int i=0; i<list.size(); i++){

			HistoricActivityInstance histIns = list.get(i);

			// 过滤开始节点前的节点
			if (StringUtils.isNotBlank(startAct) && startAct.equals(histIns.getActivityId())){
				start = true;
			}
			if (StringUtils.isNotBlank(startAct) && !start){
				continue;
			}

			// 只显示开始节点和结束节点，并且执行人不为空的任务
			if (StringUtils.isNotBlank(histIns.getAssignee())
					|| "startEvent".equals(histIns.getActivityType())
					|| "endEvent".equals(histIns.getActivityType())){

				// 给节点增加一个序号
				Integer actNum = actMap.get(histIns.getActivityId());
				if (actNum == null){
					actMap.put(histIns.getActivityId(), actMap.size());
				}

				ActHistoicFlowValid e = new ActHistoicFlowValid();
				e.setActivityName(histIns.getActivityName());
				e.setStartTime(histIns.getStartTime());
				e.setEndTime(histIns.getEndTime());
				if (histIns!=null && histIns.getDurationInMillis() != null){
					e.setDurationTime(TimeUtils.toTimeString(histIns.getDurationInMillis()));
				}
				// 获取流程发起人名称
				if ("startEvent".equals(histIns.getActivityType())){
					List<HistoricProcessInstance> il = historyService.createHistoricProcessInstanceQuery().processInstanceId(procInsId).orderByProcessInstanceStartTime().asc().list();
//					List<HistoricIdentityLink> il = historyService.getHistoricIdentityLinksForProcessInstance(procInsId);
					if (il.size() > 0){
						if (StringUtils.isNotBlank(il.get(0).getStartUserId())){
							UpmsUser upmsUser = upmsUserService.selectByPrimaryKey(Integer.valueOf(il.get(0).getStartUserId()));
							if (upmsUser != null){
//								e.setAssignee(histIns.getAssignee());
								e.setAssigneeName(upmsUser.getUsername());
							}
						}
					}
				}
				// 获取任务执行人名称
				if (StringUtils.isNotEmpty(histIns.getAssignee())){
					UpmsUser upmsUser = upmsUserService.selectByPrimaryKey(Integer.valueOf(histIns.getAssignee()));
					if (upmsUser != null){
//						e.setAssignee(histIns.getAssignee());
						e.setAssigneeName(upmsUser.getUsername());
					}
				}
				// 获取意见评论内容
				if (StringUtils.isNotBlank(histIns.getTaskId())){
					List<Comment> commentList = taskService.getTaskComments(histIns.getTaskId());
					if (commentList.size()>0){
						e.setComment(commentList.get(0).getFullMessage());
					}
				}
				actList.add(e);
			}

			// 过滤结束节点后的节点
			if (StringUtils.isNotBlank(endAct) && endAct.equals(histIns.getActivityId())){
				boolean bl = false;
				Integer actNum = actMap.get(histIns.getActivityId());
				// 该活动节点，后续节点是否在结束节点之前，在后续节点中是否存在
				for (int j=i+1; j<list.size(); j++){
					HistoricActivityInstance hi = list.get(j);
					Integer actNumA = actMap.get(hi.getActivityId());
					if ((actNumA != null && actNumA < actNum) || StringUtils.equals(hi.getActivityId(), histIns.getActivityId())){
						bl = true;
					}
				}
				if (!bl){
					break;
				}
			}
		}
		return actList;
	}

	public List<ActTaskValid> historicList(ActTaskValid act, int pc, int ps){
		OaViewUser oaViewUser = (OaViewUser) TokenUtil.getUserObject();
		HistoricTaskInstanceQuery histTaskQuery = historyService.createHistoricTaskInstanceQuery().taskAssignee(oaViewUser.getUserId().toString()).finished()
				.includeProcessVariables().orderByHistoricTaskInstanceEndTime().desc();

		// 设置查询条件
		if (StringUtils.isNotBlank(act.getProcDefKey())){
			histTaskQuery.processDefinitionKey(act.getProcDefKey());
		}
		if (act.getBdate() != null){
			histTaskQuery.taskCompletedAfter(new Date(act.getBdate()));
		}
		if (act.getEdate() != null){
			histTaskQuery.taskCompletedBefore(new Date(act.getEdate()));
		}

		// 查询总数
		act.setMaxnum(histTaskQuery.count());

		// 查询列表
		List<HistoricTaskInstance> histList = histTaskQuery.listPage(pc, ps);
		//处理分页问题
		List<ActTaskValid> actList=Lists.newArrayList();
		for (HistoricTaskInstance histTask : histList) {
			ActTaskValid e = new ActTaskValid();
			e.setTaskId(histTask.getId());
			e.setTaskName(histTask.getName());
			e.setProcDefId(histTask.getProcessDefinitionId());
			e.setProcInsId(histTask.getProcessInstanceId());
			e.setTaskDefKey(histTask.getTaskDefinitionKey());
			e.setExecutionId(histTask.getExecutionId());
			e.setEndDate(histTask.getEndTime());
			ProcessDefinition processDefinition = ProcessDefCache.get(histTask.getProcessDefinitionId());
			e.setProcDefName(processDefinition.getName());
			e.setProcDefVersion(processDefinition.getVersion());
			e.setVars(histTask.getProcessVariables());
			e.setStatus("finish");
			actList.add(e);
		}

		return actList;
	}


	@Transactional(readOnly = false)
	public void deleteTask(String taskId, String deleteReason){
		taskService.deleteTask(taskId, deleteReason);
	}

	/**
	 * 读取带跟踪的图片
	 * @param executionId	环节ID
	 * @return	封装了各种节点信息
	 */
	public InputStream tracePhoto(String processDefinitionId, String executionId) {
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
		List<String> activeActivityIds = Lists.newArrayList();
		if (runtimeService.createExecutionQuery().executionId(executionId).count() > 0){
			activeActivityIds = runtimeService.getActiveActivityIds(executionId);
		}
		// 使用spring注入引擎请使用下面的这行代码
		Context.setProcessEngineConfiguration(processEngineFactory.getProcessEngineConfiguration());
		return processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator()
				.generateDiagram(bpmnModel, "png", activeActivityIds);
	}



}
