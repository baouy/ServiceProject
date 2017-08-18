package com.tudou.upms.common.constant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tudou.common.base.BaseResult;

/**
 * upms系统常量枚举类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpmsResult extends BaseResult {

    public UpmsResult(UpmsResultConstant upmsResultConstant, Object data) {
        super(upmsResultConstant.getCode(), upmsResultConstant.getMessage(), data);
    }

    public UpmsResult(UpmsResultConstant upmsResultConstant, Object data,Integer pageSize,Integer pageCurrent,Long total) {
        super(upmsResultConstant.getCode(), upmsResultConstant.getMessage(), data,pageSize,pageCurrent,total);
    }
}
