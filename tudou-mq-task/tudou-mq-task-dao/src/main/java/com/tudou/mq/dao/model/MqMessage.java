package com.tudou.mq.dao.model;

import java.io.Serializable;

public class MqMessage implements Serializable {
    private Integer messageId;

    private String messageName;

    private String messageContent;

    private Byte status;

    private Long ctime;

    private static final long serialVersionUID = 1L;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageId=").append(messageId);
        sb.append(", messageName=").append(messageName);
        sb.append(", messageContent=").append(messageContent);
        sb.append(", status=").append(status);
        sb.append(", ctime=").append(ctime);
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
        MqMessage other = (MqMessage) that;
        return (this.getMessageId() == null ? other.getMessageId() == null : this.getMessageId().equals(other.getMessageId()))
            && (this.getMessageName() == null ? other.getMessageName() == null : this.getMessageName().equals(other.getMessageName()))
            && (this.getMessageContent() == null ? other.getMessageContent() == null : this.getMessageContent().equals(other.getMessageContent()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCtime() == null ? other.getCtime() == null : this.getCtime().equals(other.getCtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMessageId() == null) ? 0 : getMessageId().hashCode());
        result = prime * result + ((getMessageName() == null) ? 0 : getMessageName().hashCode());
        result = prime * result + ((getMessageContent() == null) ? 0 : getMessageContent().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCtime() == null) ? 0 : getCtime().hashCode());
        return result;
    }
}