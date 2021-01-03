package mx.conacyt.crip.crew.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link mx.conacyt.crip.crew.domain.Plataforma} entity.
 */
public class PlataformaDTO implements Serializable {
    
    private String id;

    private String nombre;

    private String color;

    private byte[] logo;

    private String logoContentType;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlataformaDTO)) {
            return false;
        }

        return id != null && id.equals(((PlataformaDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PlataformaDTO{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", color='" + getColor() + "'" +
            ", logo='" + getLogo() + "'" +
            "}";
    }
}
