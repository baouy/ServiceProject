package com.tudou.common.base;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 统一返回结果类
 */
public class BaseResult {

    // 状态码：1成功，其他为失败
    public int code;

    // 成功为success，其他为失败原因
    public String message;

    // 数据结果集
    public Object data;

    private Integer pageSize;

    private Integer pageCurrent;

    private Integer total;

    public BaseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResult(int code, String message, Object data,Integer pageSize,Integer pageCurrent,Integer total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.pageSize = pageSize;
        this.pageCurrent = pageCurrent;
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
