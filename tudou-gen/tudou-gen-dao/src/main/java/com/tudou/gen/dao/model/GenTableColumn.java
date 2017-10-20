package com.tudou.gen.dao.model;

import java.io.Serializable;
import java.util.Date;

public class GenTableColumn implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private String id;

    /**
     * 归属表编号
     *
     * @mbg.generated
     */
    private String genTableId;

    /**
     * 名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 描述
     *
     * @mbg.generated
     */
    private String comments;

    /**
     * 列的数据类型的字节长度
     *
     * @mbg.generated
     */
    private String jdbcType;

    /**
     * JAVA类型
     *
     * @mbg.generated
     */
    private String javaType;

    /**
     * JAVA字段名
     *
     * @mbg.generated
     */
    private String javaField;

    /**
     * 是否主键
     *
     * @mbg.generated
     */
    private String isPk;

    /**
     * 是否可为空
     *
     * @mbg.generated
     */
    private String isNull;

    /**
     * 是否为插入字段
     *
     * @mbg.generated
     */
    private String isInsert;

    /**
     * 是否编辑字段
     *
     * @mbg.generated
     */
    private String isEdit;

    /**
     * 是否列表字段
     *
     * @mbg.generated
     */
    private String isList;

    /**
     * 是否查询字段
     *
     * @mbg.generated
     */
    private String isQuery;

    /**
     * 查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）
     *
     * @mbg.generated
     */
    private String queryType;

    /**
     * 字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）
     *
     * @mbg.generated
     */
    private String showType;

    /**
     * 字典类型
     *
     * @mbg.generated
     */
    private String dictType;

    /**
     * 其它设置（扩展字段JSON）
     *
     * @mbg.generated
     */
    private String settings;

    /**
     * 排序（升序）
     *
     * @mbg.generated
     */
    private Long sort;

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

    public String getGenTableId() {
        return genTableId;
    }

    public void setGenTableId(String genTableId) {
        this.genTableId = genTableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJavaField() {
        return javaField;
    }

    public void setJavaField(String javaField) {
        this.javaField = javaField;
    }

    public String getIsPk() {
        return isPk;
    }

    public void setIsPk(String isPk) {
        this.isPk = isPk;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getIsInsert() {
        return isInsert;
    }

    public void setIsInsert(String isInsert) {
        this.isInsert = isInsert;
    }

    public String getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(String isEdit) {
        this.isEdit = isEdit;
    }

    public String getIsList() {
        return isList;
    }

    public void setIsList(String isList) {
        this.isList = isList;
    }

    public String getIsQuery() {
        return isQuery;
    }

    public void setIsQuery(String isQuery) {
        this.isQuery = isQuery;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
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
        sb.append(", genTableId=").append(genTableId);
        sb.append(", name=").append(name);
        sb.append(", comments=").append(comments);
        sb.append(", jdbcType=").append(jdbcType);
        sb.append(", javaType=").append(javaType);
        sb.append(", javaField=").append(javaField);
        sb.append(", isPk=").append(isPk);
        sb.append(", isNull=").append(isNull);
        sb.append(", isInsert=").append(isInsert);
        sb.append(", isEdit=").append(isEdit);
        sb.append(", isList=").append(isList);
        sb.append(", isQuery=").append(isQuery);
        sb.append(", queryType=").append(queryType);
        sb.append(", showType=").append(showType);
        sb.append(", dictType=").append(dictType);
        sb.append(", settings=").append(settings);
        sb.append(", sort=").append(sort);
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
        GenTableColumn other = (GenTableColumn) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGenTableId() == null ? other.getGenTableId() == null : this.getGenTableId().equals(other.getGenTableId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getComments() == null ? other.getComments() == null : this.getComments().equals(other.getComments()))
            && (this.getJdbcType() == null ? other.getJdbcType() == null : this.getJdbcType().equals(other.getJdbcType()))
            && (this.getJavaType() == null ? other.getJavaType() == null : this.getJavaType().equals(other.getJavaType()))
            && (this.getJavaField() == null ? other.getJavaField() == null : this.getJavaField().equals(other.getJavaField()))
            && (this.getIsPk() == null ? other.getIsPk() == null : this.getIsPk().equals(other.getIsPk()))
            && (this.getIsNull() == null ? other.getIsNull() == null : this.getIsNull().equals(other.getIsNull()))
            && (this.getIsInsert() == null ? other.getIsInsert() == null : this.getIsInsert().equals(other.getIsInsert()))
            && (this.getIsEdit() == null ? other.getIsEdit() == null : this.getIsEdit().equals(other.getIsEdit()))
            && (this.getIsList() == null ? other.getIsList() == null : this.getIsList().equals(other.getIsList()))
            && (this.getIsQuery() == null ? other.getIsQuery() == null : this.getIsQuery().equals(other.getIsQuery()))
            && (this.getQueryType() == null ? other.getQueryType() == null : this.getQueryType().equals(other.getQueryType()))
            && (this.getShowType() == null ? other.getShowType() == null : this.getShowType().equals(other.getShowType()))
            && (this.getDictType() == null ? other.getDictType() == null : this.getDictType().equals(other.getDictType()))
            && (this.getSettings() == null ? other.getSettings() == null : this.getSettings().equals(other.getSettings()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
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
        result = prime * result + ((getGenTableId() == null) ? 0 : getGenTableId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getComments() == null) ? 0 : getComments().hashCode());
        result = prime * result + ((getJdbcType() == null) ? 0 : getJdbcType().hashCode());
        result = prime * result + ((getJavaType() == null) ? 0 : getJavaType().hashCode());
        result = prime * result + ((getJavaField() == null) ? 0 : getJavaField().hashCode());
        result = prime * result + ((getIsPk() == null) ? 0 : getIsPk().hashCode());
        result = prime * result + ((getIsNull() == null) ? 0 : getIsNull().hashCode());
        result = prime * result + ((getIsInsert() == null) ? 0 : getIsInsert().hashCode());
        result = prime * result + ((getIsEdit() == null) ? 0 : getIsEdit().hashCode());
        result = prime * result + ((getIsList() == null) ? 0 : getIsList().hashCode());
        result = prime * result + ((getIsQuery() == null) ? 0 : getIsQuery().hashCode());
        result = prime * result + ((getQueryType() == null) ? 0 : getQueryType().hashCode());
        result = prime * result + ((getShowType() == null) ? 0 : getShowType().hashCode());
        result = prime * result + ((getDictType() == null) ? 0 : getDictType().hashCode());
        result = prime * result + ((getSettings() == null) ? 0 : getSettings().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }
}