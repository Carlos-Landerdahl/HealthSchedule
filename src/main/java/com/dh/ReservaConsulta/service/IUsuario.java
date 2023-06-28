package com.dh.ReservaConsulta.service;

import com.dh.ReservaConsulta.dto.request.UsuarioRequestDto;
import com.dh.ReservaConsulta.dto.response.UsuarioResponseDto;

public interface IUsuario {
    UsuarioResponseDto salvar(UsuarioRequestDto usuarioRequestDto);
}
