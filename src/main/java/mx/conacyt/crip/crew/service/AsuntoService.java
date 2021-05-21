package mx.conacyt.crip.crew.service;

import java.util.Optional;
import mx.conacyt.crip.crew.service.dto.AsuntoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link mx.conacyt.crip.crew.domain.Asunto}.
 */
public interface AsuntoService {
    /**
     * Save a Asunto.
     *
     * @param AsuntoDTO the entity to save.
     * @return the persisted entity.
     */
    AsuntoDTO save(AsuntoDTO AsuntoDTO);

    /**
     * Get all the Asuntos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<AsuntoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" Asunto.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AsuntoDTO> findOne(String id);

    /**
     * Delete the "id" Asunto.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
