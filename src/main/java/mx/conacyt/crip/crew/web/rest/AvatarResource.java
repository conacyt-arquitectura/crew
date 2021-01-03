package mx.conacyt.crip.crew.web.rest;

import mx.conacyt.crip.crew.service.AvatarService;
import mx.conacyt.crip.crew.web.rest.errors.BadRequestAlertException;
import mx.conacyt.crip.crew.service.dto.AvatarDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link mx.conacyt.crip.crew.domain.Avatar}.
 */
@RestController
@RequestMapping("/api")
public class AvatarResource {

    private final Logger log = LoggerFactory.getLogger(AvatarResource.class);

    private static final String ENTITY_NAME = "avatar";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AvatarService avatarService;

    public AvatarResource(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    /**
     * {@code POST  /avatars} : Create a new avatar.
     *
     * @param avatarDTO the avatarDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new avatarDTO, or with status {@code 400 (Bad Request)} if the avatar has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/avatars")
    public ResponseEntity<AvatarDTO> createAvatar(@RequestBody AvatarDTO avatarDTO) throws URISyntaxException {
        log.debug("REST request to save Avatar : {}", avatarDTO);
        if (avatarDTO.getId() != null) {
            throw new BadRequestAlertException("A new avatar cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AvatarDTO result = avatarService.save(avatarDTO);
        return ResponseEntity.created(new URI("/api/avatars/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /avatars} : Updates an existing avatar.
     *
     * @param avatarDTO the avatarDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated avatarDTO,
     * or with status {@code 400 (Bad Request)} if the avatarDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the avatarDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/avatars")
    public ResponseEntity<AvatarDTO> updateAvatar(@RequestBody AvatarDTO avatarDTO) throws URISyntaxException {
        log.debug("REST request to update Avatar : {}", avatarDTO);
        if (avatarDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AvatarDTO result = avatarService.save(avatarDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, avatarDTO.getId()))
            .body(result);
    }

    /**
     * {@code GET  /avatars} : get all the avatars.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of avatars in body.
     */
    @GetMapping("/avatars")
    public List<AvatarDTO> getAllAvatars() {
        log.debug("REST request to get all Avatars");
        return avatarService.findAll();
    }

    /**
     * {@code GET  /avatars/:id} : get the "id" avatar.
     *
     * @param id the id of the avatarDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the avatarDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/avatars/{id}")
    public ResponseEntity<AvatarDTO> getAvatar(@PathVariable String id) {
        log.debug("REST request to get Avatar : {}", id);
        Optional<AvatarDTO> avatarDTO = avatarService.findOne(id);
        return ResponseUtil.wrapOrNotFound(avatarDTO);
    }

    /**
     * {@code DELETE  /avatars/:id} : delete the "id" avatar.
     *
     * @param id the id of the avatarDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/avatars/{id}")
    public ResponseEntity<Void> deleteAvatar(@PathVariable String id) {
        log.debug("REST request to delete Avatar : {}", id);
        avatarService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
