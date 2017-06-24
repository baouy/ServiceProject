package com.tudou.oa.dao.model;

import java.io.Serializable;

public class OaUserDetails implements Serializable {
    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 工号
     *
     * @mbg.generated
     */
    private String workNum;

    /**
     * 花名
     *
     * @mbg.generated
     */
    private String flowerName;

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
     * 招聘渠道枚举
     *
     * @mbg.generated
     */
    private Integer recruitmentEnumId;

    /**
     * 招聘其他
     *
     * @mbg.generated
     */
    private String recruitmentEnumOther;

    /**
     * 推荐人ID
     *
     * @mbg.generated
     */
    private Integer rUserId;

    /**
     * 入职时间
     *
     * @mbg.generated
     */
    private Long itime;

    /**
     * 试用期
     *
     * @mbg.generated
     */
    private Integer probation;

    /**
     * 转正时间
     *
     * @mbg.generated
     */
    private Long ptime;

    /**
     * 合同年限
     *
     * @mbg.generated
     */
    private Integer contractage;

    /**
     * 合同类型枚举
     *
     * @mbg.generated
     */
    private Integer contracttypeEnumId;

    /**
     * 合同签订次数
     *
     * @mbg.generated
     */
    private Integer contracttimes;

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
     * 户籍类型枚举
     *
     * @mbg.generated
     */
    private Integer hrEnumId;

    /**
     * 工资卡号
     *
     * @mbg.generated
     */
    private String cardnumber;

    /**
     * 开户银行编码
     *
     * @mbg.generated
     */
    private Integer bankEnumId;

    /**
     * 婚否
     *
     * @mbg.generated
     */
    private Boolean ismarry;

    /**
     * 育否
     *
     * @mbg.generated
     */
    private Boolean fertility;

    /**
     * 名族
     *
     * @mbg.generated
     */
    private String nation;

    /**
     * 籍贯
     *
     * @mbg.generated
     */
    private String nativeplace;

    /**
     * QQ号
     *
     * @mbg.generated
     */
    private String qq;

    /**
     * 微信
     *
     * @mbg.generated
     */
    private String wx;

    /**
     * 学历枚举
     *
     * @mbg.generated
     */
    private Integer eEnumId;

    /**
     * 学校
     *
     * @mbg.generated
     */
    private String school;

    /**
     * 专业
     *
     * @mbg.generated
     */
    private String professional;

    /**
     * 紧急联系人
     *
     * @mbg.generated
     */
    private String emerContact;

    /**
     * 紧急联系人电话
     *
     * @mbg.generated
     */
    private String emerMobile;

    /**
     * 离职时间
     *
     * @mbg.generated
     */
    private Long leavetime;

    /**
     * 离职原因
     *
     * @mbg.generated
     */
    private String leavingreason;

    /**
     * 社保开始时间
     *
     * @mbg.generated
     */
    private Long securitystart;

    /**
     * 社保结束时间
     *
     * @mbg.generated
     */
    private Long securityendtime;

    /**
     * 公积金结束时间
     *
     * @mbg.generated
     */
    private Long fundtime;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
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

    public Integer getRecruitmentEnumId() {
        return recruitmentEnumId;
    }

    public void setRecruitmentEnumId(Integer recruitmentEnumId) {
        this.recruitmentEnumId = recruitmentEnumId;
    }

    public String getRecruitmentEnumOther() {
        return recruitmentEnumOther;
    }

    public void setRecruitmentEnumOther(String recruitmentEnumOther) {
        this.recruitmentEnumOther = recruitmentEnumOther;
    }

    public Integer getrUserId() {
        return rUserId;
    }

    public void setrUserId(Integer rUserId) {
        this.rUserId = rUserId;
    }

    public Long getItime() {
        return itime;
    }

    public void setItime(Long itime) {
        this.itime = itime;
    }

    public Integer getProbation() {
        return probation;
    }

    public void setProbation(Integer probation) {
        this.probation = probation;
    }

    public Long getPtime() {
        return ptime;
    }

    public void setPtime(Long ptime) {
        this.ptime = ptime;
    }

    public Integer getContractage() {
        return contractage;
    }

    public void setContractage(Integer contractage) {
        this.contractage = contractage;
    }

    public Integer getContracttypeEnumId() {
        return contracttypeEnumId;
    }

    public void setContracttypeEnumId(Integer contracttypeEnumId) {
        this.contracttypeEnumId = contracttypeEnumId;
    }

    public Integer getContracttimes() {
        return contracttimes;
    }

