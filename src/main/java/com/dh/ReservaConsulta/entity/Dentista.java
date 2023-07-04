package com.dh.ReservaConsulta.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "Nome não pode ser vazio")
    @Column(name = "nome")
    private String nome;

    @NotBlank(message = "Sobrenome não pode ser vazio")
    @Column(name = "sobrenome")
    private String sobrenome;

    @NotBlank(message = "Matricula não pode ser vazia")
    @Column(name = "matricula")
    private String matricula;
}
