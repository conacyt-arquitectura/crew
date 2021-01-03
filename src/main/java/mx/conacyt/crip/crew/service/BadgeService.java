package mx.conacyt.crip.crew.service;

import mx.conacyt.crip.crew.domain.Badge;
import mx.conacyt.crip.crew.repository.BadgeRepository;
import mx.conacyt.crip.crew.service.dto.BadgeDTO;
import mx.conacyt.crip.crew.service.mapper.BadgeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Badge}.
 */
@Service
public class BadgeService {

    private final Logger log = LoggerFactory.getLogger(BadgeService.class);

    private final BadgeRepository badgeRepository;

    private final BadgeMapper badgeMapper;

    public BadgeService(BadgeRepository badgeRepository, BadgeMapper badgeMapper) {
        this.badgeRepository = badgeRepository;
        this.badgeMapper = badgeMapper;
    }

    /**
     * Save a badge.
     *
     * @param badgeDTO the entity to save.
     * @return the persisted entity.
     */
    public BadgeDTO save(BadgeDTO badgeDTO) {
        log.debug("Request to save Badge : {}", badgeDTO);
        Badge badge = badgeMapper.toEntity(badgeDTO);
        badge = badgeRepository.save(badge);
        return badgeMapper.toDto(badge);
    }

    /**
     * Get all the badges.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    public Page<BadgeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Badges");
        return badgeRepository.findAll(pageable)
            .map(badgeMapper::toDto);
    }


    /**
     * Get one badge by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<BadgeDTO> findOne(String id) {
        log.debug("Request to get Badge : {}", id);
        return badgeRepository.findById(id)
            .map(badgeMapper::toDto);
    }

    /**
     * Delete the badge by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete Badge : {}", id);
        badgeRepository.deleteById(id);
    }
}
