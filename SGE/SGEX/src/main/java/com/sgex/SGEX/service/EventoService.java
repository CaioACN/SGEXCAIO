package com.sgex.SGEX.service;


import com.sgex.SGEX.domain.Evento;
import com.sgex.SGEX.repository.EventoRepository;
import com.sgex.SGEX.service.dto.EventoDTO;
import com.sgex.SGEX.service.error.ObjectNotFound;
import com.sgex.SGEX.service.mapper.EventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository repository;
    private final EventoMapper mapper;

    public Page<EventoDTO> findAllPaged(PageRequest pageRequest) {
        Page<Evento> page = repository.findAll(pageRequest);
        return page.map(mapper::toDto);
    }

    public EventoDTO findById(Long id) {
        Optional<Evento> obj = repository.findById(id);
        Evento entity = obj.orElseThrow(() -> new ObjectNotFound("Evento não encontrado"));
        return mapper.toDto(entity);
    }

    public EventoDTO insert(EventoDTO dto) {
        Evento entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ObjectNotFound("Evento com o id: " + id + "não encontrado.");
        }
    }
}




