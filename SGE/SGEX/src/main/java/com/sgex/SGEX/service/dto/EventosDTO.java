package com.sgex.SGEX.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sgex.SGEX.domain.Motivo;
import com.sgex.SGEX.domain.Status;
import com.sgex.SGEX.domain.Usuario;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EventosDTO {

    private Long id;

    private Motivo motivo;
    private String justificativa;
    private Status status;
    private  String patrocinador;
    private List<Usuario> usuarios;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(columnDefinition = "datadoevento")
    private LocalDateTime dataDoEvento;
}
