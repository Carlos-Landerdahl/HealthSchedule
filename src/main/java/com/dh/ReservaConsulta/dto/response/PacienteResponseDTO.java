package com.dh.ReservaConsulta.dto.response;

import com.dh.ReservaConsulta.entity.EnderecoPaciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteResponseDTO {
    private String nome;
    private String sobrenome;
    private EnderecoPaciente endereco;
    private String rg;
    private String dataAlta;
}
