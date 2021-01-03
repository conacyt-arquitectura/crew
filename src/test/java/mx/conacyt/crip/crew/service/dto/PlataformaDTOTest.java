package mx.conacyt.crip.crew.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import mx.conacyt.crip.crew.web.rest.TestUtil;

public class PlataformaDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PlataformaDTO.class);
        PlataformaDTO plataformaDTO1 = new PlataformaDTO();
        plataformaDTO1.setId("id1");
        PlataformaDTO plataformaDTO2 = new PlataformaDTO();
        assertThat(plataformaDTO1).isNotEqualTo(plataformaDTO2);
        plataformaDTO2.setId(plataformaDTO1.getId());
        assertThat(plataformaDTO1).isEqualTo(plataformaDTO2);
        plataformaDTO2.setId("id2");
        assertThat(plataformaDTO1).isNotEqualTo(plataformaDTO2);
        plataformaDTO1.setId(null);
        assertThat(plataformaDTO1).isNotEqualTo(plataformaDTO2);
    }
}
