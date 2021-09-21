package com.sgex.SGEX.service;


import com.sgex.SGEX.domain.Motivo;
import com.sgex.SGEX.repository.MotivoRepository;
import com.sgex.SGEX.service.dto.MotivoDTO;
import com.sgex.SGEX.service.error.ObjectNotFound;
import com.sgex.SGEX.service.mapper.MotivoMapper;
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
public class MotivoService {

    private final MotivoRepository repository;
    private final MotivoMapper mapper;

    public MotivoDTO findById(Long id) {
        Optional<Motivo> obj = repository.findById(id);
        Motivo entity = obj.orElseThrow(() -> new ObjectNotFound("Evento não encontrado."));
        return mapper.toDto(entity);
    }
    public MotivoDTO insert(MotivoDTO dto){
        Motivo entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }
    public  void delete(Long id){
        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ObjectNotFound("Evento com o id: " + id + "não encontrado.");
        }
    }


    public Page<MotivoDTO> findAllPaged(PageRequest pageRequest) {
        Page<Motivo> page = repository.findAll(pageRequest);
        return page.map(mapper::toDto);
    }
}

