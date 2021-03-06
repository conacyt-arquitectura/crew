package mx.conacyt.crip.crew.service.mapper;

import mx.conacyt.crip.crew.domain.*;
import mx.conacyt.crip.crew.service.dto.PersonaDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Persona} and its DTO {@link PersonaDTO}.
 */
@Mapper(componentModel = "spring", uses = { AvatarMapper.class, AreaMapper.class, BadgeMapper.class })
public interface PersonaMapper extends EntityMapper<PersonaDTO, Persona> {
    @Mapping(source = "avatar.id", target = "avatarId")
    @Mapping(source = "area.id", target = "areaId")
    @Mapping(source = "badges.id", target = "badgesId")
    @Mapping(source = "user.id", target = "userId")
    PersonaDTO toDto(Persona persona);

    @Mapping(source = "avatarId", target = "avatar")
    @Mapping(source = "areaId", target = "area")
    @Mapping(source = "badgesId", target = "badges")
    @Mapping(source = "userId", target = "user")
    Persona toEntity(PersonaDTO personaDTO);

    default Persona fromId(String id) {
        if (id == null) {
            return null;
        }
        Persona persona = new Persona();
        persona.setId(id);
        return persona;
    }

    default String fromUser(User user) {
        return user.getId();
    }

    default User fromUserId(String userId) {
        if (userId == null) {
            return null;
        }
        User user = new User();
        user.setId(userId);
        return user;
    }
}
