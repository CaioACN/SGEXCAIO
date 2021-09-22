package com.sgex.SGEX.service.mapper;

import com.sgex.SGEX.domain.Status;
import com.sgex.SGEX.service.dto.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface StatusMapper extends EntityMapper<SelectDTO, Status> {

    @Mapping(source ="id", target = "value")
    @Mapping(source = "descricao", target = "label")
    SelectDTO toDto(Status status);

    @InheritInverseConfiguration
    Status toEntity(SelectDTO selectDTOTO);
}
