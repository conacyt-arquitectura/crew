package mx.conacyt.crip.crew.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AsuntoMapperTest {
    private AsuntoMapper asuntoMapper;

    @BeforeEach
    public void setUp() {
        asuntoMapper = new AsuntoMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(asuntoMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(asuntoMapper.fromId(null)).isNull();
    }
}
