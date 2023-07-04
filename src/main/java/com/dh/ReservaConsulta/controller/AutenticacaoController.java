package com.dh.ReservaConsulta.controller;


import com.dh.ReservaConsulta.dto.request.UsuarioLoginDto;
import com.dh.ReservaConsulta.dto.request.UsuarioRequestDto;
import com.dh.ReservaConsulta.dto.response.UsuarioResponseDto;
import com.dh.ReservaConsulta.entity.Usuario;
import com.dh.ReservaConsulta.exception.InvalidDataException;
import com.dh.ReservaConsulta.exception.ResourceNotFoundException;
import com.dh.ReservaConsulta.security.TokenDto;
import com.dh.ReservaConsulta.security.TokenService;
import com.dh.ReservaConsulta.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity logar(@RequestBody @Valid UsuarioLoginDto usuarioLoginDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(usuarioLoginDto.getNome(), usuarioLoginDto.getSenha());
        Authentication authenticate = manager.authenticate(authenticationToken);
        String tokenJwt = tokenService.gerarToken((Usuario) authenticate.getPrincipal());

        return ResponseEntity.ok(new TokenDto(tokenJwt));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponseDto> cadastrar(@RequestBody @Valid UsuarioRequestDto usuarioRequestDto) throws InvalidDataException {
        UsuarioResponseDto novoUsuario = usuarioService.salvar(usuarioRequestDto);
        if(novoUsuario != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } else {
            throw new InvalidDataException("Informe todos os dados do usuário");
        }
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> processarErroBadRequest(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler({InvalidDataException.class})
    public ResponseEntity<String> processarNotFound(InvalidDataException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
