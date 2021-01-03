package mx.conacyt.crip.crew.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link mx.conacyt.crip.crew.domain.Area} entity.
 */
public class AreaDTO implements Serializable {
    
    private String id;

    @NotNull
    private String nombre;

    private String responsable;

    private String correo;


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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        if (!(o instanceof AreaDTO)) {
            return false;
        }

        return id != null && id.equals(((AreaDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AreaDTO{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", responsable='" + getResponsable() + "'" +
            ", correo='" + getCorreo() + "'" +
            ", areaId='" + getAreaId() + "'" +
            "}";
    }
}
