package com.sgex.SGEX.service.dto;


import com.sgex.SGEX.domain.Motivo;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MotivoDTO implements Serializable {

    private Long id;
    private String descricao;
    private String titulo;
    private List<Motivo>listaMotivo;

}
