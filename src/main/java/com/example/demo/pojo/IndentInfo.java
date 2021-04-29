package com.example.demo.pojo;

import java.io.Serializable;

/**
 * indent_info
 * @author 
 */
public class IndentInfo implements Serializable {
    private Integer indentId;

    private String indentCreattime;

    private Integer indentOrnamentId;

    private Integer indentUser1Id;

    private Integer indentUser2Id;

    private String indentDetail;

    private static final long serialVersionUID = 1L;

    public Integer getIndentId() {
        return indentId;
    }

    public void setIndentId(Integer indentId) {
        this.indentId = indentId;
    }

    public String getIndentCreattime() {
        return indentCreattime;
    }

    public void setIndentCreattime(String indentCreattime) {
        this.indentCreattime = indentCreattime;
    }

    public Integer getIndentOrnamentId() {
        return indentOrnamentId;
    }

    public void setIndentOrnamentId(Integer indentOrnamentId) {
        this.indentOrnamentId = indentOrnamentId;
    }

    public Integer getIndentUser1Id() {
        return indentUser1Id;
    }

    public void setIndentUser1Id(Integer indentUser1Id) {
        this.indentUser1Id = indentUser1Id;
    }

    public Integer getIndentUser2Id() {
        return indentUser2Id;
    }

    public void setIndentUser2Id(Integer indentUser2Id) {
        this.indentUser2Id = indentUser2Id;
    }

    public String getIndentDetail() {
        return indentDetail;
    }

    public void setIndentDetail(String indentDetail) {
        this.indentDetail = indentDetail;
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
        IndentInfo other = (IndentInfo) that;
        return (this.getIndentId() == null ? other.getIndentId() == null : this.getIndentId().equals(other.getIndentId()))
            && (this.getIndentCreattime() == null ? other.getIndentCreattime() == null : this.getIndentCreattime().equals(other.getIndentCreattime()))
            && (this.getIndentOrnamentId() == null ? other.getIndentOrnamentId() == null : this.getIndentOrnamentId().equals(other.getIndentOrnamentId()))
            && (this.getIndentUser1Id() == null ? other.getIndentUser1Id() == null : this.getIndentUser1Id().equals(other.getIndentUser1Id()))
            && (this.getIndentUser2Id() == null ? other.getIndentUser2Id() == null : this.getIndentUser2Id().equals(other.getIndentUser2Id()))
            && (this.getIndentDetail() == null ? other.getIndentDetail() == null : this.getIndentDetail().equals(other.getIndentDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIndentId() == null) ? 0 : getIndentId().hashCode());
        result = prime * result + ((getIndentCreattime() == null) ? 0 : getIndentCreattime().hashCode());
        result = prime * result + ((getIndentOrnamentId() == null) ? 0 : getIndentOrnamentId().hashCode());
        result = prime * result + ((getIndentUser1Id() == null) ? 0 : getIndentUser1Id().hashCode());
        result = prime * result + ((getIndentUser2Id() == null) ? 0 : getIndentUser2Id().hashCode());
        result = prime * result + ((getIndentDetail() == null) ? 0 : getIndentDetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", indentId=").append(indentId);
        sb.append(", indentCreattime=").append(indentCreattime);
        sb.append(", indentOrnamentId=").append(indentOrnamentId);
        sb.append(", indentUser1Id=").append(indentUser1Id);
        sb.append(", indentUser2Id=").append(indentUser2Id);
        sb.append(", indentDetail=").append(indentDetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}