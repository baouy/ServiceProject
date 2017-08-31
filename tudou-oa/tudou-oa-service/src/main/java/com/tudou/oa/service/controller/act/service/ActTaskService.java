package com.tudou.oa.service.controller.act.service;

import com.tudou.oa.service.modelvalid.ActHistoicFlowValid;
import com.tudou.oa.service.modelvalid.ActTaskValid;
import com.tudou.oa.service.modelvalid.ProcessValid;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

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

	/**
	 * 签收任务
	 * @param taskId 任务ID
	 * @param userId 签收用户ID（用户登录名）
	 */
	public void claim(String taskId, String userId);

	/**
	 * 提交任务, 并保存意见
	 * @param taskId 任务ID
	 * @param procInsId 流程实例ID，如果为空，则不保存任务提交意见
	 * @param comment 任务提交意见的内容
	 * @param vars 任务变量
	 */
	public void complete(String taskId, String procInsId, String comment, Map<String, Object> vars);

	/**
	 * 提交任务, 并保存意见
	 * @param taskId 任务ID
	 * @param procInsId 流程实例ID，如果为空，则不保存任务提交意见
	 * @param comment 任务提交意见的内容
	 * @param title			流程标题，显示在待办任务标题
	 * @param vars 任务变量
	 */
	public void complete(String taskId, String procInsId, String comment, String title, Map<String, Object> vars);

	/**
	 * 获取流转历史列表
	 * @param procInsId 流程实例
	 * @param startAct 开始活动节点名称
	 * @param endAct 结束活动节点名称
	 */
	public List<ActHistoicFlowValid> histoicFlowList(String procInsId, String startAct, String endAct);


	/**
	 * 获取已办任务
	 * @return
	 */
	public List<ActTaskValid> historicList(ActTaskValid act, int pc, int ps);

	/**
	 * 删除任务
	 * @param taskId 任务ID
	 * @param deleteReason 删除原因
	 */
	public void deleteTask(String taskId, String deleteReason);


	/**
	 * 读取带跟踪的图片
	 * @param executionId	环节ID
	 * @return	封装了各种节点信息
	 */
	public InputStream tracePhoto(String processDefinitionId, String executionId);
}
