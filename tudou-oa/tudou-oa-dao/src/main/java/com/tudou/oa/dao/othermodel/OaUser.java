package com.tudou.oa.dao.othermodel;

import com.tudou.oa.dao.model.OaUserDetails;

/**
 * Created by DavidWang on 2017/6/24.
 */
public class OaUser {


	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 用户账号
	 */
	private String username;

	/**
	 * 用户姓名
	 */
	private String realname;

	/**
	 * 性别
	 *
	 * @mbg.generated
	 */
	private Byte sex;

	/**
	 * 状态(0:正常,1:锁定,2:待入职)
	 *
	 * @mbg.generated
	 */
	private Byte locked;

	/**
	 * 创建时间
	 */
	private Long ctime;

	/**
	 * 公司电话
	 */
	private String companyMobile;

	/**
	 * 公司邮箱
	 */
	private String companyEmail;

	/**
	 * 花名
	 */
	private String flowerName;

	/**
	 * 工号
	 */
	private String workNum;

	/**
	 * 组织
	 */
	private String organization;

	/**
	 * 部门
	 */
	private String department;

	/**
	 * 角色
	 */
	private String role;

	/**
	 * 身份证
	 */
	private String idNumber;

	/**
	 * 身份证地址
	 */
	private String idAddress;

	/**
	 * 邮箱
	 */
	private String email;


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

	public Long getCtime() {
		return ctime;
	}

	public void setCtime(Long ctime) {
		this.ctime = ctime;
	}

	public String getCompanyMobile() {
		return companyMobile;
	}

	public void setCompanyMobile(String companyMobile) {
		this.companyMobile = companyMobile;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public String getWorkNum() {
		return workNum;
	}

	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(String idAddress) {
		this.idAddress = idAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
