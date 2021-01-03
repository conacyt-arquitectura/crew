package mx.conacyt.crip.crew.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CelulaMapperTest {

    private CelulaMapper celulaMapper;

    @BeforeEach
    public void setUp() {
        celulaMapper = new CelulaMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(celulaMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(celulaMapper.fromId(null)).isNull();
    }
}
