package com.tudou.upms.server.modelvalid;

import com.tudou.common.base.BaseModelValid;
import io.swagger.annotations.ApiParam;

/**
 * Created by DavidWang on 2017/6/7.
 */
public class UserValid extends BaseModelValid{

	/**
	 * 编号
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "编号",required = false)
	private Integer userId;

	/**
	 * 帐号
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "账号",required = false)
	private String username;

	/**
	 * 姓名
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "姓名",required = false)
	private String realname;

	/**
	 * 头像
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "头像",required = false)
	private String avatar;

	/**
	 * 电话
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "电话",required = false)
	private String phone;

	/**
	 * 邮箱
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "邮箱",required = false)
	private String email;

	/**
	 * 性别
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "性别",required = false)
	private Byte sex;

	/**
	 * 状态(0:正常,1:锁定)
	 *
	 * @mbg.generated
	 */
	@ApiParam(value = "状态",required = false)
	private Byte locked;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Byte getLocked() {
		return locked;
	}

	public void setLocked(Byte locked) {
		this.locked = locked;
	}
}
