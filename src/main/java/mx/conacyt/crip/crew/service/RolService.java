package mx.conacyt.crip.crew.service;

import mx.conacyt.crip.crew.domain.Rol;
import mx.conacyt.crip.crew.repository.RolRepository;
import mx.conacyt.crip.crew.service.dto.RolDTO;
import mx.conacyt.crip.crew.service.mapper.RolMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Rol}.
 */
@Service
public class RolService {

    private final Logger log = LoggerFactory.getLogger(RolService.class);

    private final RolRepository rolRepository;

    private final RolMapper rolMapper;

    public RolService(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    /**
     * Save a rol.
     *
     * @param rolDTO the entity to save.
     * @return the persisted entity.
     */
    public RolDTO save(RolDTO rolDTO) {
        log.debug("Request to save Rol : {}", rolDTO);
        Rol rol = rolMapper.toEntity(rolDTO);
        rol = rolRepository.save(rol);
        return rolMapper.toDto(rol);
    }

    /**
     * Get all the rols.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    public Page<RolDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Rols");
        return rolRepository.findAll(pageable)
            .map(rolMapper::toDto);
    }


    /**
     * Get one rol by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<RolDTO> findOne(String id) {
        log.debug("Request to get Rol : {}", id);
        return rolRepository.findById(id)
            .map(rolMapper::toDto);
    }

    /**
     * Delete the rol by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete Rol : {}", id);
        rolRepository.deleteById(id);
    }
}
