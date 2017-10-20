package com.tudou.gen.common.constant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tudou.common.base.BaseResult;

/**
 * Created by DavidWang on 2017/6/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenResult extends BaseResult{

	public GenResult(GenResultConstant genResultConstant, Object data) {
		super(genResultConstant.getCode(), genResultConstant.getMessage(), data);
	}

	public GenResult(GenResultConstant genResultConstant, Object data, Integer pageSize, Integer pageCurrent, Long total) {
		super(genResultConstant.getCode(), genResultConstant.getMessage(), data,pageSize,pageCurrent,total);
	}

}
