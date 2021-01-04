package mx.conacyt.crip.crew.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link mx.conacyt.crip.crew.domain.Avatar} entity.
 */
public class AvatarDTO implements Serializable {
    private String id;

    private Boolean circle;

    private Boolean human;

    private String avatarStyle;

    private String circleColor;

    private String accessoriesType;

    private String clotheType;

    private String clotheColor;

    private String eyebrowType;

    private String eyeType;

    private String facialHairColor;

    private String facialHairType;

    private String graphicType;

    private String hairColor;

    private String mouthType;

    private String skinColor;

    private String topType;

    private String topColor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isCircle() {
        return circle;
    }

    public void setCircle(Boolean circle) {
        this.circle = circle;
    }

    public Boolean isHuman() {
        return human;
    }

    public void setHuman(Boolean human) {
        this.human = human;
    }

    public String getAvatarStyle() {
        return avatarStyle;
    }

    public void setAvatarStyle(String avatarStyle) {
        this.avatarStyle = avatarStyle;
    }

    public String getCircleColor() {
        return circleColor;
    }

    public void setCircleColor(String circleColor) {
        this.circleColor = circleColor;
    }

    public String getAccessoriesType() {
        return accessoriesType;
    }

    public void setAccessoriesType(String accessoriesType) {
        this.accessoriesType = accessoriesType;
    }

    public String getClotheType() {
        return clotheType;
    }

    public void setClotheType(String clotheType) {
        this.clotheType = clotheType;
    }

    public String getClotheColor() {
        return clotheColor;
    }

    public void setClotheColor(String clotheColor) {
        this.clotheColor = clotheColor;
    }

    public String getEyebrowType() {
        return eyebrowType;
    }

    public void setEyebrowType(String eyebrowType) {
        this.eyebrowType = eyebrowType;
    }

    public String getEyeType() {
        return eyeType;
    }

    public void setEyeType(String eyeType) {
        this.eyeType = eyeType;
    }

    public String getFacialHairColor() {
        return facialHairColor;
    }

    public void setFacialHairColor(String facialHairColor) {
        this.facialHairColor = facialHairColor;
    }

    public String getFacialHairType() {
        return facialHairType;
    }

    public void setFacialHairType(String facialHairType) {
        this.facialHairType = facialHairType;
    }

    public String getGraphicType() {
        return graphicType;
    }

    public void setGraphicType(String graphicType) {
        this.graphicType = graphicType;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getMouthType() {
        return mouthType;
    }

    public void setMouthType(String mouthType) {
        this.mouthType = mouthType;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getTopType() {
        return topType;
    }

    public void setTopType(String topType) {
        this.topType = topType;
    }

    public String getTopColor() {
        return topColor;
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AvatarDTO)) {
            return false;
        }

        return id != null && id.equals(((AvatarDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AvatarDTO{" +
            "id=" + getId() +
            ", cirle='" + isCircle() + "'" +
            ", human='" + isHuman() + "'" +
            ", avatarStyle='" + getAvatarStyle() + "'" +
            ", circleColor='" + getCircleColor() + "'" +
            ", accessoriesType='" + getAccessoriesType() + "'" +
            ", clotheType='" + getClotheType() + "'" +
            ", clotheColor='" + getClotheColor() + "'" +
            ", eyebrowType='" + getEyebrowType() + "'" +
            ", eyeType='" + getEyeType() + "'" +
            ", facialHairColor='" + getFacialHairColor() + "'" +
            ", facialHairType='" + getFacialHairType() + "'" +
            ", graphicType='" + getGraphicType() + "'" +
            ", hairColor='" + getHairColor() + "'" +
            ", mouthType='" + getMouthType() + "'" +
            ", skinColor='" + getSkinColor() + "'" +
            ", topType='" + getTopType() + "'" +
            ", topColor='" + getTopColor() + "'" +
            "}";
    }
}
