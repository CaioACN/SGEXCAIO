package com.sgex.SGEX.service;

import com.sgex.SGEX.domain.Eventos;
import com.sgex.SGEX.repository.EventosRepository;
import com.sgex.SGEX.service.dto.EventosDTO;
import com.sgex.SGEX.service.error.EventosNaoEcontradoException;
import com.sgex.SGEX.service.mapper.EventosMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventosService {

    private final EventosRepository repository;
    private final EventosMapper mapper;

    @Transactional
    public Page<EventosDTO> findAllPaged(PageRequest pageRequest) {
        Page<Eventos> page = repository.findAll(pageRequest);
        return page.map(mapper::toDto);
    }

    @Transactional
    public EventosDTO findById(Long id) {
        Optional<Eventos> objeto = repository.findById(id);
        Eventos entity = objeto.orElseThrow(() -> new EventosNaoEcontradoException("Evento não encontrado"));
        return mapper.toDto(entity);
    }

    @Transactional
    public EventosDTO insert(EventosDTO dto) {
        Eventos entity = mapper.toDto(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException resultDataAccessException) {
            throw new EventosNaoEcontradoException("Evento do ID: " + id + "não encontrado.");
        }
    }
}







