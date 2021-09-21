package com.sgex.SGEX.service.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ListaUsuarioDTO implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private SelectDTO cargo;
    private String status;
}
