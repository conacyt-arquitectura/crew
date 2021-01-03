package mx.conacyt.crip.crew.service.mapper;


import mx.conacyt.crip.crew.domain.*;
import mx.conacyt.crip.crew.service.dto.PlataformaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Plataforma} and its DTO {@link PlataformaDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PlataformaMapper extends EntityMapper<PlataformaDTO, Plataforma> {



    default Plataforma fromId(String id) {
        if (id == null) {
            return null;
        }
        Plataforma plataforma = new Plataforma();
        plataforma.setId(id);
        return plataforma;
    }
}
