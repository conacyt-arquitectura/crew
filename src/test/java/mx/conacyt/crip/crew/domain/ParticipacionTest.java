package mx.conacyt.crip.crew.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import mx.conacyt.crip.crew.web.rest.TestUtil;

public class ParticipacionTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Participacion.class);
        Participacion participacion1 = new Participacion();
        participacion1.setId("id1");
        Participacion participacion2 = new Participacion();
        participacion2.setId(participacion1.getId());
        assertThat(participacion1).isEqualTo(participacion2);
        participacion2.setId("id2");
        assertThat(participacion1).isNotEqualTo(participacion2);
        participacion1.setId(null);
        assertThat(participacion1).isNotEqualTo(participacion2);
    }
}
