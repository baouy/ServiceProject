package com.tudou.upms.server.modelvalid;

import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;

/**
 * Created by DavidWang on 2017/6/15.
 */
public class SetPasswordValid {

	@NotNull(message = "密码不能为空！")
	@ApiParam(value = "密码",required = false)
	private String password;

	@NotNull(message = "密码不能为空！")
	@ApiParam(value = "密码",required = false)
	private String npassword;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNpassword() {
		return npassword;
	}

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}
}
