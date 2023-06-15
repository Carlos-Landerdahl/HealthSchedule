package com.dh.ReservaConsulta.controller;

import com.dh.ReservaConsulta.dto.request.PacienteRequestDTO;
import com.dh.ReservaConsulta.dto.response.DentistaResponseDTO;
import com.dh.ReservaConsulta.dto.response.PacienteResponseDTO;
import com.dh.ReservaConsulta.entity.Paciente;
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
    public ResponseEntity<PacienteResponseDTO> salvar(@RequestBody PacienteRequestDTO paciente) throws SQLException {
        if(paciente.getNome() != null){
            PacienteResponseDTO response = pacienteService.salvar(paciente);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizar(@PathVariable int id, @RequestBody PacienteRequestDTO pacienteAtualizado) throws SQLException{
        try{
            PacienteResponseDTO paciente = pacienteService.atualizar(id, pacienteAtualizado);
            return ResponseEntity.status(HttpStatus.OK).body(paciente);
        }catch(SQLException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch(JsonMappingException e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Paciente>> buscarTodos() throws SQLException {
        List<Paciente> pacienteList = pacienteService.buscarTodos();
        if (!pacienteList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(pacienteList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Paciente>> buscarPorId(@PathVariable int id)throws SQLException {
        Optional<Paciente> paciente = pacienteService.buscarPorId(id);
        if (paciente.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(paciente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<Optional<Paciente>> bsucarPorNome(@PathVariable String nome) throws SQLException{
        Optional<Paciente> paciente = pacienteService.buscarPorNome(nome);
        if (paciente.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(paciente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) throws SQLException{
        Optional<Paciente> paciente = pacienteService.buscarPorId(id);
        if(paciente.isPresent()){
        pacienteService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
