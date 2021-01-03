package mx.conacyt.crip.crew.service;

import mx.conacyt.crip.crew.domain.Celula;
import mx.conacyt.crip.crew.repository.CelulaRepository;
import mx.conacyt.crip.crew.service.dto.CelulaDTO;
import mx.conacyt.crip.crew.service.mapper.CelulaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Celula}.
 */
@Service
public class CelulaService {

    private final Logger log = LoggerFactory.getLogger(CelulaService.class);

    private final CelulaRepository celulaRepository;

    private final CelulaMapper celulaMapper;

    public CelulaService(CelulaRepository celulaRepository, CelulaMapper celulaMapper) {
        this.celulaRepository = celulaRepository;
        this.celulaMapper = celulaMapper;
    }

    /**
     * Save a celula.
     *
     * @param celulaDTO the entity to save.
     * @return the persisted entity.
     */
    public CelulaDTO save(CelulaDTO celulaDTO) {
        log.debug("Request to save Celula : {}", celulaDTO);
        Celula celula = celulaMapper.toEntity(celulaDTO);
        celula = celulaRepository.save(celula);
        return celulaMapper.toDto(celula);
    }

    /**
     * Get all the celulas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    public Page<CelulaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Celulas");
        return celulaRepository.findAll(pageable)
            .map(celulaMapper::toDto);
    }


    /**
     * Get one celula by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Optional<CelulaDTO> findOne(String id) {
        log.debug("Request to get Celula : {}", id);
        return celulaRepository.findById(id)
            .map(celulaMapper::toDto);
    }

    /**
     * Delete the celula by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete Celula : {}", id);
        celulaRepository.deleteById(id);
    }
}
