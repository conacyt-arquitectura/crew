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

    private String plataformaId;

    private String plataformaClave;

    private String plataformaColor;

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

    public String getPlataformaClave() {
        return plataformaClave;
    }

    public void setPlataformaClave(String plataformaClave) {
        this.plataformaClave = plataformaClave;
    }

    public String getPlataformaColor() {
        return plataformaColor;
    }

    public void setPlataformaColor(String plataformaColor) {
        this.plataformaColor = plataformaColor;
    }

    public String getPlataformaId() {
        return plataformaId;
    }

    public void setPlataformaId(String plataformaId) {
        this.plataformaId = plataformaId;
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
