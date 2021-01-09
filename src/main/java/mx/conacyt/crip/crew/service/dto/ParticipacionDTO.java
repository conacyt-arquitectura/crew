package mx.conacyt.crip.crew.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link mx.conacyt.crip.crew.domain.Participacion} entity.
 */
public class ParticipacionDTO implements Serializable {
    private String id;

    private String celulaId;

    private String personaId;

    private String rolId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonaId() {
        return personaId;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }

    public String getCelulaId() {
        return celulaId;
    }

    public void setCelulaId(String celulaId) {
        this.celulaId = celulaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ParticipacionDTO)) {
            return false;
        }

        return id != null && id.equals(((ParticipacionDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ParticipacionDTO{" +
            "id=" + getId() +
            ", personaId='" + getPersonaId() + "'" +
            ", rolId='" + getRolId() + "'" +
            "}";
    }
}
