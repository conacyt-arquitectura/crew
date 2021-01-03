package mx.conacyt.crip.crew.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ProyectoMapperTest {

    private ProyectoMapper proyectoMapper;

    @BeforeEach
    public void setUp() {
        proyectoMapper = new ProyectoMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(proyectoMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(proyectoMapper.fromId(null)).isNull();
    }
}
