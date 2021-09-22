package com.sgex.SGEX.domain;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter


public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private  Integer cpf;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(columnDefinition = "datanascimento")
    private LocalDateTime datanascimento;

    @Column(name = "status")
    private  String status;

    @ManyToMany
    @JoinTable(name="eventos_usuario", joinColumns =  {
            @JoinColumn(name="id_usuario")
    }, inverseJoinColumns = {
            @JoinColumn(name="id_eventos")
    })
    private List<Evento> listaEvento;
}
