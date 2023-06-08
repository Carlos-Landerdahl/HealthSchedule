package com.dh.ReservaConsulta.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Paciente {
    private int id;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String rg;
    private String dataAlta;
}
