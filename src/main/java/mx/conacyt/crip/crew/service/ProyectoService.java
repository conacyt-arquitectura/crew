package mx.conacyt.crip.crew.service;

import mx.conacyt.crip.crew.service.dto.ProyectoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link mx.conacyt.crip.crew.domain.Proyecto}.
 */
public interface ProyectoService {

    /**
     * Save a proyecto.
     *
     * @param proyectoDTO the entity to save.
     * @return the persisted entity.
     */
    ProyectoDTO save(ProyectoDTO proyectoDTO);

    /**
     * Get all the proyectos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ProyectoDTO> findAll(Pageable pageable);


    /**
     * Get the "id" proyecto.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProyectoDTO> findOne(String id);

    /**
     * Delete the "id" proyecto.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
