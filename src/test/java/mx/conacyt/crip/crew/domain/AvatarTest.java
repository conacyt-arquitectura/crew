package mx.conacyt.crip.crew.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import mx.conacyt.crip.crew.web.rest.TestUtil;

public class AvatarTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Avatar.class);
        Avatar avatar1 = new Avatar();
        avatar1.setId("id1");
        Avatar avatar2 = new Avatar();
        avatar2.setId(avatar1.getId());
        assertThat(avatar1).isEqualTo(avatar2);
        avatar2.setId("id2");
        assertThat(avatar1).isNotEqualTo(avatar2);
        avatar1.setId(null);
        assertThat(avatar1).isNotEqualTo(avatar2);
    }
}
