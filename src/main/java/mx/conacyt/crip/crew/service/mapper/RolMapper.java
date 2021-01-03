package mx.conacyt.crip.crew.service.mapper;


import mx.conacyt.crip.crew.domain.*;
import mx.conacyt.crip.crew.service.dto.RolDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Rol} and its DTO {@link RolDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RolMapper extends EntityMapper<RolDTO, Rol> {



    default Rol fromId(String id) {
        if (id == null) {
            return null;
        }
        Rol rol = new Rol();
        rol.setId(id);
        return rol;
    }
}
