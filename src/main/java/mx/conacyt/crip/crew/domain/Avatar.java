package mx.conacyt.crip.crew.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A Avatar.
 */
@Document(collection = "avatar")
public class Avatar implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("circle")
    private Boolean circle;

    @Field("human")
    private Boolean human;

    @Field("avatar_style")
    private String avatarStyle;

    @Field("circle_color")
    private String circleColor;

    @Field("accessories_type")
    private String accessoriesType;

    @Field("clothe_type")
    private String clotheType;

    @Field("clothe_color")
    private String clotheColor;

    @Field("eyebrow_type")
    private String eyebrowType;

    @Field("eye_type")
    private String eyeType;

    @Field("facial_hair_color")
    private String facialHairColor;

    @Field("facial_hair_type")
    private String facialHairType;

    @Field("graphic_type")
    private String graphicType;

    @Field("hair_color")
    private String hairColor;

    @Field("mouth_type")
    private String mouthType;

    @Field("skin_color")
    private String skinColor;

    @Field("top_type")
    private String topType;

    @Field("top_color")
    private String topColor;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isCircle() {
        return circle;
    }

    public Avatar isCircle(Boolean circle) {
        this.circle = circle;
        return this;
    }

    public void setCircle(Boolean circle) {
        this.circle = circle;
    }

    public Boolean isHuman() {
        return human;
    }

    public Avatar isHuman(Boolean human) {
        this.human = human;
        return this;
    }

    public void setHuman(Boolean human) {
        this.human = human;
    }

    public String getAvatarStyle() {
        return avatarStyle;
    }

    public Avatar avatarStyle(String avatarStyle) {
        this.avatarStyle = avatarStyle;
        return this;
    }

    public void setAvatarStyle(String avatarStyle) {
        this.avatarStyle = avatarStyle;
    }

    public String getCircleColor() {
        return circleColor;
    }

    public Avatar circleColor(String circleColor) {
        this.circleColor = circleColor;
        return this;
    }

    public void setCircleColor(String circleColor) {
        this.circleColor = circleColor;
    }

    public String getAccessoriesType() {
        return accessoriesType;
    }

    public Avatar accessoriesType(String accessoriesType) {
        this.accessoriesType = accessoriesType;
        return this;
    }

    public void setAccessoriesType(String accessoriesType) {
        this.accessoriesType = accessoriesType;
    }

    public String getClotheType() {
        return clotheType;
    }

    public Avatar clotheType(String clotheType) {
        this.clotheType = clotheType;
        return this;
    }

    public void setClotheType(String clotheType) {
        this.clotheType = clotheType;
    }

    public String getClotheColor() {
        return clotheColor;
    }

    public Avatar clotheColor(String clotheColor) {
        this.clotheColor = clotheColor;
        return this;
    }

    public void setClotheColor(String clotheColor) {
        this.clotheColor = clotheColor;
    }

    public String getEyebrowType() {
        return eyebrowType;
    }

    public Avatar eyebrowType(String eyebrowType) {
        this.eyebrowType = eyebrowType;
        return this;
    }

    public void setEyebrowType(String eyebrowType) {
        this.eyebrowType = eyebrowType;
    }

    public String getEyeType() {
        return eyeType;
    }

    public Avatar eyeType(String eyeType) {
        this.eyeType = eyeType;
        return this;
    }

    public void setEyeType(String eyeType) {
        this.eyeType = eyeType;
    }

    public String getFacialHairColor() {
        return facialHairColor;
    }

    public Avatar facialHairColor(String facialHairColor) {
        this.facialHairColor = facialHairColor;
        return this;
    }

    public void setFacialHairColor(String facialHairColor) {
        this.facialHairColor = facialHairColor;
    }

    public String getFacialHairType() {
        return facialHairType;
    }

    public Avatar facialHairType(String facialHairType) {
        this.facialHairType = facialHairType;
        return this;
    }

    public void setFacialHairType(String facialHairType) {
        this.facialHairType = facialHairType;
    }

    public String getGraphicType() {
        return graphicType;
    }

    public Avatar graphicType(String graphicType) {
        this.graphicType = graphicType;
        return this;
    }

    public void setGraphicType(String graphicType) {
        this.graphicType = graphicType;
    }

    public String getHairColor() {
        return hairColor;
    }

    public Avatar hairColor(String hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getMouthType() {
        return mouthType;
    }

    public Avatar mouthType(String mouthType) {
        this.mouthType = mouthType;
        return this;
    }

    public void setMouthType(String mouthType) {
        this.mouthType = mouthType;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public Avatar skinColor(String skinColor) {
        this.skinColor = skinColor;
        return this;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getTopType() {
        return topType;
    }

    public Avatar topType(String topType) {
        this.topType = topType;
        return this;
    }

    public void setTopType(String topType) {
        this.topType = topType;
    }

    public String getTopColor() {
        return topColor;
    }

    public Avatar topColor(String topColor) {
        this.topColor = topColor;
        return this;
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Avatar)) {
            return false;
        }
        return id != null && id.equals(((Avatar) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Avatar{" +
            "id=" + getId() +
            ", isCircle='" + isCircle() + "'" +
            ", isHuman='" + isHuman() + "'" +
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
