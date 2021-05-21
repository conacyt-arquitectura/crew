package mx.conacyt.crip.crew.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import mx.conacyt.crip.crew.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

public class AsuntoDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AsuntoDTO.class);
        AsuntoDTO asuntoDTO1 = new AsuntoDTO();
        asuntoDTO1.setId("id1");
        AsuntoDTO asuntoDTO2 = new AsuntoDTO();
        assertThat(asuntoDTO1).isNotEqualTo(asuntoDTO2);
        asuntoDTO2.setId(asuntoDTO1.getId());
        assertThat(asuntoDTO1).isEqualTo(asuntoDTO2);
        asuntoDTO2.setId("id2");
        assertThat(asuntoDTO1).isNotEqualTo(asuntoDTO2);
        asuntoDTO1.setId(null);
        assertThat(asuntoDTO1).isNotEqualTo(asuntoDTO2);
    }
}
