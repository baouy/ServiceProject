package com.tudou.pay.common.constant;

import com.tudou.common.base.BaseResult;

public class PayResult extends BaseResult {

	public PayResult(PayResultConstant payResultConstant, Object data) {
		super(payResultConstant.getCode(), payResultConstant.getMessage(), data);
	}

	public PayResult(PayResultConstant payResultConstant, Object data, Integer pageSize, Integer pageCurrent, Long total) {
		super(payResultConstant.getCode(), payResultConstant.getMessage(), data,pageSize,pageCurrent,total);
	}
}
