package com.tudou.oss.common.constant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tudou.common.base.BaseResult;

/**
 * Created by DavidWang on 2017/6/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OssResult extends BaseResult{

	public OssResult(OssResultConstant ossResultConstant, Object data) {
		super(ossResultConstant.getCode(), ossResultConstant.getMessage(), data);
	}

	public OssResult(OssResultConstant ossResultConstant, Object data, Integer pageSize, Integer pageCurrent, Long total) {
		super(ossResultConstant.getCode(), ossResultConstant.getMessage(), data,pageSize,pageCurrent,total);
	}

}
