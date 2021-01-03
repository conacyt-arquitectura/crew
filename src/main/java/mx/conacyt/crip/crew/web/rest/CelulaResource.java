package mx.conacyt.crip.crew.web.rest;

import mx.conacyt.crip.crew.service.CelulaService;
import mx.conacyt.crip.crew.web.rest.errors.BadRequestAlertException;
import mx.conacyt.crip.crew.service.dto.CelulaDTO;

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
 * REST controller for managing {@link mx.conacyt.crip.crew.domain.Celula}.
 */
@RestController
@RequestMapping("/api")
public class CelulaResource {

    private final Logger log = LoggerFactory.getLogger(CelulaResource.class);

    private static final String ENTITY_NAME = "celula";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CelulaService celulaService;

    public CelulaResource(CelulaService celulaService) {
        this.celulaService = celulaService;
    }

    /**
     * {@code POST  /celulas} : Create a new celula.
     *
     * @param celulaDTO the celulaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new celulaDTO, or with status {@code 400 (Bad Request)} if the celula has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/celulas")
    public ResponseEntity<CelulaDTO> createCelula(@RequestBody CelulaDTO celulaDTO) throws URISyntaxException {
        log.debug("REST request to save Celula : {}", celulaDTO);
        if (celulaDTO.getId() != null) {
            throw new BadRequestAlertException("A new celula cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CelulaDTO result = celulaService.save(celulaDTO);
        return ResponseEntity.created(new URI("/api/celulas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /celulas} : Updates an existing celula.
     *
     * @param celulaDTO the celulaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated celulaDTO,
     * or with status {@code 400 (Bad Request)} if the celulaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the celulaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/celulas")
    public ResponseEntity<CelulaDTO> updateCelula(@RequestBody CelulaDTO celulaDTO) throws URISyntaxException {
        log.debug("REST request to update Celula : {}", celulaDTO);
        if (celulaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CelulaDTO result = celulaService.save(celulaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, celulaDTO.getId()))
            .body(result);
    }

    /**
     * {@code GET  /celulas} : get all the celulas.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of celulas in body.
     */
    @GetMapping("/celulas")
    public ResponseEntity<List<CelulaDTO>> getAllCelulas(Pageable pageable) {
        log.debug("REST request to get a page of Celulas");
        Page<CelulaDTO> page = celulaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /celulas/:id} : get the "id" celula.
     *
     * @param id the id of the celulaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the celulaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/celulas/{id}")
    public ResponseEntity<CelulaDTO> getCelula(@PathVariable String id) {
        log.debug("REST request to get Celula : {}", id);
        Optional<CelulaDTO> celulaDTO = celulaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(celulaDTO);
    }

    /**
     * {@code DELETE  /celulas/:id} : delete the "id" celula.
     *
     * @param id the id of the celulaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/celulas/{id}")
    public ResponseEntity<Void> deleteCelula(@PathVariable String id) {
        log.debug("REST request to delete Celula : {}", id);
        celulaService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
