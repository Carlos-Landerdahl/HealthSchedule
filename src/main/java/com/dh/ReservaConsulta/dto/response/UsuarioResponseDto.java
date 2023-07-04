package com.dh.ReservaConsulta.dto.response;

import com.dh.ReservaConsulta.security.UsuarioRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioResponseDto {
    private Long id;
    private String nome;
    private String senha;
    private UsuarioRole role;

}
