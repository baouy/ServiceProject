package com.tudou.oa.service.modelvalid;

import com.tudou.common.base.BaseModelValid;

/**
 * Created by DavidWang on 2017/6/24.
 */
public class OaEnumValid extends BaseModelValid{

	/**
	 * 名称
	 *
	 * @mbg.generated
	 */
	private String name;

	/**
	 * 类型
	 *
	 * @mbg.generated
	 */
	private Integer type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
