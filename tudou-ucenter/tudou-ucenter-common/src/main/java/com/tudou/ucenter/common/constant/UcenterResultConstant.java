package com.tudou.ucenter.common.constant;

/**
 * Created by DavidWang on 2017/6/15.
 */
public enum UcenterResultConstant {

	FAILED(0, "failed"),
	SUCCESS(1, "success"),

	PERMISSIONS_403(403,"Permissions 403"),
	SERVICE_ERROR(500,"Service Exception"),
	VERIFY_FAILURE(10000,"Verify failure"),

	INVALID_LENGTH(10001, "Invalid length"),

	EMPTY_USERNAME(10101, "Username cannot be empty"),
	EMPTY_PASSWORD(10102, "Password cannot be empty"),
	INVALID_USERNAME(10103, "Account does not exist"),
	INVALID_PASSWORD(10104, "Password error"),
	INVALID_ACCOUNT(10105, "Invalid account");

	public int code;

	public String message;

	UcenterResultConstant(int code, String message) {
		this.code = code;
		this.message = message;
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
}
