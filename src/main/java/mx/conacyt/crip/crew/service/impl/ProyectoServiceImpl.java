package mx.conacyt.crip.crew.service.impl;

import mx.conacyt.crip.crew.service.ProyectoService;
import mx.conacyt.crip.crew.domain.Proyecto;
import mx.conacyt.crip.crew.repository.ProyectoRepository;
import mx.conacyt.crip.crew.service.dto.ProyectoDTO;
import mx.conacyt.crip.crew.service.mapper.ProyectoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Proyecto}.
 */
@Service
public class ProyectoServiceImpl implements ProyectoService {

    private final Logger log = LoggerFactory.getLogger(ProyectoServiceImpl.class);

    private final ProyectoRepository proyectoRepository;

    private final ProyectoMapper proyectoMapper;

    public ProyectoServiceImpl(ProyectoRepository proyectoRepository, ProyectoMapper proyectoMapper) {
        this.proyectoRepository = proyectoRepository;
        this.proyectoMapper = proyectoMapper;
    }

    @Override
    public ProyectoDTO save(ProyectoDTO proyectoDTO) {
        log.debug("Request to save Proyecto : {}", proyectoDTO);
        Proyecto proyecto = proyectoMapper.toEntity(proyectoDTO);
        proyecto = proyectoRepository.save(proyecto);
        return proyectoMapper.toDto(proyecto);
    }

    @Override
    public Page<ProyectoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Proyectos");
        return proyectoRepository.findAll(pageable)
            .map(proyectoMapper::toDto);
    }


    @Override
    public Optional<ProyectoDTO> findOne(String id) {
        log.debug("Request to get Proyecto : {}", id);
        return proyectoRepository.findById(id)
            .map(proyectoMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Proyecto : {}", id);
        proyectoRepository.deleteById(id);
    }
}
