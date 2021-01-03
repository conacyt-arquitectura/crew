package mx.conacyt.crip.crew.service.mapper;


import mx.conacyt.crip.crew.domain.*;
import mx.conacyt.crip.crew.service.dto.BadgeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Badge} and its DTO {@link BadgeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BadgeMapper extends EntityMapper<BadgeDTO, Badge> {



    default Badge fromId(String id) {
        if (id == null) {
            return null;
        }
        Badge badge = new Badge();
        badge.setId(id);
        return badge;
    }
}
