package mx.conacyt.crip.crew.web.rest;

import mx.conacyt.crip.crew.CrewApp;
import mx.conacyt.crip.crew.config.TestSecurityConfiguration;
import mx.conacyt.crip.crew.domain.Avatar;
import mx.conacyt.crip.crew.repository.AvatarRepository;
import mx.conacyt.crip.crew.service.AvatarService;
import mx.conacyt.crip.crew.service.dto.AvatarDTO;
import mx.conacyt.crip.crew.service.mapper.AvatarMapper;

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
 * Integration tests for the {@link AvatarResource} REST controller.
 */
@SpringBootTest(classes = { CrewApp.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class AvatarResourceIT {

    private static final Boolean DEFAULT_IS_CIRCLE = false;
    private static final Boolean UPDATED_IS_CIRCLE = true;

    private static final String DEFAULT_AVATAR_STYLE = "AAAAAAAAAA";
    private static final String UPDATED_AVATAR_STYLE = "BBBBBBBBBB";

    private static final String DEFAULT_CIRCLE_COLOR = "AAAAAAAAAA";
    private static final String UPDATED_CIRCLE_COLOR = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESSORIES_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ACCESSORIES_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CLOTHE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CLOTHE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CLOTHE_COLOR = "AAAAAAAAAA";
    private static final String UPDATED_CLOTHE_COLOR = "BBBBBBBBBB";

    private static final String DEFAULT_EYEBROW_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_EYEBROW_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_EYE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_EYE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_FACIAL_HAIR_COLOR = "AAAAAAAAAA";
    private static final String UPDATED_FACIAL_HAIR_COLOR = "BBBBBBBBBB";

    private static final String DEFAULT_FACIAL_HAIR_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_FACIAL_HAIR_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_GRAPHIC_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_GRAPHIC_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_HAIR_COLOR = "AAAAAAAAAA";
    private static final String UPDATED_HAIR_COLOR = "BBBBBBBBBB";

    private static final String DEFAULT_MOUTH_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_MOUTH_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SKIN_COLOR = "AAAAAAAAAA";
    private static final String UPDATED_SKIN_COLOR = "BBBBBBBBBB";

    private static final String DEFAULT_TOP_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TOP_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_TOP_COLOR = "AAAAAAAAAA";
    private static final String UPDATED_TOP_COLOR = "BBBBBBBBBB";

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private AvatarMapper avatarMapper;

    @Autowired
    private AvatarService avatarService;

    @Autowired
    private MockMvc restAvatarMockMvc;

    private Avatar avatar;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Avatar createEntity() {
        Avatar avatar = new Avatar()
            .isCircle(DEFAULT_IS_CIRCLE)
            .avatarStyle(DEFAULT_AVATAR_STYLE)
            .circleColor(DEFAULT_CIRCLE_COLOR)
            .accessoriesType(DEFAULT_ACCESSORIES_TYPE)
            .clotheType(DEFAULT_CLOTHE_TYPE)
            .clotheColor(DEFAULT_CLOTHE_COLOR)
            .eyebrowType(DEFAULT_EYEBROW_TYPE)
            .eyeType(DEFAULT_EYE_TYPE)
            .facialHairColor(DEFAULT_FACIAL_HAIR_COLOR)
            .facialHairType(DEFAULT_FACIAL_HAIR_TYPE)
            .graphicType(DEFAULT_GRAPHIC_TYPE)
            .hairColor(DEFAULT_HAIR_COLOR)
            .mouthType(DEFAULT_MOUTH_TYPE)
            .skinColor(DEFAULT_SKIN_COLOR)
            .topType(DEFAULT_TOP_TYPE)
            .topColor(DEFAULT_TOP_COLOR);
        return avatar;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Avatar createUpdatedEntity() {
        Avatar avatar = new Avatar()
            .isCircle(UPDATED_IS_CIRCLE)
            .avatarStyle(UPDATED_AVATAR_STYLE)
            .circleColor(UPDATED_CIRCLE_COLOR)
            .accessoriesType(UPDATED_ACCESSORIES_TYPE)
            .clotheType(UPDATED_CLOTHE_TYPE)
            .clotheColor(UPDATED_CLOTHE_COLOR)
            .eyebrowType(UPDATED_EYEBROW_TYPE)
            .eyeType(UPDATED_EYE_TYPE)
            .facialHairColor(UPDATED_FACIAL_HAIR_COLOR)
            .facialHairType(UPDATED_FACIAL_HAIR_TYPE)
            .graphicType(UPDATED_GRAPHIC_TYPE)
            .hairColor(UPDATED_HAIR_COLOR)
            .mouthType(UPDATED_MOUTH_TYPE)
            .skinColor(UPDATED_SKIN_COLOR)
            .topType(UPDATED_TOP_TYPE)
            .topColor(UPDATED_TOP_COLOR);
        return avatar;
    }

    @BeforeEach
    public void initTest() {
        avatarRepository.deleteAll();
        avatar = createEntity();
    }

    @Test
    public void createAvatar() throws Exception {
        int databaseSizeBeforeCreate = avatarRepository.findAll().size();
        // Create the Avatar
        AvatarDTO avatarDTO = avatarMapper.toDto(avatar);
        restAvatarMockMvc.perform(post("/api/avatars").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(avatarDTO)))
            .andExpect(status().isCreated());

        // Validate the Avatar in the database
        List<Avatar> avatarList = avatarRepository.findAll();
        assertThat(avatarList).hasSize(databaseSizeBeforeCreate + 1);
        Avatar testAvatar = avatarList.get(avatarList.size() - 1);
        assertThat(testAvatar.isIsCircle()).isEqualTo(DEFAULT_IS_CIRCLE);
        assertThat(testAvatar.getAvatarStyle()).isEqualTo(DEFAULT_AVATAR_STYLE);
        assertThat(testAvatar.getCircleColor()).isEqualTo(DEFAULT_CIRCLE_COLOR);
        assertThat(testAvatar.getAccessoriesType()).isEqualTo(DEFAULT_ACCESSORIES_TYPE);
        assertThat(testAvatar.getClotheType()).isEqualTo(DEFAULT_CLOTHE_TYPE);
        assertThat(testAvatar.getClotheColor()).isEqualTo(DEFAULT_CLOTHE_COLOR);
        assertThat(testAvatar.getEyebrowType()).isEqualTo(DEFAULT_EYEBROW_TYPE);
        assertThat(testAvatar.getEyeType()).isEqualTo(DEFAULT_EYE_TYPE);
        assertThat(testAvatar.getFacialHairColor()).isEqualTo(DEFAULT_FACIAL_HAIR_COLOR);
        assertThat(testAvatar.getFacialHairType()).isEqualTo(DEFAULT_FACIAL_HAIR_TYPE);
        assertThat(testAvatar.getGraphicType()).isEqualTo(DEFAULT_GRAPHIC_TYPE);
        assertThat(testAvatar.getHairColor()).isEqualTo(DEFAULT_HAIR_COLOR);
        assertThat(testAvatar.getMouthType()).isEqualTo(DEFAULT_MOUTH_TYPE);
        assertThat(testAvatar.getSkinColor()).isEqualTo(DEFAULT_SKIN_COLOR);
        assertThat(testAvatar.getTopType()).isEqualTo(DEFAULT_TOP_TYPE);
        assertThat(testAvatar.getTopColor()).isEqualTo(DEFAULT_TOP_COLOR);
    }

    @Test
    public void createAvatarWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = avatarRepository.findAll().size();

        // Create the Avatar with an existing ID
        avatar.setId("existing_id");
        AvatarDTO avatarDTO = avatarMapper.toDto(avatar);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAvatarMockMvc.perform(post("/api/avatars").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(avatarDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Avatar in the database
        List<Avatar> avatarList = avatarRepository.findAll();
        assertThat(avatarList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllAvatars() throws Exception {
        // Initialize the database
        avatarRepository.save(avatar);

        // Get all the avatarList
        restAvatarMockMvc.perform(get("/api/avatars?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(avatar.getId())))
            .andExpect(jsonPath("$.[*].isCircle").value(hasItem(DEFAULT_IS_CIRCLE.booleanValue())))
            .andExpect(jsonPath("$.[*].avatarStyle").value(hasItem(DEFAULT_AVATAR_STYLE)))
            .andExpect(jsonPath("$.[*].circleColor").value(hasItem(DEFAULT_CIRCLE_COLOR)))
            .andExpect(jsonPath("$.[*].accessoriesType").value(hasItem(DEFAULT_ACCESSORIES_TYPE)))
            .andExpect(jsonPath("$.[*].clotheType").value(hasItem(DEFAULT_CLOTHE_TYPE)))
            .andExpect(jsonPath("$.[*].clotheColor").value(hasItem(DEFAULT_CLOTHE_COLOR)))
            .andExpect(jsonPath("$.[*].eyebrowType").value(hasItem(DEFAULT_EYEBROW_TYPE)))
            .andExpect(jsonPath("$.[*].eyeType").value(hasItem(DEFAULT_EYE_TYPE)))
            .andExpect(jsonPath("$.[*].facialHairColor").value(hasItem(DEFAULT_FACIAL_HAIR_COLOR)))
            .andExpect(jsonPath("$.[*].facialHairType").value(hasItem(DEFAULT_FACIAL_HAIR_TYPE)))
            .andExpect(jsonPath("$.[*].graphicType").value(hasItem(DEFAULT_GRAPHIC_TYPE)))
            .andExpect(jsonPath("$.[*].hairColor").value(hasItem(DEFAULT_HAIR_COLOR)))
            .andExpect(jsonPath("$.[*].mouthType").value(hasItem(DEFAULT_MOUTH_TYPE)))
            .andExpect(jsonPath("$.[*].skinColor").value(hasItem(DEFAULT_SKIN_COLOR)))
            .andExpect(jsonPath("$.[*].topType").value(hasItem(DEFAULT_TOP_TYPE)))
            .andExpect(jsonPath("$.[*].topColor").value(hasItem(DEFAULT_TOP_COLOR)));
    }
    
    @Test
    public void getAvatar() throws Exception {
        // Initialize the database
        avatarRepository.save(avatar);

        // Get the avatar
        restAvatarMockMvc.perform(get("/api/avatars/{id}", avatar.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(avatar.getId()))
            .andExpect(jsonPath("$.isCircle").value(DEFAULT_IS_CIRCLE.booleanValue()))
            .andExpect(jsonPath("$.avatarStyle").value(DEFAULT_AVATAR_STYLE))
            .andExpect(jsonPath("$.circleColor").value(DEFAULT_CIRCLE_COLOR))
            .andExpect(jsonPath("$.accessoriesType").value(DEFAULT_ACCESSORIES_TYPE))
            .andExpect(jsonPath("$.clotheType").value(DEFAULT_CLOTHE_TYPE))
            .andExpect(jsonPath("$.clotheColor").value(DEFAULT_CLOTHE_COLOR))
            .andExpect(jsonPath("$.eyebrowType").value(DEFAULT_EYEBROW_TYPE))
            .andExpect(jsonPath("$.eyeType").value(DEFAULT_EYE_TYPE))
            .andExpect(jsonPath("$.facialHairColor").value(DEFAULT_FACIAL_HAIR_COLOR))
            .andExpect(jsonPath("$.facialHairType").value(DEFAULT_FACIAL_HAIR_TYPE))
            .andExpect(jsonPath("$.graphicType").value(DEFAULT_GRAPHIC_TYPE))
            .andExpect(jsonPath("$.hairColor").value(DEFAULT_HAIR_COLOR))
            .andExpect(jsonPath("$.mouthType").value(DEFAULT_MOUTH_TYPE))
            .andExpect(jsonPath("$.skinColor").value(DEFAULT_SKIN_COLOR))
            .andExpect(jsonPath("$.topType").value(DEFAULT_TOP_TYPE))
            .andExpect(jsonPath("$.topColor").value(DEFAULT_TOP_COLOR));
    }
    @Test
    public void getNonExistingAvatar() throws Exception {
        // Get the avatar
        restAvatarMockMvc.perform(get("/api/avatars/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateAvatar() throws Exception {
        // Initialize the database
        avatarRepository.save(avatar);

        int databaseSizeBeforeUpdate = avatarRepository.findAll().size();

        // Update the avatar
        Avatar updatedAvatar = avatarRepository.findById(avatar.getId()).get();
        updatedAvatar
            .isCircle(UPDATED_IS_CIRCLE)
            .avatarStyle(UPDATED_AVATAR_STYLE)
            .circleColor(UPDATED_CIRCLE_COLOR)
            .accessoriesType(UPDATED_ACCESSORIES_TYPE)
            .clotheType(UPDATED_CLOTHE_TYPE)
            .clotheColor(UPDATED_CLOTHE_COLOR)
            .eyebrowType(UPDATED_EYEBROW_TYPE)
            .eyeType(UPDATED_EYE_TYPE)
            .facialHairColor(UPDATED_FACIAL_HAIR_COLOR)
            .facialHairType(UPDATED_FACIAL_HAIR_TYPE)
            .graphicType(UPDATED_GRAPHIC_TYPE)
            .hairColor(UPDATED_HAIR_COLOR)
            .mouthType(UPDATED_MOUTH_TYPE)
            .skinColor(UPDATED_SKIN_COLOR)
            .topType(UPDATED_TOP_TYPE)
            .topColor(UPDATED_TOP_COLOR);
        AvatarDTO avatarDTO = avatarMapper.toDto(updatedAvatar);

        restAvatarMockMvc.perform(put("/api/avatars").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(avatarDTO)))
            .andExpect(status().isOk());

        // Validate the Avatar in the database
        List<Avatar> avatarList = avatarRepository.findAll();
        assertThat(avatarList).hasSize(databaseSizeBeforeUpdate);
        Avatar testAvatar = avatarList.get(avatarList.size() - 1);
        assertThat(testAvatar.isIsCircle()).isEqualTo(UPDATED_IS_CIRCLE);
        assertThat(testAvatar.getAvatarStyle()).isEqualTo(UPDATED_AVATAR_STYLE);
        assertThat(testAvatar.getCircleColor()).isEqualTo(UPDATED_CIRCLE_COLOR);
        assertThat(testAvatar.getAccessoriesType()).isEqualTo(UPDATED_ACCESSORIES_TYPE);
        assertThat(testAvatar.getClotheType()).isEqualTo(UPDATED_CLOTHE_TYPE);
        assertThat(testAvatar.getClotheColor()).isEqualTo(UPDATED_CLOTHE_COLOR);
        assertThat(testAvatar.getEyebrowType()).isEqualTo(UPDATED_EYEBROW_TYPE);
        assertThat(testAvatar.getEyeType()).isEqualTo(UPDATED_EYE_TYPE);
        assertThat(testAvatar.getFacialHairColor()).isEqualTo(UPDATED_FACIAL_HAIR_COLOR);
        assertThat(testAvatar.getFacialHairType()).isEqualTo(UPDATED_FACIAL_HAIR_TYPE);
        assertThat(testAvatar.getGraphicType()).isEqualTo(UPDATED_GRAPHIC_TYPE);
        assertThat(testAvatar.getHairColor()).isEqualTo(UPDATED_HAIR_COLOR);
        assertThat(testAvatar.getMouthType()).isEqualTo(UPDATED_MOUTH_TYPE);
        assertThat(testAvatar.getSkinColor()).isEqualTo(UPDATED_SKIN_COLOR);
        assertThat(testAvatar.getTopType()).isEqualTo(UPDATED_TOP_TYPE);
        assertThat(testAvatar.getTopColor()).isEqualTo(UPDATED_TOP_COLOR);
    }

    @Test
    public void updateNonExistingAvatar() throws Exception {
        int databaseSizeBeforeUpdate = avatarRepository.findAll().size();

        // Create the Avatar
        AvatarDTO avatarDTO = avatarMapper.toDto(avatar);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAvatarMockMvc.perform(put("/api/avatars").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(avatarDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Avatar in the database
        List<Avatar> avatarList = avatarRepository.findAll();
        assertThat(avatarList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteAvatar() throws Exception {
        // Initialize the database
        avatarRepository.save(avatar);

        int databaseSizeBeforeDelete = avatarRepository.findAll().size();

        // Delete the avatar
        restAvatarMockMvc.perform(delete("/api/avatars/{id}", avatar.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Avatar> avatarList = avatarRepository.findAll();
        assertThat(avatarList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
