package com.tudou.upms.server.modelvalid;

import com.tudou.common.base.BaseModelValid;

/**
 * Created by DavidWang on 2017/6/6.
 */
public class UpmsSystemValid extends BaseModelValid{


	/**
	 * 根目录
	 *
	 * @mbg.generated
	 */
	private String basepath;

	/**
	 * 状态(-1:黑名单,1:正常)
	 *
	 * @mbg.generated
	 */
	private Byte status;

	/**
	 * 系统名称
	 *
	 * @mbg.generated
	 */
	private String name;

	/**
	 * 系统标题
	 *
	 * @mbg.generated
	 */
	private String title;

	/**
	 * 系统描述
	 *
	 * @mbg.generated
	 */
	private String description;

	public String getBasepath() {
		return basepath;
	}

	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
