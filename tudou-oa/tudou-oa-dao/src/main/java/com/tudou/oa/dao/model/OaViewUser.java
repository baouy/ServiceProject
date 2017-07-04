package com.tudou.oa.dao.model;

import java.io.Serializable;

public class OaViewUser implements Serializable {
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

    private String organizationId;

    private String department;

    private String departmentId;

    /**
     * 角色名称
     *
     * @mbg.generated
     */
    private String role;

    private String roleId;

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

    /**
     * 电话
     *
     * @mbg.generated
     */
    private String phone;

    private static final long serialVersionUID = 1L;

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

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", username=").append(username);
        sb.append(", realname=").append(realname);
        sb.append(", sex=").append(sex);
        sb.append(", locked=").append(locked);
        sb.append(", ctime=").append(ctime);
        sb.append(", companyMobile=").append(companyMobile);
        sb.append(", companyEmail=").append(companyEmail);
        sb.append(", flowerName=").append(flowerName);
        sb.append(", workNum=").append(workNum);
        sb.append(", organization=").append(organization);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", department=").append(department);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", role=").append(role);
        sb.append(", roleId=").append(roleId);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", idAddress=").append(idAddress);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OaViewUser other = (OaViewUser) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getLocked() == null ? other.getLocked() == null : this.getLocked().equals(other.getLocked()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()))
            && (this.getCompanyMobile() == null ? other.getCompanyMobile() == null : this.getCompanyMobile().equals(other.getCompanyMobile()))
            && (this.getCompanyEmail() == null ? other.getCompanyEmail() == null : this.getCompanyEmail().equals(other.getCompanyEmail()))
            && (this.getFlowerName() == null ? other.getFlowerName() == null : this.getFlowerName().equals(other.getFlowerName()))
            && (this.getWorkNum() == null ? other.getWorkNum() == null : this.getWorkNum().equals(other.getWorkNum()))
            && (this.getOrganization() == null ? other.getOrganization() == null : this.getOrganization().equals(other.getOrganization()))
            && (this.getOrganizationId() == null ? other.getOrganizationId() == null : this.getOrganizationId().equals(other.getOrganizationId()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getIdNumber() == null ? other.getIdNumber() == null : this.getIdNumber().equals(other.getIdNumber()))
            && (this.getIdAddress() == null ? other.getIdAddress() == null : this.getIdAddress().equals(other.getIdAddress()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getLocked() == null) ? 0 : getLocked().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        result = prime * result + ((getCompanyMobile() == null) ? 0 : getCompanyMobile().hashCode());
        result = prime * result + ((getCompanyEmail() == null) ? 0 : getCompanyEmail().hashCode());
        result = prime * result + ((getFlowerName() == null) ? 0 : getFlowerName().hashCode());
        result = prime * result + ((getWorkNum() == null) ? 0 : getWorkNum().hashCode());
        result = prime * result + ((getOrganization() == null) ? 0 : getOrganization().hashCode());
        result = prime * result + ((getOrganizationId() == null) ? 0 : getOrganizationId().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getIdNumber() == null) ? 0 : getIdNumber().hashCode());
        result = prime * result + ((getIdAddress() == null) ? 0 : getIdAddress().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        return result;
    }
}