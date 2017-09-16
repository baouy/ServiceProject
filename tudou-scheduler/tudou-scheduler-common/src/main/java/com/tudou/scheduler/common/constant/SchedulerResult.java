package com.tudou.scheduler.common.constant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tudou.common.base.BaseResult;

/**
 * Created by DavidWang on 2017/6/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchedulerResult extends BaseResult{

	public SchedulerResult(SchedulerResultConstant schedulerResultConstant, Object data) {
		super(schedulerResultConstant.getCode(), schedulerResultConstant.getMessage(), data);
	}

	public SchedulerResult(SchedulerResultConstant schedulerResultConstant, Object data, Integer pageSize, Integer pageCurrent, Long total) {
		super(schedulerResultConstant.getCode(), schedulerResultConstant.getMessage(), data,pageSize,pageCurrent,total);
	}

}
