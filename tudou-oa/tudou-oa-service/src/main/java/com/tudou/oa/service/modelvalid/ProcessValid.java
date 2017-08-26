package com.tudou.oa.service.modelvalid;

import com.tudou.common.base.BaseModelValid;

import java.util.Date;

/**
 * Created by DavidWang on 2017/8/15.
 */
public class ProcessValid extends BaseModelValid{

	private String id;

	private String key;

	private String name;

	private Integer version;

	private Date deploymentTime;

	private String category;

	private String resourceName;

	private String diagramResourceName;

	private boolean suspended;

	private String deploymentId;

	private long maxunum;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getDeploymentTime() {
		return deploymentTime;
	}

	public void setDeploymentTime(Date deploymentTime) {
		this.deploymentTime = deploymentTime;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getDiagramResourceName() {
		return diagramResourceName;
	}

	public void setDiagramResourceName(String diagramResourceName) {
		this.diagramResourceName = diagramResourceName;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public long getMaxunum() {
		return maxunum;
	}

	public void setMaxunum(long maxunum) {
		this.maxunum = maxunum;
	}
}
