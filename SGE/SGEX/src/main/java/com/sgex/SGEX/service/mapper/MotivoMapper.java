package com.sgex.SGEX.service.mapper;

import com.sgex.SGEX.domain.Motivo;
import com.sgex.SGEX.service.dto.MotivoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses ={})
public interface MotivoMapper extends EntityMapper<MotivoDTO, Motivo> {



}
