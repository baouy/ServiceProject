package com.tudou.oa.common.constant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tudou.common.base.BaseResult;

/**
 * Created by DavidWang on 2017/6/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OaResult extends BaseResult{

	public OaResult(OaResultConstant oaResultConstant, Object data) {
		super(oaResultConstant.getCode(), oaResultConstant.getMessage(), data);
	}

	public OaResult(OaResultConstant oaResultConstant, Object data,Integer pageSize,Integer pageCurrent,Long total) {
		super(oaResultConstant.getCode(), oaResultConstant.getMessage(), data,pageSize,pageCurrent,total);
	}

}
