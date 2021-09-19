package com.sgex.SGEX.service.mapper;

import com.sgex.SGEX.domain.Cargo;

import com.sgex.SGEX.service.dto.CargoDTO;
import com.sgex.SGEX.service.dto.DropDownDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = UsuarioMapper.class)
public interface CargoMapper extends  EntityMapper<CargoDTO, Cargo> {

    @Mapping(source ="id", target = "value")
    @Mapping(source = "descricao", target = "label")
    DropDownDTO toDto(Cargo cargo);

    @InheritInverseConfiguration
    Cargo toEntity(DropDownDTO dropDownDTOTO);


}
