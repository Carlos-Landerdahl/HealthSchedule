package com.dh.ReservaConsulta.controller;

import com.dh.ReservaConsulta.model.Dentista;
import com.dh.ReservaConsulta.service.DentistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;

    @PostMapping
    public Dentista salvar(@RequestBody Dentista dentista) throws SQLException {
        return dentistaService.salvar(dentista);
    }

    @GetMapping("/buscar")
    public List<Dentista> buscarTodos() throws SQLException {
        return dentistaService.buscarTodos();
    }

    @DeleteMapping("/deletar/{id}")
    public void excluir(@PathVariable int id) throws SQLException{
        dentistaService.excluir(id);
    }

}
