package com.tudou.oa.service.controller.act.service.impl;

import com.tudou.common.util.RedisUtil;
import com.tudou.common.util.SerializeUtil;
import com.tudou.oa.dao.model.OaViewUser;
import com.tudou.oa.service.controller.act.service.ActTaskService;
import com.tudou.oa.service.controller.act.utils.ProcessDefCache;
import com.tudou.oa.service.modelvalid.ActTaskValid;
import com.tudou.oa.service.modelvalid.ProcessValid;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * 获取待办列表
	 * @return
	 */
	public List<ActTaskValid> todoList(ActTaskValid act){

		Subject subject = SecurityUtils.getSubject();
		String username = subject.getPrincipal().toString();
		OaViewUser oaViewUser = (OaViewUser) SerializeUtil.deserialize(RedisUtil.get(username.getBytes()));

		List<ActTaskValid> result = new ArrayList<ActTaskValid>();

		// =============== 已经签收的任务  ===============
		TaskQuery todoTaskQuery = taskService.createTaskQuery().taskAssignee(oaViewUser.getUserId().toString()).active()
				.includeProcessVariables().orderByTaskCreateTime().desc();

		// 设置查询条件
		if (StringUtils.isNotBlank(act.getProcDefKey())){
			todoTaskQuery.processDefinitionKey(act.getProcDefKey());
		}
		if (act.getBeginDate() != null){
			todoTaskQuery.taskCreatedAfter(act.getBeginDate());
		}
		if (act.getEndDate() != null){
			todoTaskQuery.taskCreatedBefore(act.getEndDate());
		}

		// 查询列表
		List<Task> todoList = todoTaskQuery.list();
		for (Task task : todoList) {
			ActTaskValid e = new ActTaskValid();
			e.setTask(task);
			e.setVars(task.getProcessVariables());
			e.setProcDef(ProcessDefCache.get(task.getProcessDefinitionId()));
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
			e.setTask(task);
			e.setVars(task.getProcessVariables());
			e.setProcDef(ProcessDefCache.get(task.getProcessDefinitionId()));
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

}
