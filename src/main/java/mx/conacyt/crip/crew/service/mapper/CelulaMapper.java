package mx.conacyt.crip.crew.service.mapper;


import mx.conacyt.crip.crew.domain.*;
import mx.conacyt.crip.crew.service.dto.CelulaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Celula} and its DTO {@link CelulaDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CelulaMapper extends EntityMapper<CelulaDTO, Celula> {



    default Celula fromId(String id) {
        if (id == null) {
            return null;
        }
        Celula celula = new Celula();
        celula.setId(id);
        return celula;
    }
}
