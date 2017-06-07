package com.tudou.upms.server.modelvalid;

import com.tudou.common.base.BaseModelValid;
import io.swagger.annotations.ApiParam;

/**
 * Created by DavidWang on 2017/6/7.
 */
public class OrganizationValid extends BaseModelValid{

	/**
	 * 编号
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "编号",required = false)
	private Integer organizationId;
	/**
	 * 所属上级
	 *
	 * @mbg.generated
	 */
	/**
	 * 组织名称
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "组织名称",required = false)
	private String name;

	/**
	 * 组织描述
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "组织描述",required = false)
	private String description;

	/**
	 * 创建时间
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "创建时间",required = false)
	private Long ctime;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCtime() {
		return ctime;
	}

	public void setCtime(Long ctime) {
		this.ctime = ctime;
	}
}
