package com.sgex.SGEX.service.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ListaEventoDTO implements Serializable {

    private Long id;
    private String titulo;
    private String descricao;

}
