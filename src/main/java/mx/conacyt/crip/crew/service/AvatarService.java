package mx.conacyt.crip.crew.service;

import mx.conacyt.crip.crew.domain.Avatar;
import mx.conacyt.crip.crew.repository.AvatarRepository;
import mx.conacyt.crip.crew.service.dto.AvatarDTO;
import mx.conacyt.crip.crew.service.mapper.AvatarMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Avatar}.
 */
@Service
public class AvatarService {

    private final Logger log = LoggerFactory.getLogger(AvatarService.class);

    private final AvatarRepository avatarRepository;

    private final AvatarMapper avatarMapper;

    public AvatarService(AvatarRepository avatarRepository, AvatarMapper avatarMapper) {
        this.avatarRepository = avatarRepository;
        this.avatarMapper = avatarMapper;
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
        return avatarMapper.toDto(avatar);
    }

    /**
     * Get all the avatars.
     *
     * @return the list of entities.
     */
    public List<AvatarDTO> findAll() {
        log.debug("Request to get all Avatars");
        return avatarRepository.findAll().stream()
            .map(avatarMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one avatar by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<AvatarDTO> findOne(String id) {
        log.debug("Request to get Avatar : {}", id);
        return avatarRepository.findById(id)
            .map(avatarMapper::toDto);
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
