package mx.conacyt.crip.crew.web.rest;

import mx.conacyt.crip.crew.service.RolService;
import mx.conacyt.crip.crew.web.rest.errors.BadRequestAlertException;
import mx.conacyt.crip.crew.service.dto.RolDTO;

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
 * REST controller for managing {@link mx.conacyt.crip.crew.domain.Rol}.
 */
@RestController
@RequestMapping("/api")
public class RolResource {

    private final Logger log = LoggerFactory.getLogger(RolResource.class);

    private static final String ENTITY_NAME = "rol";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RolService rolService;

    public RolResource(RolService rolService) {
        this.rolService = rolService;
    }

    /**
     * {@code POST  /rols} : Create a new rol.
     *
     * @param rolDTO the rolDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new rolDTO, or with status {@code 400 (Bad Request)} if the rol has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/rols")
    public ResponseEntity<RolDTO> createRol(@RequestBody RolDTO rolDTO) throws URISyntaxException {
        log.debug("REST request to save Rol : {}", rolDTO);
        if (rolDTO.getId() != null) {
            throw new BadRequestAlertException("A new rol cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RolDTO result = rolService.save(rolDTO);
        return ResponseEntity.created(new URI("/api/rols/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /rols} : Updates an existing rol.
     *
     * @param rolDTO the rolDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated rolDTO,
     * or with status {@code 400 (Bad Request)} if the rolDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the rolDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/rols")
    public ResponseEntity<RolDTO> updateRol(@RequestBody RolDTO rolDTO) throws URISyntaxException {
        log.debug("REST request to update Rol : {}", rolDTO);
        if (rolDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RolDTO result = rolService.save(rolDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, rolDTO.getId()))
            .body(result);
    }

    /**
     * {@code GET  /rols} : get all the rols.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of rols in body.
     */
    @GetMapping("/rols")
    public ResponseEntity<List<RolDTO>> getAllRols(Pageable pageable) {
        log.debug("REST request to get a page of Rols");
        Page<RolDTO> page = rolService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /rols/:id} : get the "id" rol.
     *
     * @param id the id of the rolDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the rolDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/rols/{id}")
    public ResponseEntity<RolDTO> getRol(@PathVariable String id) {
        log.debug("REST request to get Rol : {}", id);
        Optional<RolDTO> rolDTO = rolService.findOne(id);
        return ResponseUtil.wrapOrNotFound(rolDTO);
    }

    /**
     * {@code DELETE  /rols/:id} : delete the "id" rol.
     *
     * @param id the id of the rolDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/rols/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable String id) {
        log.debug("REST request to delete Rol : {}", id);
        rolService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
