package mx.conacyt.crip.crew.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import mx.conacyt.crip.crew.web.rest.TestUtil;

public class CelulaDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CelulaDTO.class);
        CelulaDTO celulaDTO1 = new CelulaDTO();
        celulaDTO1.setId("id1");
        CelulaDTO celulaDTO2 = new CelulaDTO();
        assertThat(celulaDTO1).isNotEqualTo(celulaDTO2);
        celulaDTO2.setId(celulaDTO1.getId());
        assertThat(celulaDTO1).isEqualTo(celulaDTO2);
        celulaDTO2.setId("id2");
        assertThat(celulaDTO1).isNotEqualTo(celulaDTO2);
        celulaDTO1.setId(null);
        assertThat(celulaDTO1).isNotEqualTo(celulaDTO2);
    }
}
