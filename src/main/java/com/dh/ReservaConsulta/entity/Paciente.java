package com.dh.ReservaConsulta.entity;

import com.dh.ReservaConsulta.entity.EnderecoPaciente;
import lombok.*;

import javax.persistence.*;

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

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Embedded
    private EnderecoPaciente endereco;

    @Column(name = "registroGeral")
    private String rg;

    @Column(name = "dataAlta")
    private String dataAlta;
}
