package com.dh.ReservaConsulta.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteRequestDTO {
    private String nome;
    private String sobrenome;
    private String endereco;
    private String rg;
    private String dataAlta;
}
