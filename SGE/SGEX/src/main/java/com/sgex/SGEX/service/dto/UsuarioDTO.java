package com.sgex.SGEX.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sgex.SGEX.domain.Cargo;
import com.sgex.SGEX.domain.Evento;
import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class UsuarioDTO implements Serializable {

    private Long id;
    private String nome;
    private String email;

    private  Integer cpf;

    private SelectDTO cargo;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(columnDefinition = "datanascimento")
    private LocalDateTime dataNascimento;
}
