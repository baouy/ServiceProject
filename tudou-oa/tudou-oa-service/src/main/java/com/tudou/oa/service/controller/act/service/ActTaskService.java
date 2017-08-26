package com.tudou.oa.service.controller.act.service;

import com.tudou.oa.service.modelvalid.ActTaskValid;
import com.tudou.oa.service.modelvalid.ProcessValid;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;

public interface ActTaskService{

	/**
	 * 获取待办列表
	 * @return
	 */
	public List<ActTaskValid> todoList(ActTaskValid act);

	/**
	 * 获取流程列表
	 */
	public List<ProcessValid> processList(ProcessValid processValid, int pc, int ps);

	/**
	 * 获取流程表单（首先获取任务节点表单KEY，如果没有则取流程开始节点表单KEY）
	 * @return
	 */
	public String getFormKey(String procDefId, String taskDefKey);

	/**
	 * 获取流程实例对象
	 * @param procInsId
	 * @return
	 */
	public ProcessInstance getProcIns(String procInsId);

}
