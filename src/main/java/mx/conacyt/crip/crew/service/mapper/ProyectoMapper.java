package mx.conacyt.crip.crew.service.mapper;


import mx.conacyt.crip.crew.domain.*;
import mx.conacyt.crip.crew.service.dto.ProyectoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Proyecto} and its DTO {@link ProyectoDTO}.
 */
@Mapper(componentModel = "spring", uses = {CelulaMapper.class, PlataformaMapper.class, AreaMapper.class})
public interface ProyectoMapper extends EntityMapper<ProyectoDTO, Proyecto> {

    @Mapping(source = "celula.id", target = "celulaId")
    @Mapping(source = "plataforma.id", target = "plataformaId")
    @Mapping(source = "area.id", target = "areaId")
    ProyectoDTO toDto(Proyecto proyecto);

    @Mapping(source = "celulaId", target = "celula")
    @Mapping(source = "plataformaId", target = "plataforma")
    @Mapping(source = "areaId", target = "area")
    Proyecto toEntity(ProyectoDTO proyectoDTO);

    default Proyecto fromId(String id) {
        if (id == null) {
            return null;
        }
        Proyecto proyecto = new Proyecto();
        proyecto.setId(id);
        return proyecto;
    }
}
