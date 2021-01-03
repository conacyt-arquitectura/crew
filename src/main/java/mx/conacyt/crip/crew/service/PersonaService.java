package mx.conacyt.crip.crew.service;

import mx.conacyt.crip.crew.service.dto.PersonaDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link mx.conacyt.crip.crew.domain.Persona}.
 */
public interface PersonaService {

    /**
     * Save a persona.
     *
     * @param personaDTO the entity to save.
     * @return the persisted entity.
     */
    PersonaDTO save(PersonaDTO personaDTO);

    /**
     * Get all the personas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PersonaDTO> findAll(Pageable pageable);


    /**
     * Get the "id" persona.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PersonaDTO> findOne(String id);

    /**
     * Delete the "id" persona.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
