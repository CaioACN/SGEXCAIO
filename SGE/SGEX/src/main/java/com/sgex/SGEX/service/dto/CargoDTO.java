package com.sgex.SGEX.service.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CargoDTO implements Serializable {

    private Long id;
    private String descricao;
}
