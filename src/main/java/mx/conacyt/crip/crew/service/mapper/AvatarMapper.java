package mx.conacyt.crip.crew.service.mapper;


import mx.conacyt.crip.crew.domain.*;
import mx.conacyt.crip.crew.service.dto.AvatarDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Avatar} and its DTO {@link AvatarDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AvatarMapper extends EntityMapper<AvatarDTO, Avatar> {



    default Avatar fromId(String id) {
        if (id == null) {
            return null;
        }
        Avatar avatar = new Avatar();
        avatar.setId(id);
        return avatar;
    }
}
