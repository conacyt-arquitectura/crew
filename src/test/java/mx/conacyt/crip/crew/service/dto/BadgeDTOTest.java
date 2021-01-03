package mx.conacyt.crip.crew.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import mx.conacyt.crip.crew.web.rest.TestUtil;

public class BadgeDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BadgeDTO.class);
        BadgeDTO badgeDTO1 = new BadgeDTO();
        badgeDTO1.setId("id1");
        BadgeDTO badgeDTO2 = new BadgeDTO();
        assertThat(badgeDTO1).isNotEqualTo(badgeDTO2);
        badgeDTO2.setId(badgeDTO1.getId());
        assertThat(badgeDTO1).isEqualTo(badgeDTO2);
        badgeDTO2.setId("id2");
        assertThat(badgeDTO1).isNotEqualTo(badgeDTO2);
        badgeDTO1.setId(null);
        assertThat(badgeDTO1).isNotEqualTo(badgeDTO2);
    }
}
