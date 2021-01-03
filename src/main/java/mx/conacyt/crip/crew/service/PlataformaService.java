package mx.conacyt.crip.crew.service;

import mx.conacyt.crip.crew.domain.Plataforma;
import mx.conacyt.crip.crew.repository.PlataformaRepository;
import mx.conacyt.crip.crew.service.dto.PlataformaDTO;
import mx.conacyt.crip.crew.service.mapper.PlataformaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Plataforma}.
 */
@Service
public class PlataformaService {

    private final Logger log = LoggerFactory.getLogger(PlataformaService.class);

    private final PlataformaRepository plataformaRepository;

    private final PlataformaMapper plataformaMapper;

    public PlataformaService(PlataformaRepository plataformaRepository, PlataformaMapper plataformaMapper) {
        this.plataformaRepository = plataformaRepository;
        this.plataformaMapper = plataformaMapper;
    }

    /**
     * Save a plataforma.
     *
     * @param plataformaDTO the entity to save.
     * @return the persisted entity.
     */
    public PlataformaDTO save(PlataformaDTO plataformaDTO) {
        log.debug("Request to save Plataforma : {}", plataformaDTO);
        Plataforma plataforma = plataformaMapper.toEntity(plataformaDTO);
        plataforma = plataformaRepository.save(plataforma);
        return plataformaMapper.toDto(plataforma);
    }

    /**
     * Get all the plataformas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    public Page<PlataformaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Plataformas");
        return plataformaRepository.findAll(pageable)
            .map(plataformaMapper::toDto);
    }


    /**
     * Get one plataforma by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<PlataformaDTO> findOne(String id) {
        log.debug("Request to get Plataforma : {}", id);
        return plataformaRepository.findById(id)
            .map(plataformaMapper::toDto);
    }

    /**
     * Delete the plataforma by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete Plataforma : {}", id);
        plataformaRepository.deleteById(id);
    }
}
