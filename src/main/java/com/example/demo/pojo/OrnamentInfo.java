package com.example.demo.pojo;

import java.io.Serializable;

/**
 * ornament_info
 * @author 
 */
public class OrnamentInfo implements Serializable {
    private Integer ornamentId;

    private String ornamentName;

    private String ornamentPrice;

    private String ornamentClass;

    private String ornamentImage;

    private String ornamentStatus;

    private String ornamentCount;

    private String ornamentDetail;

    private static final long serialVersionUID = 1L;

    public Integer getOrnamentId() {
        return ornamentId;
    }

    public void setOrnamentId(Integer ornamentId) {
        this.ornamentId = ornamentId;
    }

    public String getOrnamentName() {
        return ornamentName;
    }

    public void setOrnamentName(String ornamentName) {
        this.ornamentName = ornamentName;
    }

    public String getOrnamentPrice() {
        return ornamentPrice;
    }

    public void setOrnamentPrice(String ornamentPrice) {
        this.ornamentPrice = ornamentPrice;
    }

    public String getOrnamentClass() {
        return ornamentClass;
    }

    public void setOrnamentClass(String ornamentClass) {
        this.ornamentClass = ornamentClass;
    }

    public String getOrnamentImage() {
        return ornamentImage;
    }

    public void setOrnamentImage(String ornamentImage) {
        this.ornamentImage = ornamentImage;
    }

    public String getOrnamentStatus() {
        return ornamentStatus;
    }

    public void setOrnamentStatus(String ornamentStatus) {
        this.ornamentStatus = ornamentStatus;
    }

    public String getOrnamentCount() {
        return ornamentCount;
    }

    public void setOrnamentCount(String ornamentCount) {
        this.ornamentCount = ornamentCount;
    }

    public String getOrnamentDetail() {
        return ornamentDetail;
    }

    public void setOrnamentDetail(String ornamentDetail) {
        this.ornamentDetail = ornamentDetail;
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
        OrnamentInfo other = (OrnamentInfo) that;
        return (this.getOrnamentId() == null ? other.getOrnamentId() == null : this.getOrnamentId().equals(other.getOrnamentId()))
            && (this.getOrnamentName() == null ? other.getOrnamentName() == null : this.getOrnamentName().equals(other.getOrnamentName()))
            && (this.getOrnamentPrice() == null ? other.getOrnamentPrice() == null : this.getOrnamentPrice().equals(other.getOrnamentPrice()))
            && (this.getOrnamentClass() == null ? other.getOrnamentClass() == null : this.getOrnamentClass().equals(other.getOrnamentClass()))
            && (this.getOrnamentImage() == null ? other.getOrnamentImage() == null : this.getOrnamentImage().equals(other.getOrnamentImage()))
            && (this.getOrnamentStatus() == null ? other.getOrnamentStatus() == null : this.getOrnamentStatus().equals(other.getOrnamentStatus()))
            && (this.getOrnamentCount() == null ? other.getOrnamentCount() == null : this.getOrnamentCount().equals(other.getOrnamentCount()))
            && (this.getOrnamentDetail() == null ? other.getOrnamentDetail() == null : this.getOrnamentDetail().equals(other.getOrnamentDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrnamentId() == null) ? 0 : getOrnamentId().hashCode());
        result = prime * result + ((getOrnamentName() == null) ? 0 : getOrnamentName().hashCode());
        result = prime * result + ((getOrnamentPrice() == null) ? 0 : getOrnamentPrice().hashCode());
        result = prime * result + ((getOrnamentClass() == null) ? 0 : getOrnamentClass().hashCode());
        result = prime * result + ((getOrnamentImage() == null) ? 0 : getOrnamentImage().hashCode());
        result = prime * result + ((getOrnamentStatus() == null) ? 0 : getOrnamentStatus().hashCode());
        result = prime * result + ((getOrnamentCount() == null) ? 0 : getOrnamentCount().hashCode());
        result = prime * result + ((getOrnamentDetail() == null) ? 0 : getOrnamentDetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ornamentId=").append(ornamentId);
        sb.append(", ornamentName=").append(ornamentName);
        sb.append(", ornamentPrice=").append(ornamentPrice);
        sb.append(", ornamentClass=").append(ornamentClass);
        sb.append(", ornamentImage=").append(ornamentImage);
        sb.append(", ornamentStatus=").append(ornamentStatus);
        sb.append(", ornamentCount=").append(ornamentCount);
        sb.append(", ornamentDetail=").append(ornamentDetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}