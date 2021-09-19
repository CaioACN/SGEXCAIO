package com.sgex.SGEX.service.mapper;

import com.sgex.SGEX.domain.Motivo;
import com.sgex.SGEX.service.dto.DropDownDTO;
import com.sgex.SGEX.service.dto.MotivoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = EventosMapper.class)
public interface MotivoMapper extends EntityMapper<MotivoDTO, Motivo> {

    @Mapping(source ="id", target = "value")
    @Mapping(source = "nome", target = "label")
    MotivoDTO toDto(Motivo motivo);

    @InheritInverseConfiguration
    Motivo toEntity(DropDownDTO dropDownDTOTO);

}
