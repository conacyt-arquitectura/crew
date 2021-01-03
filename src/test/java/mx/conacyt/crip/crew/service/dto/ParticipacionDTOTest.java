package mx.conacyt.crip.crew.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import mx.conacyt.crip.crew.web.rest.TestUtil;

public class ParticipacionDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ParticipacionDTO.class);
        ParticipacionDTO participacionDTO1 = new ParticipacionDTO();
        participacionDTO1.setId("id1");
        ParticipacionDTO participacionDTO2 = new ParticipacionDTO();
        assertThat(participacionDTO1).isNotEqualTo(participacionDTO2);
        participacionDTO2.setId(participacionDTO1.getId());
        assertThat(participacionDTO1).isEqualTo(participacionDTO2);
        participacionDTO2.setId("id2");
        assertThat(participacionDTO1).isNotEqualTo(participacionDTO2);
        participacionDTO1.setId(null);
        assertThat(participacionDTO1).isNotEqualTo(participacionDTO2);
    }
}
