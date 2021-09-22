package com.sgex.SGEX.service.mapper;

import com.sgex.SGEX.domain.Cargo;
import com.sgex.SGEX.service.dto.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses ={})
public interface CargoMapper extends  EntityMapper<SelectDTO, Cargo> {

    @Mapping(source ="id", target = "value")
    @Mapping(source = "descricao", target = "label")
    SelectDTO toDto(Cargo cargo);

    @InheritInverseConfiguration
    Cargo toEntity(SelectDTO selectDTO);


}
