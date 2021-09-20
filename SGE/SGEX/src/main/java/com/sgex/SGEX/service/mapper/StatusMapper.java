package com.sgex.SGEX.service.mapper;

import com.sgex.SGEX.domain.Status;
import com.sgex.SGEX.service.dto.DropDownDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface StatusMapper extends EntityMapper<DropDownDTO, Status> {

    @Mapping(source ="id", target = "value")
    @Mapping(source = "descricao", target = "label")
    DropDownDTO toDto(Status status);

    @InheritInverseConfiguration
    Status toEntity(DropDownDTO dropDownDTOTO);
}
