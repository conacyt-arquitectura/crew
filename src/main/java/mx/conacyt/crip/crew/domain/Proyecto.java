package mx.conacyt.crip.crew.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;

/**
 * A Proyecto.
 */
@Document(collection = "proyecto")
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("clave")
    private String clave;

    @Field("logo")
    private byte[] logo;

    @Field("logo_content_type")
    private String logoContentType;

    @DBRef
    @Field("celula")
    @JsonIgnoreProperties(value = "proyectos", allowSetters = true)
    private Celula celula;

    @DBRef
    @Field("plataforma")
    @JsonIgnoreProperties(value = "proyectos", allowSetters = true)
    private Plataforma plataforma;

    @DBRef
    @Field("area")
    @JsonIgnoreProperties(value = "proyectos", allowSetters = true)
    private Area area;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Proyecto nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public Proyecto clave(String clave) {
        this.clave = clave;
        return this;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public byte[] getLogo() {
        return logo;
    }

    public Proyecto logo(byte[] logo) {
        this.logo = logo;
        return this;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public Proyecto logoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
        return this;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public Celula getCelula() {
        return celula;
    }

    public Proyecto celula(Celula celula) {
        this.celula = celula;
        return this;
    }

    public void setCelula(Celula celula) {
        this.celula = celula;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public Proyecto plataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
        return this;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Area getArea() {
        return area;
    }

    public Proyecto area(Area area) {
        this.area = area;
        return this;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Proyecto)) {
            return false;
        }
        return id != null && id.equals(((Proyecto) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Proyecto{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", clave='" + getClave() + "'" +
            ", logo='" + getLogo() + "'" +
            ", logoContentType='" + getLogoContentType() + "'" +
            "}";
    }
}
