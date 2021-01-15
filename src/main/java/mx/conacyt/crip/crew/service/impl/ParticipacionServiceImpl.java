package mx.conacyt.crip.crew.service.impl;

import java.util.Optional;
import mx.conacyt.crip.crew.domain.Participacion;
import mx.conacyt.crip.crew.repository.ParticipacionRepository;
import mx.conacyt.crip.crew.service.ParticipacionService;
import mx.conacyt.crip.crew.service.dto.ParticipacionDTO;
import mx.conacyt.crip.crew.service.mapper.ParticipacionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing {@link Participacion}.
 */
@Service
public class ParticipacionServiceImpl implements ParticipacionService {
    private final Logger log = LoggerFactory.getLogger(ParticipacionServiceImpl.class);

    private final ParticipacionRepository participacionRepository;

    private final ParticipacionMapper participacionMapper;

    public ParticipacionServiceImpl(ParticipacionRepository participacionRepository, ParticipacionMapper participacionMapper) {
        this.participacionRepository = participacionRepository;
        this.participacionMapper = participacionMapper;
    }

    @Override
    public ParticipacionDTO save(ParticipacionDTO participacionDTO) {
        log.debug("Request to save Participacion : {}", participacionDTO);
        Participacion participacion = participacionMapper.toEntity(participacionDTO);
        participacion = participacionRepository.save(participacion);
        return participacionMapper.toDto(participacion);
    }

    @Override
    public Page<ParticipacionDTO> findAll(String celulaId, Pageable pageable) {
        log.debug("Request to get all Participacions");
        return participacionRepository.findAllByCelula(celulaId, pageable).map(participacionMapper::toDto);
    }

    @Override
    public Optional<ParticipacionDTO> findOne(String id) {
        log.debug("Request to get Participacion : {}", id);
        return participacionRepository.findById(id).map(participacionMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Participacion : {}", id);
        participacionRepository.deleteById(id);
    }
}
