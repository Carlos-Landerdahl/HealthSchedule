package com.dh.ReservaConsulta.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistaResponseDTO {
    private String nome;
    private String sobrenome;
    private String matricula;
}
