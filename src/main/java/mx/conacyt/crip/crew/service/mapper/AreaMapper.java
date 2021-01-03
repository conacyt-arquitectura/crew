package mx.conacyt.crip.crew.service.mapper;


import mx.conacyt.crip.crew.domain.*;
import mx.conacyt.crip.crew.service.dto.AreaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Area} and its DTO {@link AreaDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AreaMapper extends EntityMapper<AreaDTO, Area> {

    @Mapping(source = "area.id", target = "areaId")
    AreaDTO toDto(Area area);

    @Mapping(source = "areaId", target = "area")
    Area toEntity(AreaDTO areaDTO);

    default Area fromId(String id) {
        if (id == null) {
            return null;
        }
        Area area = new Area();
        area.setId(id);
        return area;
    }
}
