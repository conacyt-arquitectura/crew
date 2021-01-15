package mx.conacyt.crip.crew.service;

import java.util.Optional;
import mx.conacyt.crip.crew.service.dto.ParticipacionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link mx.conacyt.crip.crew.domain.Participacion}.
 */
public interface ParticipacionService {
    /**
     * Save a participacion.
     *
     * @param participacionDTO the entity to save.
     * @return the persisted entity.
     */
    ParticipacionDTO save(ParticipacionDTO participacionDTO);

    /**
     * Get all the participacions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ParticipacionDTO> findAll(String celulaId, Pageable pageable);

    /**
     * Get the "id" participacion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ParticipacionDTO> findOne(String id);

    /**
     * Delete the "id" participacion.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
