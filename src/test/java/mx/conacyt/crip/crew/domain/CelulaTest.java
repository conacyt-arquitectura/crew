package mx.conacyt.crip.crew.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import mx.conacyt.crip.crew.web.rest.TestUtil;

public class CelulaTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Celula.class);
        Celula celula1 = new Celula();
        celula1.setId("id1");
        Celula celula2 = new Celula();
        celula2.setId(celula1.getId());
        assertThat(celula1).isEqualTo(celula2);
        celula2.setId("id2");
        assertThat(celula1).isNotEqualTo(celula2);
        celula1.setId(null);
        assertThat(celula1).isNotEqualTo(celula2);
    }
}
