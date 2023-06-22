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

@Embeddable
public class EnderecoPaciente {

    @NotEmpty(message = "Estado não pode ser vazio")
    @Column(name = "estado")
    private String estado;

    @NotEmpty(message = "Cidade não pode ser vazio")
    @Column(name = "cidade")
    private String cidade;

    @NotEmpty(message = "Bairro não pode ser vazio")
    @Column(name = "bairro")
    private String bairro;

    @NotEmpty(message = "Rua não pode ser vazio")
    @Column(name = "rua")
    private String rua;

    @NotEmpty(message = "Numero não pode ser vazio")
    @Column(name = "numero")
    private String numero;
}