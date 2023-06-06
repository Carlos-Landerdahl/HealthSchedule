package com.dh.ReservaConsulta.controller;

import com.dh.ReservaConsulta.model.Paciente;
import com.dh.ReservaConsulta.service.PacienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public Paciente salvar(@RequestBody Paciente paciente) throws SQLException {
        return pacienteService.salvar(paciente);
    }

    @GetMapping("/buscar")
    public List<Paciente> buscarTodos() throws SQLException {
        return pacienteService.buscarTodos();
    }

    @DeleteMapping("/deletar/{id}")
    public void excluir(@PathVariable int id) throws SQLException{
        pacienteService.excluir(id);
    }

}
