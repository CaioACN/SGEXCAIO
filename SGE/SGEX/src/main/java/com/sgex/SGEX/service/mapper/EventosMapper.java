package com.sgex.SGEX.service.mapper;


import com.sgex.SGEX.domain.Eventos;
import com.sgex.SGEX.service.dto.DropDownDTO;
import com.sgex.SGEX.service.dto.EventosDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@JsonFormat(pattern = "dd/mm/yyyy")
@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, StatusMapper.class,MotivoMapper.class})
public interface EventosMapper extends  EntityMapper<DropDownDTO, Eventos> {

    @Mapping(source ="id", target = "value")
    @Mapping(source = "patrocinador", target = "label")
    DropDownDTO toDto(EventosDTO eventosDTO);

    @InheritInverseConfiguration
    Eventos toEntity(DropDownDTO dropDownDTOTO);


}
