package com.tudou.gen.dao.model;

import com.tudou.common.base.BaseModelValid;

import java.io.Serializable;
import java.util.Date;

public class GenScheme extends BaseModelValid implements Serializable{
    /**
     * 编号
     *
     * @mbg.generated
     */
    private String id;

    /**
     * 名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 分类
     *
     * @mbg.generated
     */
    private String category;

    /**
     * 生成包路径
     *
     * @mbg.generated
     */
    private String packageName;

    /**
     * 生成模块名
     *
     * @mbg.generated
     */
    private String moduleName;

    /**
     * 文件类型
     */
    private String fileType;


    /**
     * 生成子模块名
     *
     * @mbg.generated
     */
    private String subModuleName;

    /**
     * 生成功能名
     *
     * @mbg.generated
     */
    private String functionName;

    /**
     * 生成功能名（简写）
     *
     * @mbg.generated
     */
    private String functionNameSimple;

    /**
     * 生成功能作者
     *
     * @mbg.generated
     */
    private String functionAuthor;

    /**
     * 生成表编号
     *
     * @mbg.generated
     */
    private String genTableId;

    /**
     * 创建者
     *
     * @mbg.generated
     */
    private String createBy;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     * 更新者
     *
     * @mbg.generated
     */
    private String updateBy;

    /**
     * 更新时间
     *
     * @mbg.generated
     */
    private Date updateDate;

    /**
     * 备注信息
     *
     * @mbg.generated
     */
    private String remarks;

    /**
     * 删除标记（0：正常；1：删除）
     *
     * @mbg.generated
     */
    private String delFlag;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getSubModuleName() {
        return subModuleName;
    }

    public void setSubModuleName(String subModuleName) {
        this.subModuleName = subModuleName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionNameSimple() {
        return functionNameSimple;
    }

    public void setFunctionNameSimple(String functionNameSimple) {
        this.functionNameSimple = functionNameSimple;
    }

    public String getFunctionAuthor() {
        return functionAuthor;
    }

    public void setFunctionAuthor(String functionAuthor) {
        this.functionAuthor = functionAuthor;
    }

    public String getGenTableId() {
        return genTableId;
    }

    public void setGenTableId(String genTableId) {
        this.genTableId = genTableId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", category=").append(category);
        sb.append(", packageName=").append(packageName);
        sb.append(", moduleName=").append(moduleName);
        sb.append(", subModuleName=").append(subModuleName);
        sb.append(", functionName=").append(functionName);
        sb.append(", functionNameSimple=").append(functionNameSimple);
        sb.append(", functionAuthor=").append(functionAuthor);
        sb.append(", genTableId=").append(genTableId);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
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
        GenScheme other = (GenScheme) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getPackageName() == null ? other.getPackageName() == null : this.getPackageName().equals(other.getPackageName()))
            && (this.getModuleName() == null ? other.getModuleName() == null : this.getModuleName().equals(other.getModuleName()))
            && (this.getSubModuleName() == null ? other.getSubModuleName() == null : this.getSubModuleName().equals(other.getSubModuleName()))
            && (this.getFunctionName() == null ? other.getFunctionName() == null : this.getFunctionName().equals(other.getFunctionName()))
            && (this.getFunctionNameSimple() == null ? other.getFunctionNameSimple() == null : this.getFunctionNameSimple().equals(other.getFunctionNameSimple()))
            && (this.getFunctionAuthor() == null ? other.getFunctionAuthor() == null : this.getFunctionAuthor().equals(other.getFunctionAuthor()))
            && (this.getGenTableId() == null ? other.getGenTableId() == null : this.getGenTableId().equals(other.getGenTableId()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getPackageName() == null) ? 0 : getPackageName().hashCode());
        result = prime * result + ((getModuleName() == null) ? 0 : getModuleName().hashCode());
        result = prime * result + ((getSubModuleName() == null) ? 0 : getSubModuleName().hashCode());
        result = prime * result + ((getFunctionName() == null) ? 0 : getFunctionName().hashCode());
        result = prime * result + ((getFunctionNameSimple() == null) ? 0 : getFunctionNameSimple().hashCode());
        result = prime * result + ((getFunctionAuthor() == null) ? 0 : getFunctionAuthor().hashCode());
        result = prime * result + ((getGenTableId() == null) ? 0 : getGenTableId().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }
}