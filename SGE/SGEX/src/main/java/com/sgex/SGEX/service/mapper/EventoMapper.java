package com.sgex.SGEX.service.mapper;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sgex.SGEX.domain.Evento;
import com.sgex.SGEX.service.dto.EventoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@JsonFormat(pattern = "dd/mm/yyyy")
@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, StatusMapper.class,MotivoMapper.class})
public interface EventoMapper extends  EntityMapper<EventoDTO, Evento> {


}
