package com.dh.ReservaConsulta.service.impl;

import com.dh.ReservaConsulta.dto.request.UsuarioRequestDto;
import com.dh.ReservaConsulta.dto.response.UsuarioResponseDto;
import com.dh.ReservaConsulta.entity.Usuario;
import com.dh.ReservaConsulta.repository.UsuarioRepository;
import com.dh.ReservaConsulta.service.IUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponseDto salvar(UsuarioRequestDto usuarioRequestDto) {
        ObjectMapper mapper = new ObjectMapper();
        Usuario usuarioModel = mapper.convertValue(usuarioRequestDto, Usuario.class);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCriptografada = encoder.encode(usuarioModel.getSenha());
        usuarioModel.setSenha(senhaCriptografada);
        Usuario usuarioSalvo = usuarioRepository.save(usuarioModel);
        UsuarioResponseDto usuarioResponseDto = mapper.convertValue(usuarioSalvo, UsuarioResponseDto.class);
        return usuarioResponseDto;
    }
}
