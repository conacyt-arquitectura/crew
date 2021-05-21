package mx.conacyt.crip.crew.service.mapper;

import mx.conacyt.crip.crew.domain.*;
import mx.conacyt.crip.crew.service.dto.AsuntoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Asunto} and its DTO {@link AsuntoDTO}.
 */
@Mapper(componentModel = "spring", uses = { CelulaMapper.class, PlataformaMapper.class, AreaMapper.class })
public interface AsuntoMapper extends EntityMapper<AsuntoDTO, Asunto> {
    @Mapping(source = "celula.id", target = "celulaId")
    @Mapping(source = "plataforma.id", target = "plataformaId")
    @Mapping(source = "area.id", target = "areaId")
    AsuntoDTO toDto(Asunto Asunto);

    @Mapping(source = "celulaId", target = "celula")
    @Mapping(source = "plataformaId", target = "plataforma")
    @Mapping(source = "areaId", target = "area")
    Asunto toEntity(AsuntoDTO AsuntoDTO);

    default Asunto fromId(String id) {
        if (id == null) {
            return null;
        }
        Asunto Asunto = new Asunto();
        Asunto.setId(id);
        return Asunto;
    }
}
