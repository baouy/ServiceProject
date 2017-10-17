package com.tudou.oa.service.modelvalid;

import com.tudou.common.base.BaseModelValid;

/**
 * Created by DavidWang on 2017/6/26.
 */
public class OaViewUserValid extends BaseModelValid{

	/**
	 * 编号
	 *
	 * @mbg.generated
	 */
	private Integer userId;

	/**
	 * 帐号
	 *
	 * @mbg.generated
	 */
	private String username;

	/**
	 * 姓名
	 *
	 * @mbg.generated
	 */
	private String realname;

	/**
	 * 性别
	 *
	 * @mbg.generated
	 */
	private Byte sex;

	/**
	 * 状态(0:正常,1:锁定)
	 *
	 * @mbg.generated
	 */
	private Byte locked;

	/**
	 * 创建时间
	 *
	 * @mbg.generated
	 */
	private Long ctime;

	/**
	 * 公司电话
	 *
	 * @mbg.generated
	 */
	private String companyMobile;

	/**
	 * 公司邮箱
	 *
	 * @mbg.generated
	 */
	private String companyEmail;

	/**
	 * 花名
	 *
	 * @mbg.generated
	 */
	private String flowerName;

	/**
	 * 工号
	 *
	 * @mbg.generated
	 */
	private String workNum;

	private String organization;

	/**
	 * 组织名称
	 *
	 * @mbg.generated
	 */
	private String department;

	/**
	 * 角色名称
	 *
	 * @mbg.generated
	 */
	private String role;

	/**
	 * 身份证号
	 *
	 * @mbg.generated
	 */
	private String idNumber;

	/**
	 * 身份证地址
	 *
	 * @mbg.generated
	 */
	private String idAddress;

	/**
	 * 邮箱
	 *
	 * @mbg.generated
	 */
	private String email;

	private String roleId;

	/**
	 * 电话
	 *
	 * @mbg.generated
	 */
	private String phone;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
