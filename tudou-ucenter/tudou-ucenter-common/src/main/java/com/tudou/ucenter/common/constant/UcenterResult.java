package com.tudou.ucenter.common.constant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tudou.common.base.BaseResult;

/**
 * Created by DavidWang on 2017/6/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UcenterResult extends BaseResult{

	public UcenterResult(UcenterResultConstant ucenterResultConstant, Object data) {
		super(ucenterResultConstant.getCode(), ucenterResultConstant.getMessage(), data);
	}

	public UcenterResult(UcenterResultConstant ucenterResultConstant, Object data,Integer pageSize,Integer pageCurrent,Long total) {
		super(ucenterResultConstant.getCode(), ucenterResultConstant.getMessage(), data,pageSize,pageCurrent,total);
	}
}
