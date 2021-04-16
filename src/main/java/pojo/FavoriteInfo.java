package pojo;

import java.io.Serializable;

/**
 * favorite_info
 * @author 
 */
public class FavoriteInfo implements Serializable {
    private Integer favoriteId;

    private Integer favoriteOrnamentId;

    private Integer favoriteUserId;

    private Integer favoriteClassId;

    /**
     * 备注
     */
    private String favoriteDetail;

    private static final long serialVersionUID = 1L;

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Integer getFavoriteOrnamentId() {
        return favoriteOrnamentId;
    }

    public void setFavoriteOrnamentId(Integer favoriteOrnamentId) {
        this.favoriteOrnamentId = favoriteOrnamentId;
    }

    public Integer getFavoriteUserId() {
        return favoriteUserId;
    }

    public void setFavoriteUserId(Integer favoriteUserId) {
        this.favoriteUserId = favoriteUserId;
    }

    public Integer getFavoriteClassId() {
        return favoriteClassId;
    }

    public void setFavoriteClassId(Integer favoriteClassId) {
        this.favoriteClassId = favoriteClassId;
    }

    public String getFavoriteDetail() {
        return favoriteDetail;
    }

    public void setFavoriteDetail(String favoriteDetail) {
        this.favoriteDetail = favoriteDetail;
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
        FavoriteInfo other = (FavoriteInfo) that;
        return (this.getFavoriteId() == null ? other.getFavoriteId() == null : this.getFavoriteId().equals(other.getFavoriteId()))
            && (this.getFavoriteOrnamentId() == null ? other.getFavoriteOrnamentId() == null : this.getFavoriteOrnamentId().equals(other.getFavoriteOrnamentId()))
            && (this.getFavoriteUserId() == null ? other.getFavoriteUserId() == null : this.getFavoriteUserId().equals(other.getFavoriteUserId()))
            && (this.getFavoriteClassId() == null ? other.getFavoriteClassId() == null : this.getFavoriteClassId().equals(other.getFavoriteClassId()))
            && (this.getFavoriteDetail() == null ? other.getFavoriteDetail() == null : this.getFavoriteDetail().equals(other.getFavoriteDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFavoriteId() == null) ? 0 : getFavoriteId().hashCode());
        result = prime * result + ((getFavoriteOrnamentId() == null) ? 0 : getFavoriteOrnamentId().hashCode());
        result = prime * result + ((getFavoriteUserId() == null) ? 0 : getFavoriteUserId().hashCode());
        result = prime * result + ((getFavoriteClassId() == null) ? 0 : getFavoriteClassId().hashCode());
        result = prime * result + ((getFavoriteDetail() == null) ? 0 : getFavoriteDetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", favoriteId=").append(favoriteId);
        sb.append(", favoriteOrnamentId=").append(favoriteOrnamentId);
        sb.append(", favoriteUserId=").append(favoriteUserId);
        sb.append(", favoriteClassId=").append(favoriteClassId);
        sb.append(", favoriteDetail=").append(favoriteDetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}