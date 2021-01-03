package mx.conacyt.crip.crew.web.rest;

import mx.conacyt.crip.crew.service.ParticipacionService;
import mx.conacyt.crip.crew.web.rest.errors.BadRequestAlertException;
import mx.conacyt.crip.crew.service.dto.ParticipacionDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link mx.conacyt.crip.crew.domain.Participacion}.
 */
@RestController
@RequestMapping("/api")
public class ParticipacionResource {

    private final Logger log = LoggerFactory.getLogger(ParticipacionResource.class);

    private static final String ENTITY_NAME = "participacion";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ParticipacionService participacionService;

    public ParticipacionResource(ParticipacionService participacionService) {
        this.participacionService = participacionService;
    }

    /**
     * {@code POST  /participacions} : Create a new participacion.
     *
     * @param participacionDTO the participacionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new participacionDTO, or with status {@code 400 (Bad Request)} if the participacion has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/participacions")
    public ResponseEntity<ParticipacionDTO> createParticipacion(@RequestBody ParticipacionDTO participacionDTO) throws URISyntaxException {
        log.debug("REST request to save Participacion : {}", participacionDTO);
        if (participacionDTO.getId() != null) {
            throw new BadRequestAlertException("A new participacion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ParticipacionDTO result = participacionService.save(participacionDTO);
        return ResponseEntity.created(new URI("/api/participacions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /participacions} : Updates an existing participacion.
     *
     * @param participacionDTO the participacionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated participacionDTO,
     * or with status {@code 400 (Bad Request)} if the participacionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the participacionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/participacions")
    public ResponseEntity<ParticipacionDTO> updateParticipacion(@RequestBody ParticipacionDTO participacionDTO) throws URISyntaxException {
        log.debug("REST request to update Participacion : {}", participacionDTO);
        if (participacionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ParticipacionDTO result = participacionService.save(participacionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, participacionDTO.getId()))
            .body(result);
    }

    /**
     * {@code GET  /participacions} : get all the participacions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of participacions in body.
     */
    @GetMapping("/participacions")
    public ResponseEntity<List<ParticipacionDTO>> getAllParticipacions(Pageable pageable) {
        log.debug("REST request to get a page of Participacions");
        Page<ParticipacionDTO> page = participacionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /participacions/:id} : get the "id" participacion.
     *
     * @param id the id of the participacionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the participacionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/participacions/{id}")
    public ResponseEntity<ParticipacionDTO> getParticipacion(@PathVariable String id) {
        log.debug("REST request to get Participacion : {}", id);
        Optional<ParticipacionDTO> participacionDTO = participacionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(participacionDTO);
    }

    /**
     * {@code DELETE  /participacions/:id} : delete the "id" participacion.
     *
     * @param id the id of the participacionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/participacions/{id}")
    public ResponseEntity<Void> deleteParticipacion(@PathVariable String id) {
        log.debug("REST request to delete Participacion : {}", id);
        participacionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
