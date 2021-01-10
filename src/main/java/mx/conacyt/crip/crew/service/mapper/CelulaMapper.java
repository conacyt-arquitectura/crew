package mx.conacyt.crip.crew.service.mapper;

import mx.conacyt.crip.crew.domain.*;
import mx.conacyt.crip.crew.service.dto.CelulaDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Celula} and its DTO {@link CelulaDTO}.
 */
@Mapper(componentModel = "spring", uses = { PlataformaMapper.class })
public interface CelulaMapper extends EntityMapper<CelulaDTO, Celula> {
    @Mapping(source = "plataforma.id", target = "plataformaId")
    @Mapping(source = "plataforma.clave", target = "plataformaClave")
    @Mapping(source = "plataforma.color", target = "plataformaColor")
    CelulaDTO toDto(Celula celula);

    @Mapping(source = "plataformaId", target = "plataforma.id")
    Celula toEntity(CelulaDTO celulaDTO);

    default Celula fromId(String id) {
        if (id == null) {
            return null;
        }
        Celula celula = new Celula();
        celula.setId(id);
        return celula;
    }
}
