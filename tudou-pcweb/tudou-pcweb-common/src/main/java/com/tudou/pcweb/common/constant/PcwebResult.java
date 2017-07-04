package com.tudou.pcweb.common.constant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tudou.common.base.BaseResult;

/**
 * Created by DavidWang on 2017/7/4.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PcwebResult extends BaseResult {

	public PcwebResult(PcwebResultConstant pcwebResultConstant, Object data) {
		super(pcwebResultConstant.getCode(), pcwebResultConstant.getMessage(), data);
	}

	public PcwebResult(PcwebResultConstant pcwebResultConstant, Object data,Integer pageSize,Integer pageCurrent,Integer total) {
		super(pcwebResultConstant.getCode(), pcwebResultConstant.getMessage(), data,pageSize,pageCurrent,total);
	}
}
