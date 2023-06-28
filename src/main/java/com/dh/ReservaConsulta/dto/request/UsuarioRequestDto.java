package com.dh.ReservaConsulta.dto.request;

import com.dh.ReservaConsulta.security.UsuarioRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioRequestDto {
    private String login;
    private String senha;
    private UsuarioRole usuarioRole;
}
