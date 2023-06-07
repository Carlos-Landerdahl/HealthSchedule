package com.dh.ReservaConsulta.controller;

import com.dh.ReservaConsulta.dto.request.DentistaRequestDTO;
import com.dh.ReservaConsulta.dto.response.DentistaResponseDTO;
import com.dh.ReservaConsulta.model.Dentista;
import com.dh.ReservaConsulta.model.Paciente;
import com.dh.ReservaConsulta.service.DentistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    private DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping
    public ResponseEntity<DentistaResponseDTO> salvar(@RequestBody DentistaRequestDTO dentista) throws SQLException {
        DentistaResponseDTO response = dentistaService.salvar(dentista);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Dentista>> buscarTodos() throws SQLException {
        return ResponseEntity.ok().body(dentistaService.buscarTodos());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) throws SQLException{
        dentistaService.excluir(id);
        return ResponseEntity.accepted().build();

    }

}
