package mx.conacyt.crip.crew.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A Participacion.
 */
@Document(collection = "participacion")
public class Participacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @DBRef
    @Field("celula")
    @JsonIgnoreProperties(value = "participacions", allowSetters = true)
    private Celula celula;

    @DBRef
    @Field("persona")
    @JsonIgnoreProperties(value = "participacions", allowSetters = true)
    private Persona persona;

    @DBRef
    @Field("rol")
    @JsonIgnoreProperties(value = "participacions", allowSetters = true)
    private Rol rol;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Participacion persona(Persona persona) {
        this.persona = persona;
        return this;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Rol getRol() {
        return rol;
    }

    public Participacion rol(Rol rol) {
        this.rol = rol;
        return this;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Celula getCelula() {
        return celula;
    }

    public void setCelula(Celula celula) {
        this.celula = celula;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Participacion)) {
            return false;
        }
        return id != null && id.equals(((Participacion) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Participacion{" +
            "id=" + getId() +
            "}";
    }
}
