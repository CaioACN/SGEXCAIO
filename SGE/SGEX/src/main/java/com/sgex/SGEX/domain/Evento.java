package com.sgex.SGEX.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "eventos")
@Getter
@Setter


public class Evento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(columnDefinition = "datadoevento")
    private LocalDateTime datadoevento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_motivo")
    private Motivo motivo;

    @Column(name = "justificativa")
    private String justificativa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_status")
    private Status status;

    @Column(name = "patrocinador")
    private  String patrocinador;

    @ManyToMany
    @JoinTable(name="usuario_eventos", joinColumns =  {
            @JoinColumn(name="id_usuario")
    }, inverseJoinColumns = {
            @JoinColumn(name="id_eventos")
    })
    private List<Usuario> listaEvento;




}
