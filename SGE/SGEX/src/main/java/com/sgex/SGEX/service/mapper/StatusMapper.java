package com.sgex.SGEX.service.mapper;

import com.sgex.SGEX.domain.Status;
import com.sgex.SGEX.service.dto.DropDownDTO;
import com.sgex.SGEX.service.dto.StatusDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface StatusMapper extends EntityMapper<StatusDTO, Status> {

    @Mapping(source ="id", target = "value")
    @Mapping(source = "descricao", target = "label")
    StatusDTO toDto(Status status);

    @InheritInverseConfiguration
    Status toEntity(DropDownDTO dropDownDTOTO);
}
