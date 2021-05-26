package mx.conacyt.crip.crew.web.rest;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import mx.conacyt.crip.crew.domain.Asunto;
import mx.conacyt.crip.crew.service.AsuntoService;
import mx.conacyt.crip.crew.service.dto.AsuntoDTO;
import mx.conacyt.crip.crew.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * REST controller for managing {@link mx.conacyt.crip.crew.domain.Asunto}.
 */
@RestController
@RequestMapping("/api")
public class AsuntoResource {
    private final Logger log = LoggerFactory.getLogger(AsuntoResource.class);

    private static final String ENTITY_NAME = "Asunto";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AsuntoService AsuntoService;

    public AsuntoResource(AsuntoService AsuntoService) {
        this.AsuntoService = AsuntoService;
    }

    /**
     * {@code POST  /Asuntos} : Create a new Asunto.
     *
     * @param AsuntoDTO the AsuntoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new AsuntoDTO, or with status {@code 400 (Bad Request)} if the Asunto has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/asuntos")
    public ResponseEntity<AsuntoDTO> createAsunto(@RequestBody AsuntoDTO AsuntoDTO) throws URISyntaxException {
        log.debug("REST request to save Asunto : {}", AsuntoDTO);
        if (AsuntoDTO.getId() != null) {
            throw new BadRequestAlertException("A new Asunto cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AsuntoDTO result = AsuntoService.save(AsuntoDTO);
        return ResponseEntity
            .created(new URI("/api/asuntos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /Asuntos} : Updates an existing Asunto.
     *
     * @param AsuntoDTO the AsuntoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated AsuntoDTO,
     * or with status {@code 400 (Bad Request)} if the AsuntoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the AsuntoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/asuntos")
    public ResponseEntity<AsuntoDTO> updateAsunto(@RequestBody AsuntoDTO AsuntoDTO) throws URISyntaxException {
        log.debug("REST request to update Asunto : {}", AsuntoDTO);
        if (AsuntoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AsuntoDTO result = AsuntoService.save(AsuntoDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, AsuntoDTO.getId()))
            .body(result);
    }

    /**
     * {@code GET  /Asuntos} : get all the Asuntos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of Asuntos in body.
     */
    @GetMapping("/asuntos")
    public ResponseEntity<List<AsuntoDTO>> getAllAsuntos(Pageable pageable) {
        log.debug("REST request to get a page of Asuntos");
        Page<AsuntoDTO> page = AsuntoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /Asuntos} : get all the Asuntos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of Asuntos in body.
     */
    @GetMapping("/convocatorias")
    public ResponseEntity<List<AsuntoDTO>> getAllConvocatorias(@RequestParam(required = false) String nombre) {
        log.debug("REST request to get a page of Asuntos");

        List<AsuntoDTO> convocatorias = null;
        if (nombre == null) {
            convocatorias = AsuntoService.findAll();
        } else {
            convocatorias = AsuntoService.findByQuery(nombre);
        }
        return ResponseEntity.ok().body(convocatorias);
    }

    /**
     * {@code GET  /Asuntos/:id} : get the "id" Asunto.
     *
     * @param id the id of the AsuntoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the AsuntoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/asuntos/{id}")
    public ResponseEntity<AsuntoDTO> getAsunto(@PathVariable String id) {
        log.debug("REST request to get Asunto : {}", id);
        Optional<AsuntoDTO> AsuntoDTO = AsuntoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(AsuntoDTO);
    }

    /**
     * {@code DELETE  /Asuntos/:id} : delete the "id" Asunto.
     *
     * @param id the id of the AsuntoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/asuntos/{id}")
    public ResponseEntity<Void> deleteAsunto(@PathVariable String id) {
        log.debug("REST request to delete Asunto : {}", id);
        AsuntoService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
