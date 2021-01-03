package mx.conacyt.crip.crew.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import mx.conacyt.crip.crew.web.rest.TestUtil;

public class RolDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RolDTO.class);
        RolDTO rolDTO1 = new RolDTO();
        rolDTO1.setId("id1");
        RolDTO rolDTO2 = new RolDTO();
        assertThat(rolDTO1).isNotEqualTo(rolDTO2);
        rolDTO2.setId(rolDTO1.getId());
        assertThat(rolDTO1).isEqualTo(rolDTO2);
        rolDTO2.setId("id2");
        assertThat(rolDTO1).isNotEqualTo(rolDTO2);
        rolDTO1.setId(null);
        assertThat(rolDTO1).isNotEqualTo(rolDTO2);
    }
}
