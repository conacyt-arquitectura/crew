package mx.conacyt.crip.crew.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link mx.conacyt.crip.crew.domain.Proyecto} entity.
 */
public class ProyectoDTO implements Serializable {
    
    private String id;

    private String nombre;

    private String clave;

    private byte[] logo;

    private String logoContentType;

    private String celulaId;

    private String plataformaId;

    private String areaId;
    
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public String getCelulaId() {
        return celulaId;
    }

    public void setCelulaId(String celulaId) {
        this.celulaId = celulaId;
    }

    public String getPlataformaId() {
        return plataformaId;
    }

    public void setPlataformaId(String plataformaId) {
        this.plataformaId = plataformaId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProyectoDTO)) {
            return false;
        }

        return id != null && id.equals(((ProyectoDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProyectoDTO{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", clave='" + getClave() + "'" +
            ", logo='" + getLogo() + "'" +
            ", celulaId='" + getCelulaId() + "'" +
            ", plataformaId='" + getPlataformaId() + "'" +
            ", areaId='" + getAreaId() + "'" +
            "}";
    }
}
