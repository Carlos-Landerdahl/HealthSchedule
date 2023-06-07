package com.dh.ReservaConsulta.controller;

import com.dh.ReservaConsulta.dao.IPaciente;
import com.dh.ReservaConsulta.dto.request.PacienteRequestDTO;
import com.dh.ReservaConsulta.dto.response.PacienteResponseDTO;
import com.dh.ReservaConsulta.model.Paciente;
import com.dh.ReservaConsulta.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

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
        PacienteResponseDTO response = pacienteService.salvar(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Paciente>> buscarTodos() throws SQLException {
        return ResponseEntity.ok().body(pacienteService.buscarTodos());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) throws SQLException{
        pacienteService.excluir(id);
        return ResponseEntity.accepted().build();
    }

}
