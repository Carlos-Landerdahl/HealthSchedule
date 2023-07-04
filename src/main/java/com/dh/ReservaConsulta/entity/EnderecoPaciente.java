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

@Embeddable
public class EnderecoPaciente {

    @NotBlank(message = "Estado não pode ser vazio")
    @Column(name = "estado")
    private String estado;

    @NotBlank(message = "Cidade não pode ser vazio")
    @Column(name = "cidade")
    private String cidade;

    @NotBlank(message = "Bairro não pode ser vazio")
    @Column(name = "bairro")
    private String bairro;

    @NotBlank(message = "Rua não pode ser vazio")
    @Column(name = "rua")
    private String rua;

    @NotBlank(message = "Numero não pode ser vazio")
    @Column(name = "numero")
    private String numero;
}