    public void setContracttimes(Integer contracttimes) {
        this.contracttimes = contracttimes;
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

    public Integer getHrEnumId() {
        return hrEnumId;
    }

    public void setHrEnumId(Integer hrEnumId) {
        this.hrEnumId = hrEnumId;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public Integer getBankEnumId() {
        return bankEnumId;
    }

    public void setBankEnumId(Integer bankEnumId) {
        this.bankEnumId = bankEnumId;
    }

    public Boolean getIsmarry() {
        return ismarry;
    }

    public void setIsmarry(Boolean ismarry) {
        this.ismarry = ismarry;
    }

    public Boolean getFertility() {
        return fertility;
    }

    public void setFertility(Boolean fertility) {
        this.fertility = fertility;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public Integer geteEnumId() {
        return eEnumId;
    }

    public void seteEnumId(Integer eEnumId) {
        this.eEnumId = eEnumId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getEmerContact() {
        return emerContact;
    }

    public void setEmerContact(String emerContact) {
        this.emerContact = emerContact;
    }

    public String getEmerMobile() {
        return emerMobile;
    }

    public void setEmerMobile(String emerMobile) {
        this.emerMobile = emerMobile;
    }

    public Long getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Long leavetime) {
        this.leavetime = leavetime;
    }

    public String getLeavingreason() {
        return leavingreason;
    }

    public void setLeavingreason(String leavingreason) {
        this.leavingreason = leavingreason;
    }

    public Long getSecuritystart() {
        return securitystart;
    }

    public void setSecuritystart(Long securitystart) {
        this.securitystart = securitystart;
    }

    public Long getSecurityendtime() {
        return securityendtime;
    }

    public void setSecurityendtime(Long securityendtime) {
        this.securityendtime = securityendtime;
    }

    public Long getFundtime() {
        return fundtime;
    }

    public void setFundtime(Long fundtime) {
        this.fundtime = fundtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", workNum=").append(workNum);
        sb.append(", flowerName=").append(flowerName);
        sb.append(", companyMobile=").append(companyMobile);
        sb.append(", companyEmail=").append(companyEmail);
        sb.append(", recruitmentEnumId=").append(recruitmentEnumId);
        sb.append(", recruitmentEnumOther=").append(recruitmentEnumOther);
        sb.append(", rUserId=").append(rUserId);
        sb.append(", itime=").append(itime);
        sb.append(", probation=").append(probation);
        sb.append(", ptime=").append(ptime);
        sb.append(", contractage=").append(contractage);
        sb.append(", contracttypeEnumId=").append(contracttypeEnumId);
        sb.append(", contracttimes=").append(contracttimes);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", idAddress=").append(idAddress);
        sb.append(", hrEnumId=").append(hrEnumId);
        sb.append(", cardnumber=").append(cardnumber);
        sb.append(", bankEnumId=").append(bankEnumId);
        sb.append(", ismarry=").append(ismarry);
        sb.append(", fertility=").append(fertility);
        sb.append(", nation=").append(nation);
        sb.append(", nativeplace=").append(nativeplace);
        sb.append(", qq=").append(qq);
        sb.append(", wx=").append(wx);
        sb.append(", eEnumId=").append(eEnumId);
        sb.append(", school=").append(school);
        sb.append(", professional=").append(professional);
        sb.append(", emerContact=").append(emerContact);
        sb.append(", emerMobile=").append(emerMobile);
        sb.append(", leavetime=").append(leavetime);
        sb.append(", leavingreason=").append(leavingreason);
        sb.append(", securitystart=").append(securitystart);
        sb.append(", securityendtime=").append(securityendtime);
        sb.append(", fundtime=").append(fundtime);
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
        OaUserDetails other = (OaUserDetails) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getWorkNum() == null ? other.getWorkNum() == null : this.getWorkNum().equals(other.getWorkNum()))
            && (this.getFlowerName() == null ? other.getFlowerName() == null : this.getFlowerName().equals(other.getFlowerName()))
            && (this.getCompanyMobile() == null ? other.getCompanyMobile() == null : this.getCompanyMobile().equals(other.getCompanyMobile()))
            && (this.getCompanyEmail() == null ? other.getCompanyEmail() == null : this.getCompanyEmail().equals(other.getCompanyEmail()))
            && (this.getRecruitmentEnumId() == null ? other.getRecruitmentEnumId() == null : this.getRecruitmentEnumId().equals(other.getRecruitmentEnumId()))
            && (this.getRecruitmentEnumOther() == null ? other.getRecruitmentEnumOther() == null : this.getRecruitmentEnumOther().equals(other.getRecruitmentEnumOther()))
            && (this.getrUserId() == null ? other.getrUserId() == null : this.getrUserId().equals(other.getrUserId()))
            && (this.getItime() == null ? other.getItime() == null : this.getItime().equals(other.getItime()))
            && (this.getProbation() == null ? other.getProbation() == null : this.getProbation().equals(other.getProbation()))
            && (this.getPtime() == null ? other.getPtime() == null : this.getPtime().equals(other.getPtime()))
            && (this.getContractage() == null ? other.getContractage() == null : this.getContractage().equals(other.getContractage()))
            && (this.getContracttypeEnumId() == null ? other.getContracttypeEnumId() == null : this.getContracttypeEnumId().equals(other.getContracttypeEnumId()))
            && (this.getContracttimes() == null ? other.getContracttimes() == null : this.getContracttimes().equals(other.getContracttimes()))
            && (this.getIdNumber() == null ? other.getIdNumber() == null : this.getIdNumber().equals(other.getIdNumber()))
            && (this.getIdAddress() == null ? other.getIdAddress() == null : this.getIdAddress().equals(other.getIdAddress()))
            && (this.getHrEnumId() == null ? other.getHrEnumId() == null : this.getHrEnumId().equals(other.getHrEnumId()))
            && (this.getCardnumber() == null ? other.getCardnumber() == null : this.getCardnumber().equals(other.getCardnumber()))
            && (this.getBankEnumId() == null ? other.getBankEnumId() == null : this.getBankEnumId().equals(other.getBankEnumId()))
            && (this.getIsmarry() == null ? other.getIsmarry() == null : this.getIsmarry().equals(other.getIsmarry()))
            && (this.getFertility() == null ? other.getFertility() == null : this.getFertility().equals(other.getFertility()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getNativeplace() == null ? other.getNativeplace() == null : this.getNativeplace().equals(other.getNativeplace()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getWx() == null ? other.getWx() == null : this.getWx().equals(other.getWx()))
            && (this.geteEnumId() == null ? other.geteEnumId() == null : this.geteEnumId().equals(other.geteEnumId()))
            && (this.getSchool() == null ? other.getSchool() == null : this.getSchool().equals(other.getSchool()))
            && (this.getProfessional() == null ? other.getProfessional() == null : this.getProfessional().equals(other.getProfessional()))
            && (this.getEmerContact() == null ? other.getEmerContact() == null : this.getEmerContact().equals(other.getEmerContact()))
            && (this.getEmerMobile() == null ? other.getEmerMobile() == null : this.getEmerMobile().equals(other.getEmerMobile()))
            && (this.getLeavetime() == null ? other.getLeavetime() == null : this.getLeavetime().equals(other.getLeavetime()))
            && (this.getLeavingreason() == null ? other.getLeavingreason() == null : this.getLeavingreason().equals(other.getLeavingreason()))
            && (this.getSecuritystart() == null ? other.getSecuritystart() == null : this.getSecuritystart().equals(other.getSecuritystart()))
            && (this.getSecurityendtime() == null ? other.getSecurityendtime() == null : this.getSecurityendtime().equals(other.getSecurityendtime()))
            && (this.getFundtime() == null ? other.getFundtime() == null : this.getFundtime().equals(other.getFundtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getWorkNum() == null) ? 0 : getWorkNum().hashCode());
        result = prime * result + ((getFlowerName() == null) ? 0 : getFlowerName().hashCode());
        result = prime * result + ((getCompanyMobile() == null) ? 0 : getCompanyMobile().hashCode());
        result = prime * result + ((getCompanyEmail() == null) ? 0 : getCompanyEmail().hashCode());
        result = prime * result + ((getRecruitmentEnumId() == null) ? 0 : getRecruitmentEnumId().hashCode());
        result = prime * result + ((getRecruitmentEnumOther() == null) ? 0 : getRecruitmentEnumOther().hashCode());
        result = prime * result + ((getrUserId() == null) ? 0 : getrUserId().hashCode());
        result = prime * result + ((getItime() == null) ? 0 : getItime().hashCode());
        result = prime * result + ((getProbation() == null) ? 0 : getProbation().hashCode());
        result = prime * result + ((getPtime() == null) ? 0 : getPtime().hashCode());
        result = prime * result + ((getContractage() == null) ? 0 : getContractage().hashCode());
        result = prime * result + ((getContracttypeEnumId() == null) ? 0 : getContracttypeEnumId().hashCode());
        result = prime * result + ((getContracttimes() == null) ? 0 : getContracttimes().hashCode());
        result = prime * result + ((getIdNumber() == null) ? 0 : getIdNumber().hashCode());
        result = prime * result + ((getIdAddress() == null) ? 0 : getIdAddress().hashCode());
        result = prime * result + ((getHrEnumId() == null) ? 0 : getHrEnumId().hashCode());
        result = prime * result + ((getCardnumber() == null) ? 0 : getCardnumber().hashCode());
        result = prime * result + ((getBankEnumId() == null) ? 0 : getBankEnumId().hashCode());
        result = prime * result + ((getIsmarry() == null) ? 0 : getIsmarry().hashCode());
        result = prime * result + ((getFertility() == null) ? 0 : getFertility().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getNativeplace() == null) ? 0 : getNativeplace().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getWx() == null) ? 0 : getWx().hashCode());
        result = prime * result + ((geteEnumId() == null) ? 0 : geteEnumId().hashCode());
        result = prime * result + ((getSchool() == null) ? 0 : getSchool().hashCode());
        result = prime * result + ((getProfessional() == null) ? 0 : getProfessional().hashCode());
        result = prime * result + ((getEmerContact() == null) ? 0 : getEmerContact().hashCode());
        result = prime * result + ((getEmerMobile() == null) ? 0 : getEmerMobile().hashCode());
        result = prime * result + ((getLeavetime() == null) ? 0 : getLeavetime().hashCode());
        result = prime * result + ((getLeavingreason() == null) ? 0 : getLeavingreason().hashCode());
        result = prime * result + ((getSecuritystart() == null) ? 0 : getSecuritystart().hashCode());
        result = prime * result + ((getSecurityendtime() == null) ? 0 : getSecurityendtime().hashCode());
        result = prime * result + ((getFundtime() == null) ? 0 : getFundtime().hashCode());
        return result;
    }
}