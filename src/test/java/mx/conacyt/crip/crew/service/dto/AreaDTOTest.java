package mx.conacyt.crip.crew.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import mx.conacyt.crip.crew.web.rest.TestUtil;

public class AreaDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AreaDTO.class);
        AreaDTO areaDTO1 = new AreaDTO();
        areaDTO1.setId("id1");
        AreaDTO areaDTO2 = new AreaDTO();
        assertThat(areaDTO1).isNotEqualTo(areaDTO2);
        areaDTO2.setId(areaDTO1.getId());
        assertThat(areaDTO1).isEqualTo(areaDTO2);
        areaDTO2.setId("id2");
        assertThat(areaDTO1).isNotEqualTo(areaDTO2);
        areaDTO1.setId(null);
        assertThat(areaDTO1).isNotEqualTo(areaDTO2);
    }
}
