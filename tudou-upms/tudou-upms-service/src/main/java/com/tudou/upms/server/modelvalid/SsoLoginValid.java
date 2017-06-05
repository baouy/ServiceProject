package com.tudou.upms.server.modelvalid;

import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;

/**
 * Created by DavidWang on 2017/6/3.
 */
public class SsoLoginValid {

	@NotNull(message = "帐号不能为空！")
	@ApiParam(value = "账号",required = false)
	private String username;

	@NotNull(message = "密码不能为空！")
	@ApiParam(value = "密码",required = false)
	private String password;

	private Boolean rememberMe = false;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
}
