package mx.conacyt.crip.crew.service;

import java.lang.StackWalker.Option;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import mx.conacyt.crip.crew.domain.Avatar;
import mx.conacyt.crip.crew.domain.Persona;
import mx.conacyt.crip.crew.domain.User;
import mx.conacyt.crip.crew.domain.factory.PersonaFactory;
import mx.conacyt.crip.crew.repository.AvatarRepository;
import mx.conacyt.crip.crew.repository.PersonaRepository;
import mx.conacyt.crip.crew.security.SecurityUtils;
import mx.conacyt.crip.crew.service.UserService;
import mx.conacyt.crip.crew.service.dto.AvatarDTO;
import mx.conacyt.crip.crew.service.dto.PersonaDTO;
import mx.conacyt.crip.crew.service.mapper.AvatarMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing {@link Avatar}.
 */
@Service
public class AvatarService {
    private final Logger log = LoggerFactory.getLogger(AvatarService.class);

    private final AvatarRepository avatarRepository;

    private final AvatarMapper avatarMapper;

    private final PersonaService personaService;

    private final PersonaRepository personaRepository;

    private final UserService userService;

    public AvatarService(
        AvatarRepository avatarRepository,
        AvatarMapper avatarMapper,
        PersonaService personaService,
        PersonaRepository personaRepository,
        UserService userService
    ) {
        this.avatarRepository = avatarRepository;
        this.avatarMapper = avatarMapper;
        this.personaService = personaService;
        this.personaRepository = personaRepository;
        this.userService = userService;
    }

    /**
     * Save a avatar.
     *
     * @param avatarDTO the entity to save.
     * @return the persisted entity.
     */
    public AvatarDTO save(AvatarDTO avatarDTO) {
        log.debug("Request to save Avatar : {}", avatarDTO);
        Avatar avatar = avatarMapper.toEntity(avatarDTO);
        avatar = avatarRepository.save(avatar);
        Optional<String> userOptional = SecurityUtils.getCurrentUserLogin();
        Optional<PersonaDTO> personaOptional = personaService.findByLogin(userOptional.get());
        PersonaDTO personaDto = personaOptional.orElse(new PersonaDTO());
        personaDto.setAvatarId(avatar.getId());
        personaService.save(personaDto);
        return avatarMapper.toDto(avatar);
    }

    /**
     * Get all the avatars.
     *
     * @return the list of entities.
     */
    public List<AvatarDTO> findAll() {
        log.debug("Request to get all Avatars");
        return avatarRepository.findAll().stream().map(avatarMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one avatar by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<AvatarDTO> findOne(String id) {
        log.debug("Request to get Avatar : {}", id);
        return avatarRepository.findById(id).map(avatarMapper::toDto);
    }

    public Optional<AvatarDTO> findByLogin() {
        String login = SecurityUtils.getCurrentUserLogin().orElseThrow();
        User user = userService.getUserWithAuthoritiesByLogin(login).orElseThrow();
        Persona persona = personaRepository.findByUserId(user.getId()).orElse(PersonaFactory.createPersona());
        return Optional.of(persona.getAvatar()).map(avatarMapper::toDto);
    }

    /**
     * Delete the avatar by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete Avatar : {}", id);
        avatarRepository.deleteById(id);
    }
}
