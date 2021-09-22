package com.sgex.SGEX.service;

import com.sgex.SGEX.domain.Usuario;
import com.sgex.SGEX.repository.UsuarioRepository;
import com.sgex.SGEX.service.dto.UsuarioDTO;
import com.sgex.SGEX.service.error.ObjectNotFound;
import com.sgex.SGEX.service.mapper.UsuarioMapper;
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
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public Page<UsuarioDTO> findAllPaged(PageRequest pageRequest){
        Page<Usuario> page = repository.findAll(pageRequest);
        return page.map(mapper::toDto);
    }
    public UsuarioDTO findById (Long id){
        Optional<Usuario> obj = repository.findById(id);
        Usuario entity = obj.orElseThrow(() -> new ObjectNotFound("Usuario não encontrado."));
        return mapper.toDto(entity);
    }
    public  UsuarioDTO insert(UsuarioDTO dto){
        Usuario entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }
    public void delete(Long id) {
        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw  new ObjectNotFound("Usuario com o id: "+ id + "não foi encontrado.");

        }
    }

}




