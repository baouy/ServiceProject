package com.tudou.oa.service.modelvalid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tudou.common.base.BaseModelValid;
import com.tudou.oa.service.controller.act.utils.TimeUtils;
import com.tudou.oa.service.controller.act.utils.Variable;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.bpmn.data.Data;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by DavidWang on 2017/8/21.
 */
public class ActTaskValid extends BaseModelValid{

	private String taskId; 		// 任务编号
	private String taskName; 	// 任务名称
	private String taskDefKey; 	// 任务定义Key（任务环节标识）

	private String formKey; //页面地址

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date taskCreateTime; //创建时间

	private String procInsId; 	// 流程实例ID
	private String procDefId; 	// 流程定义ID
	private String procDefKey; 	// 流程定义Key（流程定义标识）

	private String procDefName; //流程名称
	private Integer procDefVersion; //流程版本

	private String businessTable;	// 业务绑定Table
	private String businessId;		// 业务绑定ID

	private String title; 		// 任务标题

	private String status; 		// 任务状态（todo/claim/finish）

	//	private String procExecUrl; 	// 流程执行（办理）RUL
	private String comment; 	// 任务意见
	private String flag; 		// 意见状态

	private String assignee; // 任务执行人编号
	private String assigneeName; // 任务执行人名称

	private Variable vars; 		// 流程变量
//	private Variable taskVars; 	// 流程任务变量

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date beginDate;	// 开始查询日期

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date endDate;	// 结束查询日期


	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDefKey() {
		return taskDefKey;
	}

	public void setTaskDefKey(String taskDefKey) {
		this.taskDefKey = taskDefKey;
	}

	public String getProcInsId() {
		return procInsId;
	}

	public void setProcInsId(String procInsId) {
		this.procInsId = procInsId;
	}

	public String getProcDefId() {
		return procDefId;
	}

	public void setProcDefId(String procDefId) {
		this.procDefId = procDefId;
	}

	public String getProcDefKey() {
		return procDefKey;
	}

	public void setProcDefKey(String procDefKey) {
		this.procDefKey = procDefKey;
	}

	public String getBusinessTable() {
		return businessTable;
	}

	public void setBusinessTable(String businessTable) {
		this.businessTable = businessTable;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getAssigneeName() {
		return assigneeName;
	}

	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}

	public Variable getVars() {
		return vars;
	}

	public void setVars(Variable vars) {
		this.vars = vars;
	}

	public void setVars(Map<String, Object> map) {
		this.vars = new Variable(map);
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProcDefName() {
		return procDefName;
	}

	public void setProcDefName(String procDefName) {
		this.procDefName = procDefName;
	}

	public Integer getProcDefVersion() {
		return procDefVersion;
	}

	public void setProcDefVersion(Integer procDefVersion) {
		this.procDefVersion = procDefVersion;
	}

	public Date getTaskCreateTime() {
		return taskCreateTime;
	}

	public void setTaskCreateTime(Date taskCreateTime) {
		this.taskCreateTime = taskCreateTime;
	}

	public String getFormKey() {
		return formKey;
	}

	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}

	/**
	 * 是否是一个待办任务
	 * @return
	 */
	public boolean isTodoTask(){
		return "todo".equals(status) || "claim".equals(status);
	}

	/**
	 * 是否是已完成任务
	 * @return
	 */
	public boolean isFinishTask(){
		return "finish".equals(status) || StringUtils.isBlank(taskId);
	}

}
