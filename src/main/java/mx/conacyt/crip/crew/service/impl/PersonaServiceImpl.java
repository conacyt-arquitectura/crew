package mx.conacyt.crip.crew.service.impl;

import java.util.Optional;
import mx.conacyt.crip.crew.domain.Persona;
import mx.conacyt.crip.crew.domain.User;
import mx.conacyt.crip.crew.repository.PersonaRepository;
import mx.conacyt.crip.crew.security.SecurityUtils;
import mx.conacyt.crip.crew.service.PersonaService;
import mx.conacyt.crip.crew.service.UserService;
import mx.conacyt.crip.crew.service.dto.PersonaDTO;
import mx.conacyt.crip.crew.service.mapper.PersonaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing {@link Persona}.
 */
@Service
public class PersonaServiceImpl implements PersonaService {
    private final Logger log = LoggerFactory.getLogger(PersonaServiceImpl.class);

    private final PersonaRepository personaRepository;

    private final PersonaMapper personaMapper;

    private final UserService userService;

    public PersonaServiceImpl(PersonaRepository personaRepository, PersonaMapper personaMapper, UserService userService) {
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
        this.userService = userService;
    }

    @Override
    public PersonaDTO save(PersonaDTO personaDTO) {
        log.debug("Request to save Persona : {}", personaDTO);
        if (personaDTO.getUserId() == null) {
            Optional<String> userOptional = SecurityUtils.getCurrentUserLogin();
            Optional<User> user = userService.getUserWithAuthoritiesByLogin(userOptional.get());
            personaDTO.setUserId(user.get().getId());
        }
        Persona persona = personaMapper.toEntity(personaDTO);
        persona = personaRepository.save(persona);
        return personaMapper.toDto(persona);
    }

    @Override
    public Page<PersonaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Personas");
        return personaRepository.findAll(pageable).map(personaMapper::toDto);
    }

    @Override
    public Optional<PersonaDTO> findOne(String id) {
        log.debug("Request to get Persona : {}", id);
        return personaRepository.findById(id).map(personaMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Persona : {}", id);
        personaRepository.deleteById(id);
    }

    @Override
    public Optional<PersonaDTO> findByUserId(String id) {
        return personaRepository.findByUserId(id).map(personaMapper::toDto);
    }

    @Override
    public Optional<PersonaDTO> findByLogin(String login) {
        Optional<User> userOptional = userService.getUserWithAuthoritiesByLogin(login);
        if (userOptional.isPresent()) {
            return personaRepository.findByUserId(userOptional.get().getId()).map(personaMapper::toDto);
        } else {
            return Optional.empty();
        }
    }
}
