package com.tudou.oa.service.modelvalid;

import com.tudou.common.base.BaseModelValid;
import io.swagger.annotations.ApiParam;

/**
 * Created by DavidWang on 2017/8/9.
 */
public class ModelValid extends BaseModelValid {

	@ApiParam(value = "模型ID",required = false)
	private String id;

	@ApiParam(value = "模型名称",required = false)
	private String name;

	@ApiParam(value = "模型标示",required = false)
	private String key;

	@ApiParam(value = "模型描述",required = false)
	private String description;

	@ApiParam(value = "模型分类",required = false)
	private String category;

	@ApiParam(value = "模型版本",required = false)
	private Integer version;

	private Long maxnum;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Long getMaxnum() {
		return maxnum;
	}

	public void setMaxnum(Long maxnum) {
		this.maxnum = maxnum;
	}
}
