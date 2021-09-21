package com.sgex.SGEX.service.mapper;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sgex.SGEX.domain.Usuario;
import com.sgex.SGEX.service.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@JsonFormat(pattern = "dd/mm/yyyy")
@Mapper(componentModel = "spring", uses = {CargoMapper.class, EventoMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {


}
