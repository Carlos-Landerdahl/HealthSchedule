package com.dh.ReservaConsulta.controller;

import com.dh.ReservaConsulta.dto.request.PacienteRequestDTO;
import com.dh.ReservaConsulta.dto.response.DentistaResponseDTO;
import com.dh.ReservaConsulta.dto.response.PacienteResponseDTO;
import com.dh.ReservaConsulta.entity.Paciente;
import com.dh.ReservaConsulta.exception.InvalidDataException;
import com.dh.ReservaConsulta.exception.ResourceNotFoundException;
import com.dh.ReservaConsulta.service.impl.PacienteService;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> salvar(@RequestBody PacienteRequestDTO paciente) throws SQLException, InvalidDataException {
        try {
            PacienteResponseDTO response = pacienteService.salvar(paciente);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            throw new InvalidDataException("Informe todos os dados do paciente");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizar(@PathVariable int id, @RequestBody PacienteRequestDTO pacienteAtualizado) throws SQLException, InvalidDataException {
        try {
            PacienteResponseDTO dentista = pacienteService.atualizar(id, pacienteAtualizado);
            return ResponseEntity.status(HttpStatus.OK).body(dentista);
        } catch (Exception e) {
            throw new InvalidDataException("Informe todos os dados do paciente");
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Paciente>> buscarTodos() throws SQLException, InvalidDataException {
        List<Paciente> pacienteList = pacienteService.buscarTodos();
        if (!pacienteList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(pacienteList);
        } else {
            throw new InvalidDataException("Nenhum registro encontrado");
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Paciente>> buscarPorId(@PathVariable int id) throws SQLException, ResourceNotFoundException {
        Optional<Paciente> paciente = pacienteService.buscarPorId(id);
        if (paciente.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(paciente);
        } else {
            throw new ResourceNotFoundException("O identificador não pertence a nenhum paciente");
        }
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<Optional<Paciente>> bsucarPorNome(@PathVariable String nome) throws SQLException, ResourceNotFoundException {
        Optional<Paciente> paciente = pacienteService.buscarPorNome(nome);
        if (paciente.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(paciente);
        } else {
            throw new ResourceNotFoundException("Nome não encontrado nos registros");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) throws SQLException, InvalidDataException {
        Optional<Paciente> paciente = pacienteService.buscarPorId(id);
        if(paciente.isPresent()){
        pacienteService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            throw new InvalidDataException("O identificador não pertence a nenhum paciente");
        }
    }

    // Exception handling methods
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> processarErroBadRequest(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler({InvalidDataException.class})
    public ResponseEntity<String> processarNotFound(InvalidDataException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
