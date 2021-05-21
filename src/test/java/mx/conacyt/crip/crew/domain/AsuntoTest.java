package mx.conacyt.crip.crew.domain;

import static org.assertj.core.api.Assertions.assertThat;

import mx.conacyt.crip.crew.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

public class AsuntoTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Asunto.class);
        Asunto asunto1 = new Asunto();
        asunto1.setId("id1");
        Asunto asunto2 = new Asunto();
        asunto2.setId(asunto1.getId());
        assertThat(asunto1).isEqualTo(asunto2);
        asunto2.setId("id2");
        assertThat(asunto1).isNotEqualTo(asunto2);
        asunto1.setId(null);
        assertThat(asunto1).isNotEqualTo(asunto2);
    }
}
