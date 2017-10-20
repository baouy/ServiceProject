package com.tudou.upms.dao.model;

import java.io.Serializable;

public class UpmsMarkdown implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Integer mId;

    /**
     * 关键词
     *
     * @mbg.generated
     */
    private String keywords;

    /**
     * 标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Integer createTime;

    /**
     * 更新时间
     *
     * @mbg.generated
     */
    private Integer updateTime;

    /**
     * 状态0为删除
     *
     * @mbg.generated
     */
    private Integer statue;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 版本
     *
     * @mbg.generated
     */
    private Integer version;

    /**
     * 内容
     *
     * @mbg.generated
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mId=").append(mId);
        sb.append(", keywords=").append(keywords);
        sb.append(", title=").append(title);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", statue=").append(statue);
        sb.append(", userId=").append(userId);
        sb.append(", version=").append(version);
        sb.append(", content=").append(content);
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
        UpmsMarkdown other = (UpmsMarkdown) that;
        return (this.getmId() == null ? other.getmId() == null : this.getmId().equals(other.getmId()))
            && (this.getKeywords() == null ? other.getKeywords() == null : this.getKeywords().equals(other.getKeywords()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getStatue() == null ? other.getStatue() == null : this.getStatue().equals(other.getStatue()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getmId() == null) ? 0 : getmId().hashCode());
        result = prime * result + ((getKeywords() == null) ? 0 : getKeywords().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatue() == null) ? 0 : getStatue().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}