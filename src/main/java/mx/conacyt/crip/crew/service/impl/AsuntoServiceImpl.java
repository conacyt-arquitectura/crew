package mx.conacyt.crip.crew.service.impl;

import java.util.Optional;
import mx.conacyt.crip.crew.domain.Asunto;
import mx.conacyt.crip.crew.repository.AsuntoRepository;
import mx.conacyt.crip.crew.service.AsuntoService;
import mx.conacyt.crip.crew.service.dto.AsuntoDTO;
import mx.conacyt.crip.crew.service.mapper.AsuntoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing {@link Asunto}.
 */
@Service
public class AsuntoServiceImpl implements AsuntoService {
    private final Logger log = LoggerFactory.getLogger(AsuntoServiceImpl.class);

    private final AsuntoRepository AsuntoRepository;

    private final AsuntoMapper AsuntoMapper;

    public AsuntoServiceImpl(AsuntoRepository AsuntoRepository, AsuntoMapper AsuntoMapper) {
        this.AsuntoRepository = AsuntoRepository;
        this.AsuntoMapper = AsuntoMapper;
    }

    @Override
    public AsuntoDTO save(AsuntoDTO AsuntoDTO) {
        log.debug("Request to save Asunto : {}", AsuntoDTO);
        Asunto Asunto = AsuntoMapper.toEntity(AsuntoDTO);
        Asunto = AsuntoRepository.save(Asunto);
        return AsuntoMapper.toDto(Asunto);
    }

    @Override
    public Page<AsuntoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Asuntos");
        return AsuntoRepository.findAll(pageable).map(AsuntoMapper::toDto);
    }

    @Override
    public Optional<AsuntoDTO> findOne(String id) {
        log.debug("Request to get Asunto : {}", id);
        return AsuntoRepository.findById(id).map(AsuntoMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Asunto : {}", id);
        AsuntoRepository.deleteById(id);
    }
}
