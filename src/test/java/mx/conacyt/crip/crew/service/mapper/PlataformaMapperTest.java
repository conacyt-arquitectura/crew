package mx.conacyt.crip.crew.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PlataformaMapperTest {

    private PlataformaMapper plataformaMapper;

    @BeforeEach
    public void setUp() {
        plataformaMapper = new PlataformaMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(plataformaMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(plataformaMapper.fromId(null)).isNull();
    }
}
