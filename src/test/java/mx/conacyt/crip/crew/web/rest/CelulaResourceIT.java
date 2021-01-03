package mx.conacyt.crip.crew.web.rest;

import mx.conacyt.crip.crew.CrewApp;
import mx.conacyt.crip.crew.config.TestSecurityConfiguration;
import mx.conacyt.crip.crew.domain.Celula;
import mx.conacyt.crip.crew.repository.CelulaRepository;
import mx.conacyt.crip.crew.service.CelulaService;
import mx.conacyt.crip.crew.service.dto.CelulaDTO;
import mx.conacyt.crip.crew.service.mapper.CelulaMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link CelulaResource} REST controller.
 */
@SpringBootTest(classes = { CrewApp.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class CelulaResourceIT {

    private static final String DEFAULT_NOMBRE = "AAAAAAAAAA";
    private static final String UPDATED_NOMBRE = "BBBBBBBBBB";

    private static final byte[] DEFAULT_LOGO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_LOGO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_LOGO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_LOGO_CONTENT_TYPE = "image/png";

    @Autowired
    private CelulaRepository celulaRepository;

    @Autowired
    private CelulaMapper celulaMapper;

    @Autowired
    private CelulaService celulaService;

    @Autowired
    private MockMvc restCelulaMockMvc;

    private Celula celula;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Celula createEntity() {
        Celula celula = new Celula()
            .nombre(DEFAULT_NOMBRE)
            .logo(DEFAULT_LOGO)
            .logoContentType(DEFAULT_LOGO_CONTENT_TYPE);
        return celula;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Celula createUpdatedEntity() {
        Celula celula = new Celula()
            .nombre(UPDATED_NOMBRE)
            .logo(UPDATED_LOGO)
            .logoContentType(UPDATED_LOGO_CONTENT_TYPE);
        return celula;
    }

    @BeforeEach
    public void initTest() {
        celulaRepository.deleteAll();
        celula = createEntity();
    }

    @Test
    public void createCelula() throws Exception {
        int databaseSizeBeforeCreate = celulaRepository.findAll().size();
        // Create the Celula
        CelulaDTO celulaDTO = celulaMapper.toDto(celula);
        restCelulaMockMvc.perform(post("/api/celulas").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(celulaDTO)))
            .andExpect(status().isCreated());

        // Validate the Celula in the database
        List<Celula> celulaList = celulaRepository.findAll();
        assertThat(celulaList).hasSize(databaseSizeBeforeCreate + 1);
        Celula testCelula = celulaList.get(celulaList.size() - 1);
        assertThat(testCelula.getNombre()).isEqualTo(DEFAULT_NOMBRE);
        assertThat(testCelula.getLogo()).isEqualTo(DEFAULT_LOGO);
        assertThat(testCelula.getLogoContentType()).isEqualTo(DEFAULT_LOGO_CONTENT_TYPE);
    }

    @Test
    public void createCelulaWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = celulaRepository.findAll().size();

        // Create the Celula with an existing ID
        celula.setId("existing_id");
        CelulaDTO celulaDTO = celulaMapper.toDto(celula);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCelulaMockMvc.perform(post("/api/celulas").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(celulaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Celula in the database
        List<Celula> celulaList = celulaRepository.findAll();
        assertThat(celulaList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllCelulas() throws Exception {
        // Initialize the database
        celulaRepository.save(celula);

        // Get all the celulaList
        restCelulaMockMvc.perform(get("/api/celulas?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(celula.getId())))
            .andExpect(jsonPath("$.[*].nombre").value(hasItem(DEFAULT_NOMBRE)))
            .andExpect(jsonPath("$.[*].logoContentType").value(hasItem(DEFAULT_LOGO_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].logo").value(hasItem(Base64Utils.encodeToString(DEFAULT_LOGO))));
    }
    
    @Test
    public void getCelula() throws Exception {
        // Initialize the database
        celulaRepository.save(celula);

        // Get the celula
        restCelulaMockMvc.perform(get("/api/celulas/{id}", celula.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(celula.getId()))
            .andExpect(jsonPath("$.nombre").value(DEFAULT_NOMBRE))
            .andExpect(jsonPath("$.logoContentType").value(DEFAULT_LOGO_CONTENT_TYPE))
            .andExpect(jsonPath("$.logo").value(Base64Utils.encodeToString(DEFAULT_LOGO)));
    }
    @Test
    public void getNonExistingCelula() throws Exception {
        // Get the celula
        restCelulaMockMvc.perform(get("/api/celulas/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateCelula() throws Exception {
        // Initialize the database
        celulaRepository.save(celula);

        int databaseSizeBeforeUpdate = celulaRepository.findAll().size();

        // Update the celula
        Celula updatedCelula = celulaRepository.findById(celula.getId()).get();
        updatedCelula
            .nombre(UPDATED_NOMBRE)
            .logo(UPDATED_LOGO)
            .logoContentType(UPDATED_LOGO_CONTENT_TYPE);
        CelulaDTO celulaDTO = celulaMapper.toDto(updatedCelula);

        restCelulaMockMvc.perform(put("/api/celulas").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(celulaDTO)))
            .andExpect(status().isOk());

        // Validate the Celula in the database
        List<Celula> celulaList = celulaRepository.findAll();
        assertThat(celulaList).hasSize(databaseSizeBeforeUpdate);
        Celula testCelula = celulaList.get(celulaList.size() - 1);
        assertThat(testCelula.getNombre()).isEqualTo(UPDATED_NOMBRE);
        assertThat(testCelula.getLogo()).isEqualTo(UPDATED_LOGO);
        assertThat(testCelula.getLogoContentType()).isEqualTo(UPDATED_LOGO_CONTENT_TYPE);
    }

    @Test
    public void updateNonExistingCelula() throws Exception {
        int databaseSizeBeforeUpdate = celulaRepository.findAll().size();

        // Create the Celula
        CelulaDTO celulaDTO = celulaMapper.toDto(celula);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCelulaMockMvc.perform(put("/api/celulas").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(celulaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Celula in the database
        List<Celula> celulaList = celulaRepository.findAll();
        assertThat(celulaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteCelula() throws Exception {
        // Initialize the database
        celulaRepository.save(celula);

        int databaseSizeBeforeDelete = celulaRepository.findAll().size();

        // Delete the celula
        restCelulaMockMvc.perform(delete("/api/celulas/{id}", celula.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Celula> celulaList = celulaRepository.findAll();
        assertThat(celulaList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
