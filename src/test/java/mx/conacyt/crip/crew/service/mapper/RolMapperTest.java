package mx.conacyt.crip.crew.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RolMapperTest {

    private RolMapper rolMapper;

    @BeforeEach
    public void setUp() {
        rolMapper = new RolMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(rolMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(rolMapper.fromId(null)).isNull();
    }
}
