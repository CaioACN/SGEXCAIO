package com.sgex.SGEX.service.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sgex.SGEX.domain.Usuario;

import com.sgex.SGEX.service.dto.UsuarioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@JsonFormat(pattern = "dd/mm/yyyy")
@Mapper(componentModel = "spring", uses = {CargoMapper.class, EventosMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {

    @Mapping(source ="id", target = "value")
    @Mapping(source = "nome", target = "label")
    UsuarioDTO toDto(Usuario usuario);

    @InheritInverseConfiguration
    Usuario toEntity(UsuarioDTO usuarioDTO);
}
