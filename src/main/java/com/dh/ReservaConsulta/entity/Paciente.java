package com.dh.ReservaConsulta.entity;

import com.dh.ReservaConsulta.entity.EnderecoPaciente;
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
@Table(name = "TB_PACIENTES")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Nome não pode ser vazio")
    @Column(name = "nome")
    private String nome;

    @NotEmpty(message = "sobrenome não pode ser vazio")
    @Column(name = "sobrenome")
    private String sobrenome;

    @Embedded
    private EnderecoPaciente endereco;

    @NotEmpty(message = "Rg não pode ser vazio")
    @Column(name = "registroGeral")
    private String rg;

    @NotEmpty(message = "Data da alta do paciente não pode ser vazio")
    @Column(name = "dataAlta")
    private String dataAlta;
}
