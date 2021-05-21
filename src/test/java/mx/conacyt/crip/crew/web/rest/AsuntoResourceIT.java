package mx.conacyt.crip.crew.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import mx.conacyt.crip.crew.CrewApp;
import mx.conacyt.crip.crew.config.TestSecurityConfiguration;
import mx.conacyt.crip.crew.domain.Asunto;
import mx.conacyt.crip.crew.repository.AsuntoRepository;
import mx.conacyt.crip.crew.service.AsuntoService;
import mx.conacyt.crip.crew.service.dto.AsuntoDTO;
import mx.conacyt.crip.crew.service.mapper.AsuntoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;

/**
 * Integration tests for the {@link AsuntoResource} REST controller.
 */
@SpringBootTest(classes = { CrewApp.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class AsuntoResourceIT {
    private static final String DEFAULT_NOMBRE = "AAAAAAAAAA";
    private static final String UPDATED_NOMBRE = "BBBBBBBBBB";

    private static final String DEFAULT_CLAVE = "AAAAAAAAAA";
    private static final String UPDATED_CLAVE = "BBBBBBBBBB";

    private static final byte[] DEFAULT_LOGO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_LOGO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_LOGO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_LOGO_CONTENT_TYPE = "image/png";

    @Autowired
    private AsuntoRepository asuntoRepository;

    @Autowired
    private AsuntoMapper asuntoMapper;

    @Autowired
    private AsuntoService asuntoService;

    @Autowired
    private MockMvc restAsuntoMockMvc;

    private Asunto asunto;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Asunto createEntity() {
        Asunto asunto = new Asunto()
            .nombre(DEFAULT_NOMBRE)
            .clave(DEFAULT_CLAVE)
            .logo(DEFAULT_LOGO)
            .logoContentType(DEFAULT_LOGO_CONTENT_TYPE);
        return asunto;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Asunto createUpdatedEntity() {
        Asunto asunto = new Asunto()
            .nombre(UPDATED_NOMBRE)
            .clave(UPDATED_CLAVE)
            .logo(UPDATED_LOGO)
            .logoContentType(UPDATED_LOGO_CONTENT_TYPE);
        return asunto;
    }

    @BeforeEach
    public void initTest() {
        asuntoRepository.deleteAll();
        asunto = createEntity();
    }

    @Test
    public void createAsunto() throws Exception {
        int databaseSizeBeforeCreate = asuntoRepository.findAll().size();
        // Create the Asunto
        AsuntoDTO asuntoDTO = asuntoMapper.toDto(asunto);
        restAsuntoMockMvc
            .perform(
                post("/api/asuntos")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(asuntoDTO))
            )
            .andExpect(status().isCreated());

        // Validate the Asunto in the database
        List<Asunto> asuntoList = asuntoRepository.findAll();
        assertThat(asuntoList).hasSize(databaseSizeBeforeCreate + 1);
        Asunto testAsunto = asuntoList.get(asuntoList.size() - 1);
        assertThat(testAsunto.getNombre()).isEqualTo(DEFAULT_NOMBRE);
        assertThat(testAsunto.getClave()).isEqualTo(DEFAULT_CLAVE);
        assertThat(testAsunto.getLogo()).isEqualTo(DEFAULT_LOGO);
        assertThat(testAsunto.getLogoContentType()).isEqualTo(DEFAULT_LOGO_CONTENT_TYPE);
    }

    @Test
    public void createAsuntoWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = asuntoRepository.findAll().size();

        // Create the Asunto with an existing ID
        asunto.setId("existing_id");
        AsuntoDTO asuntoDTO = asuntoMapper.toDto(asunto);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAsuntoMockMvc
            .perform(
                post("/api/asuntos")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(asuntoDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Asunto in the database
        List<Asunto> asuntoList = asuntoRepository.findAll();
        assertThat(asuntoList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    public void getAllAsuntos() throws Exception {
        // Initialize the database
        asuntoRepository.save(asunto);

        // Get all the asuntoList
        restAsuntoMockMvc
            .perform(get("/api/asuntos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(asunto.getId())))
            .andExpect(jsonPath("$.[*].nombre").value(hasItem(DEFAULT_NOMBRE)))
            .andExpect(jsonPath("$.[*].clave").value(hasItem(DEFAULT_CLAVE)))
            .andExpect(jsonPath("$.[*].logoContentType").value(hasItem(DEFAULT_LOGO_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].logo").value(hasItem(Base64Utils.encodeToString(DEFAULT_LOGO))));
    }

    @Test
    public void getAsunto() throws Exception {
        // Initialize the database
        asuntoRepository.save(asunto);

        // Get the asunto
        restAsuntoMockMvc
            .perform(get("/api/asuntos/{id}", asunto.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(asunto.getId()))
            .andExpect(jsonPath("$.nombre").value(DEFAULT_NOMBRE))
            .andExpect(jsonPath("$.clave").value(DEFAULT_CLAVE))
            .andExpect(jsonPath("$.logoContentType").value(DEFAULT_LOGO_CONTENT_TYPE))
            .andExpect(jsonPath("$.logo").value(Base64Utils.encodeToString(DEFAULT_LOGO)));
    }

    @Test
    public void getNonExistingAsunto() throws Exception {
        // Get the asunto
        restAsuntoMockMvc.perform(get("/api/asuntos/{id}", Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    public void updateAsunto() throws Exception {
        // Initialize the database
        asuntoRepository.save(asunto);

        int databaseSizeBeforeUpdate = asuntoRepository.findAll().size();

        // Update the asunto
        Asunto updatedAsunto = asuntoRepository.findById(asunto.getId()).get();
        updatedAsunto.nombre(UPDATED_NOMBRE).clave(UPDATED_CLAVE).logo(UPDATED_LOGO).logoContentType(UPDATED_LOGO_CONTENT_TYPE);
        AsuntoDTO asuntoDTO = asuntoMapper.toDto(updatedAsunto);

        restAsuntoMockMvc
            .perform(
                put("/api/asuntos")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(asuntoDTO))
            )
            .andExpect(status().isOk());

        // Validate the Asunto in the database
        List<Asunto> asuntoList = asuntoRepository.findAll();
        assertThat(asuntoList).hasSize(databaseSizeBeforeUpdate);
        Asunto testAsunto = asuntoList.get(asuntoList.size() - 1);
        assertThat(testAsunto.getNombre()).isEqualTo(UPDATED_NOMBRE);
        assertThat(testAsunto.getClave()).isEqualTo(UPDATED_CLAVE);
        assertThat(testAsunto.getLogo()).isEqualTo(UPDATED_LOGO);
        assertThat(testAsunto.getLogoContentType()).isEqualTo(UPDATED_LOGO_CONTENT_TYPE);
    }

    @Test
    public void updateNonExistingAsunto() throws Exception {
        int databaseSizeBeforeUpdate = asuntoRepository.findAll().size();

        // Create the Asunto
        AsuntoDTO asuntoDTO = asuntoMapper.toDto(asunto);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAsuntoMockMvc
            .perform(
                put("/api/asuntos")
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(asuntoDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Asunto in the database
        List<Asunto> asuntoList = asuntoRepository.findAll();
        assertThat(asuntoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteAsunto() throws Exception {
        // Initialize the database
        asuntoRepository.save(asunto);

        int databaseSizeBeforeDelete = asuntoRepository.findAll().size();

        // Delete the asunto
        restAsuntoMockMvc
            .perform(delete("/api/asuntos/{id}", asunto.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Asunto> asuntoList = asuntoRepository.findAll();
        assertThat(asuntoList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
