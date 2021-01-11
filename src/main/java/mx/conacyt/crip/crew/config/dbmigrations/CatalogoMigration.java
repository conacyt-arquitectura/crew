package mx.conacyt.crip.crew.config.dbmigrations;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import java.time.Instant;
import mx.conacyt.crip.crew.domain.Area;
import mx.conacyt.crip.crew.domain.Authority;
import mx.conacyt.crip.crew.domain.Celula;
import mx.conacyt.crip.crew.domain.Plataforma;
import mx.conacyt.crip.crew.domain.Rol;
import mx.conacyt.crip.crew.domain.User;
import mx.conacyt.crip.crew.security.AuthoritiesConstants;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Creates the initial database setup.
 */
@ChangeLog(order = "002")
public class CatalogoMigration {

    @ChangeSet(order = "01", author = "arquitectura", id = "01-addAreas")
    public void addAreas(MongoTemplate mongoTemplate) {
        // Direcciones
        Area becas = new Area().nombre("Dirección de Becas").responsable("Edwin Ricardo Triujeque Woods");
        Area redes = new Area().nombre("Dirección de Redes e Infraestructura Científica").responsable("Andrés Eduardo Triana Moreno");
        Area cf = new Area().nombre("Directora de Ciencia de Frontera").responsable("Sin responsable");
        Area sni = new Area()
            .nombre("Dirección de Vocaciones Científicas y Sistema Nacional de Investigadores")
            .responsable("Mario A. De Leo Winkler");
        Area pronaces = new Area().nombre("Dirección de PRONACES").responsable("Sin responsable");
        Area catedras = new Area().nombre("Dirección de Cátedras").responsable("Sin responsable");
        mongoTemplate.save(becas);
        mongoTemplate.save(redes);
        mongoTemplate.save(cf);
        mongoTemplate.save(sni);
        mongoTemplate.save(pronaces);
        mongoTemplate.save(catedras);

        // Subdirecciones
        Area nacionales = new Area().nombre("Becas Nacionales").responsable("Rosa Ivette Guzmán Ávila").area(becas);
        Area extranjero = new Area().nombre("Asignación de Becas al Extranjero").responsable("Marcela Cruz Caballero").area(becas);
        Area exbecarios = new Area().nombre("Jefatura de Exbecarios").responsable("Angélica Vianney Aguilar Gutiérrez").area(becas);

        Area pi = new Area().nombre("Gestión de Proyectos Institucionales").responsable("Elizabeth Olivares Teran").area(cf);
        Area ng = new Area().nombre("Subdirección de Normatividad y Gestion").responsable("Bonifacio Escobedo Lira").area(pronaces);

        Area movilidad = new Area().nombre("Movilidad y Enlace").responsable("Ignacio Moreno Vázquez").area(sni);
        Area vc = new Area().nombre("Vocaciones Científicas").responsable("Miriam Carrillo Barragán").area(sni);
        Area so = new Area().nombre("Subdirección de Operación").responsable("Karen Araceli Ontiveros Vázquez").area(sni);

        Area sc = new Area().nombre("Subdirección de Cátedras").responsable("Diego Axel López Peláez").area(catedras);

        mongoTemplate.save(nacionales);
        mongoTemplate.save(extranjero);
        mongoTemplate.save(exbecarios);
        mongoTemplate.save(pi);
        mongoTemplate.save(ng);
        mongoTemplate.save(movilidad);
        mongoTemplate.save(vc);
        mongoTemplate.save(so);
        mongoTemplate.save(sc);
    }

    @ChangeSet(order = "02", author = "arquitectura", id = "01-addRoles")
    public void addRoles(MongoTemplate mongoTemplate) {
        Rol ap = new Rol().clave("administrador").nombre("Administrador");
        Rol arquitecto = new Rol().clave("arquitecto").nombre("Arquitecto");
        Rol analista = new Rol().clave("analista").nombre("Analista");
        Rol desarrollador = new Rol().clave("dev").nombre("Desarrollador");
        Rol lider = new Rol().clave("lider").nombre("Líder");
        Rol tester = new Rol().clave("qa").nombre("Tester");
        Rol ux = new Rol().clave("ux").nombre("UX");
        Rol soporte = new Rol().clave("soporte").nombre("Soporte");
        mongoTemplate.save(ap);
        mongoTemplate.save(arquitecto);
        mongoTemplate.save(analista);
        mongoTemplate.save(desarrollador);
        mongoTemplate.save(lider);
        mongoTemplate.save(tester);
        mongoTemplate.save(ux);
        mongoTemplate.save(soporte);
    }

    @ChangeSet(order = "03", author = "arquitectura", id = "01-addPlataformas")
    public void addPlataformas(MongoTemplate mongoTemplate) {
        Plataforma salsa = new Plataforma().color("#74bb92").nombre("SALSA").clave("salsa");
        Plataforma miic = new Plataforma().color("#8fc1ef").nombre("MIIC").clave("miic");
        Plataforma seminuevos = new Plataforma().color("#db5757").nombre("Seminuevos").clave("seminuevos");
        Plataforma ps = new Plataforma().color("#ffe066").nombre("People Soft").clave("peoplesoft");
        Plataforma soporte = new Plataforma().color("#ced4da").nombre("Soporte").clave("soporte");
        mongoTemplate.save(salsa);
        mongoTemplate.save(miic);
        mongoTemplate.save(seminuevos);
        mongoTemplate.save(ps);
        mongoTemplate.save(soporte);
    }

    @ChangeSet(order = "04", author = "arquitectura", id = "01-addCelulas")
    public void addCelulas(MongoTemplate mongoTemplate) {
        Celula sniDev = new Celula().nombre("SNI Dev");
        Celula sniOp = new Celula().nombre("SNI Op");
        Celula becas = new Celula().nombre("MIIC - BECAS");
        Celula transversales = new Celula().nombre("MIIC - Transversales");
        Celula miicFondos = new Celula().nombre("MIIC - Fondos");
        Celula semiBecas = new Celula().nombre("Semi Becas");
        Celula semiFondos = new Celula().nombre("Semi Fondos");
        Celula psRh = new Celula().nombre("PS - Recursos H");
        Celula psRf = new Celula().nombre("PS - Recursos F");
        Celula psFondos = new Celula().nombre("PS - Fondos");
        Celula sBecas = new Celula().nombre("Salsa - Becas");
        Celula sFondos = new Celula().nombre("Salsa - Fondos");
        Celula soporte = new Celula().nombre("Soporte");
        mongoTemplate.save(sniDev);
        mongoTemplate.save(sniOp);
        mongoTemplate.save(becas);
        mongoTemplate.save(transversales);
        mongoTemplate.save(miicFondos);
        mongoTemplate.save(semiBecas);
        mongoTemplate.save(semiFondos);
        mongoTemplate.save(psRh);
        mongoTemplate.save(psRf);
        mongoTemplate.save(psFondos);
        mongoTemplate.save(sBecas);
        mongoTemplate.save(sFondos);
        mongoTemplate.save(soporte);
    }
}
