package com.sgex.SGEX.service.mapper;

import com.sgex.SGEX.domain.Motivo;
import com.sgex.SGEX.service.dto.DropDownDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = EventosMapper.class)
public interface MotivoMapper extends EntityMapper<DropDownDTO, Motivo> {

    @Mapping(source ="id", target = "value")
    @Mapping(source = "descricao", target = "label")
    DropDownDTO toDto(Motivo motivo);

    @InheritInverseConfiguration
    Motivo toEntity(DropDownDTO dropDownDTO);

}
