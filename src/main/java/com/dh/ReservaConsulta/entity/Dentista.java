package com.dh.ReservaConsulta.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Entity
@Table(name = "TB_DENTISTAS")
public class Dentista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Nome não pode ser vazio")
    @Column(name = "nome")
    private String nome;

    @NotEmpty(message = "Sobrenome não pode ser vazio")
    @Column(name = "sobrenome")
    private String sobrenome;

    @NotEmpty(message = "Matricula não pode ser vazia")
    @Column(name = "matricula")
    private String matricula;
}
