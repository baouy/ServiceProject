package com.tudou.upms.server.modelvalid;

import com.tudou.common.base.BaseModelValid;

/**
 * Created by DavidWang on 2017/8/18.
 */
public class ProcessRunValid extends BaseModelValid{

	private String id;

	private String processInstanceId;

	private String processDefinitionId;

	private String activityId;

	private String procDefKey;

	private boolean suspended;

	private Integer version;

	private long maxnum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public String getProcDefKey() {
		return procDefKey;
	}

	public void setProcDefKey(String procDefKey) {
		this.procDefKey = procDefKey;
	}

	public long getMaxnum() {
		return maxnum;
	}

	public void setMaxnum(long maxnum) {
		this.maxnum = maxnum;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
