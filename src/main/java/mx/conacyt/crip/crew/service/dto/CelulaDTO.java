package mx.conacyt.crip.crew.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link mx.conacyt.crip.crew.domain.Celula} entity.
 */
public class CelulaDTO implements Serializable {
    
    private String id;

    private String nombre;

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
        if (!(o instanceof CelulaDTO)) {
            return false;
        }

        return id != null && id.equals(((CelulaDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CelulaDTO{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", logo='" + getLogo() + "'" +
            "}";
    }
}
