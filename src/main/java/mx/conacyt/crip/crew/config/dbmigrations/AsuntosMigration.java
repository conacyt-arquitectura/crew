package mx.conacyt.crip.crew.config.dbmigrations;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import mx.conacyt.crip.crew.domain.Asunto;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Creates the initial database setup.
 */
@ChangeLog(order = "003")
public class AsuntosMigration {

    @ChangeSet(order = "01", author = "arquitectura", id = "add-asuntos-default")
    public void addAsuntos(MongoTemplate mongoTemplate) {
        Asunto asunto1 = new Asunto().nombre("Apoyo a Madres Jefas de Familia");
        Asunto asunto2 = new Asunto().nombre("Becas Conacyt - OEA - AMEXCID 2021");
        Asunto asunto3 = new Asunto().nombre("Becas Conacyt – FUNED 2021 en Áreas relacionadas con la Salud");
        Asunto asunto4 = new Asunto().nombre("Becas Conacyt Daad 2021");
        Asunto asunto5 = new Asunto().nombre("Becas Conacyt FINBA 2021");
        Asunto asunto6 = new Asunto().nombre("Becas Conacyt Nacionales 2021 para Posgrados Tecnológicos (con la Industria)");
        Asunto asunto7 = new Asunto().nombre("Becas Conacyt Nacionales 2021 para Programas de Posgrado no Escolarizados");
        Asunto asunto8 = new Asunto().nombre("Becas Conacyt Nacionales 2021-1");
        Asunto asunto9 = new Asunto().nombre("Becas Conacyt Nacionales 2021-2");
        Asunto asunto10 = new Asunto().nombre("Becas Conacyt para Especialidades Médicas en el Extranjero 2020-2021 Cuarto periodo");
        Asunto asunto11 = new Asunto()
        .nombre("Becas Conacyt para Estudios de Doctorado en el Extranjero 2021 en Áreas relacionadas con la Salud");
        Asunto asunto12 = new Asunto().nombre("Becas Conacyt para estudios de Doctorado en Francia 2021");
        Asunto asunto13 = new Asunto().nombre("Becas Conacyt- Cultura");
        Asunto asunto14 = new Asunto()
        .nombre("Becas Conacyt-Regionales 2021 (Sureste, Sur Oriente, Occidente, Noroeste, Noreste Y Centro)");
        Asunto asunto15 = new Asunto().nombre("Becas de Movilidad para Especialidades Médicas 2021");
        Asunto asunto16 = new Asunto().nombre("Becas para Especialidades Médicas 2021");
        Asunto asunto17 = new Asunto().nombre("Catálogo Nacional de Infraestructura Científica y Tecnológica");
        Asunto asunto18 = new Asunto().nombre("Ciencia de Frontera");
        Asunto asunto19 = new Asunto()
        .nombre(
                "Convocatoria 2020-1 APOYO PARA PROYECTOS DE INVESTIGACIÓN CIENTÍFICA, DESARROLLO TECNOLÓGICO E INNOVACIÓN EN SALUD ANTE LA CONTINGENCIA POR COVID-19 (Cerrada)"
            );
        Asunto asunto20 = new Asunto()
        .nombre(
                "Convocatoria Apoyos a la Ciencia de Frontera: Fortalecimiento y Mantenimiento de Infraestructuras de Investigación de Uso Común y Capacitación Técnica 2021"
            );
        Asunto asunto21 = new Asunto()
        .nombre("Convocatoria ATHENA - Feria Nacional y Latinoamericana de Humanidades, Ciencias e Ingenierías");
        Asunto asunto22 = new Asunto()
        .nombre(
                "Convocatoria de “Apoyos para Acciones De Fortalecimiento, Articulación de Infraestructura y Desarrollo de Proyectos Científicos, Tecnológicos Y De Innovación en Laboratorios Nacionales CONACYT 2021”."
            );
        Asunto asunto23 = new Asunto().nombre("Convocatoria de Nuevo Ingreso PNPC 2021");
        Asunto asunto24 = new Asunto().nombre("Convocatoria de Renovación PNPC 2021");
        Asunto asunto25 = new Asunto().nombre("Convocatoria de Seguimiento PNPC, 2019-2024");
        Asunto asunto26 = new Asunto()
        .nombre("Convocatoria DESARROLLO DE INNOVACIONES TECNOLÓGICAS PARA UNA AGRICULTURA MEXICANA LIBRE DE AGROINSUMOS TÓXICOS");
        Asunto asunto27 = new Asunto()
        .nombre(
                "Convocatoria Fortalecimiento de Actividades Vinculadas con la Promoción, Difusión y Divulgación de las Humanidades, Ciencias, Tecnologías y la Innovación Academias Y Sociedades Científicas 2021"
            );
        Asunto asunto28 = new Asunto().nombre("Convocatoria Impulso a la  Consolidación de una Red Nacional de Jardines Etnobiológicos");
        Asunto asunto29 = new Asunto().nombre("Convocatoria Impulso al Establecimiento de una Red Nacional de Jardines Etnobiológicos");
        Asunto asunto30 = new Asunto().nombre("Convocatoria Ingreso, Permanencia o Promoción");
        Asunto asunto31 = new Asunto()
        .nombre("Convocatoria Ingreso, Permanencia o Promoción Convocatoria para la distinción de Investigador(a) Nacional Eméritos(as)");
        Asunto asunto32 = new Asunto().nombre("Convocatoria Olimpiadas Nacionales");
        Asunto asunto33 = new Asunto().nombre("Convocatoria para la distinción de Investigador(a) Nacional Eméritos(as)");
        Asunto asunto34 = new Asunto()
        .nombre(
                "Convocatoria para la Elaboración de Propuestas de Proyectos para el Fomento y Fortalecimiento de las Vocaciones Científicas"
            );
        Asunto asunto35 = new Asunto()
        .nombre("Convocatoria para Proyectos de Acceso Universal al Conocimiento ante la emergencia COVID-19.");
        Asunto asunto36 = new Asunto()
        .nombre(
                "Convocatoria Programa de Fortalecimiento Académico para Indígenas Apoyos Complementarios para Mujeres Indígenas Becarias Conacyt"
            );
        Asunto asunto37 = new Asunto()
        .nombre("Convocatoria Programa de Incorporación de Mujeres Indígenas a Posgrados para el Fortalecimiento Regional");
        Asunto asunto38 = new Asunto()
        .nombre("Convocatoria Programa para la Incorporación de Estudiantes con Discapacidad a Posgrados Nacionales");
        Asunto asunto39 = new Asunto().nombre("Diagnóstico Biofísico del Bosque de Chapultepec");
        Asunto asunto40 = new Asunto()
        .nombre(
                "Establecimiento de una Red de Espacios de Acceso Universal al Conocimiento Científico, Tecnológico y Humanístico a través del Arte."
            );
        Asunto asunto41 = new Asunto().nombre("Estancias Posdoctorales en el Extranjero");
        Asunto asunto42 = new Asunto().nombre("Estancias Posdoctorales por México 1er año");
        Asunto asunto43 = new Asunto().nombre("Estancias Posdoctorales por México 2do año de continuidad");
        Asunto asunto44 = new Asunto().nombre("Estancias Sabáticas");
        Asunto asunto45 = new Asunto().nombre("Estancias Técnicas México - Japón");
        Asunto asunto46 = new Asunto().nombre("Estímulo Fiscal a la Investigación y Desarrollo de Tecnología (EFIDT)");
        Asunto asunto47 = new Asunto().nombre("Estrategía de atención a las arribazones masivas de sargazo y micrositio sargazo");
        Asunto asunto48 = new Asunto().nombre("F003 2021-03");
        Asunto asunto49 = new Asunto()
        .nombre(
                "Fondo de Desarrollo Científico y Tecnológico para el Fomento de la Producción y Financiamiento de Vivienda y el Crecimiento del Sector Habitacional"
            );
        Asunto asunto50 = new Asunto().nombre("Fondo Institucional del CONACYT (FOINS)");
        Asunto asunto51 = new Asunto()
        .nombre(
                "Fondo Sectorial de Investigación en Materias Agrícola, Pecuaria, Acuacultura, Agrobiotecnología y Recursos Fitogenéticos."
            );
        Asunto asunto52 = new Asunto().nombre("Fondo Sectorial de Investigación para el Desarrollo Aeroportuario y la Navegación Aérea.");
        Asunto asunto53 = new Asunto().nombre("Fondo Sectorial de Investigación y Desarrollo en Ciencias Navales.");
        Asunto asunto54 = new Asunto().nombre("Fondo Sectorial de Investigación y Desarrollo sobre el Agua");
        Asunto asunto55 = new Asunto()
        .nombre(
                "Fondo Sectorial de Investigación, Desarrollo Tecnológico e Innovación del Ejército y Fuerza Aérea Mexicanos, CONACYT-SEDENA."
            );
        Asunto asunto56 = new Asunto()
        .nombre("Fondo Sectorial para la Investigación, el Desarrollo y la Innovación Tecnológica en Turismo.");
        Asunto asunto57 = new Asunto().nombre("Fondo Sectorial para la Investigación, el Desarrollo y la Innovación Tecnológica Forestal.");
        Asunto asunto58 = new Asunto().nombre("FORDECYT-PRONACES 2020-05");
        Asunto asunto59 = new Asunto().nombre("Investigación Científica Básica");
        Asunto asunto60 = new Asunto().nombre("Investigación en Fronteras de la Ciencia");
        Asunto asunto61 = new Asunto().nombre("Programa de Apoyos para Actividades Científicas, Tecnológicas y de Innovación");
        Asunto asunto62 = new Asunto().nombre("Programa de Formación de Alto Nivel para la Administración Pública Federal. Becas Tipo C");
        Asunto asunto63 = new Asunto().nombre("Programa Ecos Nord 2020");
        Asunto asunto64 = new Asunto().nombre("Programa Estratégico Nacional de Tecnología e Innovación Abierta (PENTA)");
        Asunto asunto65 = new Asunto().nombre("Programa Nacional Estratégico de Agentes tóxicos y procesos contaminantes");
        Asunto asunto66 = new Asunto().nombre("Programa Nacional Estratégico de Agua");
        Asunto asunto67 = new Asunto().nombre("Programa Nacional Estratégico de Cultura");
        Asunto asunto68 = new Asunto().nombre("Programa Nacional Estratégico de Vivienda");
        Asunto asunto69 = new Asunto().nombre("Programas Nacionales Estratégicos ");
        Asunto asunto70 = new Asunto().nombre("PRONACES EDUCACIÓN Fondo Sectorial de Investigación INIFED-CONACYT");
        Asunto asunto71 = new Asunto()
        .nombre(
                "PRONACES SEGURIDAD HUMANA Fondo Sectorial de Investigación y Desarrollo INMUJERES-CONACYT *Fondo Sectorial de Investigación para el Desarrollo Social"
            );
        Asunto asunto72 = new Asunto().nombre("PRONACES SISTEMAS SOCIOECOLÓGICOS Fondo Sectorial de Investigación Ambiental");
        Asunto asunto73 = new Asunto().nombre("PRONACES SOBERANÍA ALIMENTARIA");
        Asunto asunto74 = new Asunto().nombre("Proyectos de Desarrollo Científico para atender Problemas Nacionales");
        Asunto asunto75 = new Asunto()
        .nombre("Redes de Espacios de Acceso Universal al Conocimiento Científico, Tecnológico y Humanístico a través del Arte ");
        Asunto asunto76 = new Asunto().nombre("Redes Horizontales del Conocimiento");
        Asunto asunto77 = new Asunto().nombre("Retenciones y Repatriaciones");
        Asunto asunto78 = new Asunto().nombre("Sistema de Clasificación de Revistas Mexicanas de Ciencia y Tecnología");
        mongoTemplate.save(asunto1);
        mongoTemplate.save(asunto2);
        mongoTemplate.save(asunto3);
        mongoTemplate.save(asunto4);
        mongoTemplate.save(asunto5);
        mongoTemplate.save(asunto6);
        mongoTemplate.save(asunto7);
        mongoTemplate.save(asunto8);
        mongoTemplate.save(asunto9);
        mongoTemplate.save(asunto10);
        mongoTemplate.save(asunto11);
        mongoTemplate.save(asunto12);
        mongoTemplate.save(asunto13);
        mongoTemplate.save(asunto14);
        mongoTemplate.save(asunto15);
        mongoTemplate.save(asunto16);
        mongoTemplate.save(asunto17);
        mongoTemplate.save(asunto18);
        mongoTemplate.save(asunto19);
        mongoTemplate.save(asunto20);
        mongoTemplate.save(asunto21);
        mongoTemplate.save(asunto22);
        mongoTemplate.save(asunto23);
        mongoTemplate.save(asunto24);
        mongoTemplate.save(asunto25);
        mongoTemplate.save(asunto26);
        mongoTemplate.save(asunto27);
        mongoTemplate.save(asunto28);
        mongoTemplate.save(asunto29);
        mongoTemplate.save(asunto30);
        mongoTemplate.save(asunto31);
        mongoTemplate.save(asunto32);
        mongoTemplate.save(asunto33);
        mongoTemplate.save(asunto34);
        mongoTemplate.save(asunto35);
        mongoTemplate.save(asunto36);
        mongoTemplate.save(asunto37);
        mongoTemplate.save(asunto38);
        mongoTemplate.save(asunto39);
        mongoTemplate.save(asunto40);
        mongoTemplate.save(asunto41);
        mongoTemplate.save(asunto42);
        mongoTemplate.save(asunto43);
        mongoTemplate.save(asunto44);
        mongoTemplate.save(asunto45);
        mongoTemplate.save(asunto46);
        mongoTemplate.save(asunto47);
        mongoTemplate.save(asunto48);
        mongoTemplate.save(asunto49);
        mongoTemplate.save(asunto50);
        mongoTemplate.save(asunto51);
        mongoTemplate.save(asunto52);
        mongoTemplate.save(asunto53);
        mongoTemplate.save(asunto54);
        mongoTemplate.save(asunto55);
        mongoTemplate.save(asunto56);
        mongoTemplate.save(asunto57);
        mongoTemplate.save(asunto58);
        mongoTemplate.save(asunto59);
        mongoTemplate.save(asunto60);
        mongoTemplate.save(asunto61);
        mongoTemplate.save(asunto62);
        mongoTemplate.save(asunto63);
        mongoTemplate.save(asunto64);
        mongoTemplate.save(asunto65);
        mongoTemplate.save(asunto66);
        mongoTemplate.save(asunto67);
        mongoTemplate.save(asunto68);
        mongoTemplate.save(asunto69);
        mongoTemplate.save(asunto70);
        mongoTemplate.save(asunto71);
        mongoTemplate.save(asunto72);
        mongoTemplate.save(asunto73);
        mongoTemplate.save(asunto74);
        mongoTemplate.save(asunto75);
        mongoTemplate.save(asunto76);
        mongoTemplate.save(asunto77);
        mongoTemplate.save(asunto78);
    }
}
