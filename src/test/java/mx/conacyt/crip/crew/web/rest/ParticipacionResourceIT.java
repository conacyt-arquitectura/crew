package mx.conacyt.crip.crew.web.rest;

import mx.conacyt.crip.crew.CrewApp;
import mx.conacyt.crip.crew.config.TestSecurityConfiguration;
import mx.conacyt.crip.crew.domain.Participacion;
import mx.conacyt.crip.crew.repository.ParticipacionRepository;
import mx.conacyt.crip.crew.service.ParticipacionService;
import mx.conacyt.crip.crew.service.dto.ParticipacionDTO;
import mx.conacyt.crip.crew.service.mapper.ParticipacionMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ParticipacionResource} REST controller.
 */
@SpringBootTest(classes = { CrewApp.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class ParticipacionResourceIT {

    @Autowired
    private ParticipacionRepository participacionRepository;

    @Autowired
    private ParticipacionMapper participacionMapper;

    @Autowired
    private ParticipacionService participacionService;

    @Autowired
    private MockMvc restParticipacionMockMvc;

    private Participacion participacion;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Participacion createEntity() {
        Participacion participacion = new Participacion();
        return participacion;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Participacion createUpdatedEntity() {
        Participacion participacion = new Participacion();
        return participacion;
    }

    @BeforeEach
    public void initTest() {
        participacionRepository.deleteAll();
        participacion = createEntity();
    }

    @Test
    public void createParticipacion() throws Exception {
        int databaseSizeBeforeCreate = participacionRepository.findAll().size();
        // Create the Participacion
        ParticipacionDTO participacionDTO = participacionMapper.toDto(participacion);
        restParticipacionMockMvc.perform(post("/api/participacions").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(participacionDTO)))
            .andExpect(status().isCreated());

        // Validate the Participacion in the database
        List<Participacion> participacionList = participacionRepository.findAll();
        assertThat(participacionList).hasSize(databaseSizeBeforeCreate + 1);
        Participacion testParticipacion = participacionList.get(participacionList.size() - 1);
    }

    @Test
    public void createParticipacionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = participacionRepository.findAll().size();

        // Create the Participacion with an existing ID
        participacion.setId("existing_id");
        ParticipacionDTO participacionDTO = participacionMapper.toDto(participacion);

        // An entity with an existing ID cannot be created, so this API call must fail
        restParticipacionMockMvc.perform(post("/api/participacions").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(participacionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Participacion in the database
        List<Participacion> participacionList = participacionRepository.findAll();
        assertThat(participacionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllParticipacions() throws Exception {
        // Initialize the database
        participacionRepository.save(participacion);

        // Get all the participacionList
        restParticipacionMockMvc.perform(get("/api/participacions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(participacion.getId())));
    }
    
    @Test
    public void getParticipacion() throws Exception {
        // Initialize the database
        participacionRepository.save(participacion);

        // Get the participacion
        restParticipacionMockMvc.perform(get("/api/participacions/{id}", participacion.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(participacion.getId()));
    }
    @Test
    public void getNonExistingParticipacion() throws Exception {
        // Get the participacion
        restParticipacionMockMvc.perform(get("/api/participacions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateParticipacion() throws Exception {
        // Initialize the database
        participacionRepository.save(participacion);

        int databaseSizeBeforeUpdate = participacionRepository.findAll().size();

        // Update the participacion
        Participacion updatedParticipacion = participacionRepository.findById(participacion.getId()).get();
        ParticipacionDTO participacionDTO = participacionMapper.toDto(updatedParticipacion);

        restParticipacionMockMvc.perform(put("/api/participacions").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(participacionDTO)))
            .andExpect(status().isOk());

        // Validate the Participacion in the database
        List<Participacion> participacionList = participacionRepository.findAll();
        assertThat(participacionList).hasSize(databaseSizeBeforeUpdate);
        Participacion testParticipacion = participacionList.get(participacionList.size() - 1);
    }

    @Test
    public void updateNonExistingParticipacion() throws Exception {
        int databaseSizeBeforeUpdate = participacionRepository.findAll().size();

        // Create the Participacion
        ParticipacionDTO participacionDTO = participacionMapper.toDto(participacion);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restParticipacionMockMvc.perform(put("/api/participacions").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(participacionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Participacion in the database
        List<Participacion> participacionList = participacionRepository.findAll();
        assertThat(participacionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteParticipacion() throws Exception {
        // Initialize the database
        participacionRepository.save(participacion);

        int databaseSizeBeforeDelete = participacionRepository.findAll().size();

        // Delete the participacion
        restParticipacionMockMvc.perform(delete("/api/participacions/{id}", participacion.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Participacion> participacionList = participacionRepository.findAll();
        assertThat(participacionList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
