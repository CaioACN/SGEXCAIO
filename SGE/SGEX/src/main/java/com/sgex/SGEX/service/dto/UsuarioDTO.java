package com.sgex.SGEX.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sgex.SGEX.domain.Cargo;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;
    private Byte [] foto;
    private  int cpf;
    private Cargo cargo;


    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(columnDefinition = "datanascimento")
    private LocalDateTime dataNascimento;
}
