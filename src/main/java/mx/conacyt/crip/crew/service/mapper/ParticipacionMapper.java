package mx.conacyt.crip.crew.service.mapper;


import mx.conacyt.crip.crew.domain.*;
import mx.conacyt.crip.crew.service.dto.ParticipacionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Participacion} and its DTO {@link ParticipacionDTO}.
 */
@Mapper(componentModel = "spring", uses = {PersonaMapper.class, RolMapper.class})
public interface ParticipacionMapper extends EntityMapper<ParticipacionDTO, Participacion> {

    @Mapping(source = "persona.id", target = "personaId")
    @Mapping(source = "rol.id", target = "rolId")
    ParticipacionDTO toDto(Participacion participacion);

    @Mapping(source = "personaId", target = "persona")
    @Mapping(source = "rolId", target = "rol")
    Participacion toEntity(ParticipacionDTO participacionDTO);

    default Participacion fromId(String id) {
        if (id == null) {
            return null;
        }
        Participacion participacion = new Participacion();
        participacion.setId(id);
        return participacion;
    }
}
