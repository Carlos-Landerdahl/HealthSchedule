package com.dh.ReservaConsulta.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Entity
@Table(name = "TB_CONSULTAS")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "dentista_id")
    @NotEmpty(message = "Dentista não pode ser vazio")
    private Dentista dentista;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @NotEmpty(message = "Paciente não pode ser vazio")
    private Paciente paciente;

    @NotEmpty(message = "Data da consulta não pode ser vazio")
    @Column(name = "data_consulta")
    private LocalDate dataConsulta;

    @NotEmpty(message = "Hora da consulta não pode ser vazio")
    @Column(name = "hora_consulta")
    private LocalTime horaConsulta;
}
