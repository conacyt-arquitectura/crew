package mx.conacyt.crip.crew.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ParticipacionMapperTest {

    private ParticipacionMapper participacionMapper;

    @BeforeEach
    public void setUp() {
        participacionMapper = new ParticipacionMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(participacionMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(participacionMapper.fromId(null)).isNull();
    }
}
