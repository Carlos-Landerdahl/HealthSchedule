package com.dh.ReservaConsulta.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Dentista {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String matricula;
}
