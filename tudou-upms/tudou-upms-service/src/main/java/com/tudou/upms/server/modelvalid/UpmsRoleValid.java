package com.tudou.upms.server.modelvalid;

import com.tudou.common.base.BaseModelValid;
import io.swagger.annotations.ApiParam;

/**
 * Created by DavidWang on 2017/6/13.
 */
public class UpmsRoleValid extends BaseModelValid{

	/**
	 * 编号
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "编号",required = false)
	private Integer roleId;

	/**
	 * 角色名称
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "角色名称",required = false)
	private String name;

	/**
	 * 角色标题
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "角色标题",required = false)
	private String title;

	/**
	 * 角色描述
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "角色描述",required = false)
	private String description;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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
