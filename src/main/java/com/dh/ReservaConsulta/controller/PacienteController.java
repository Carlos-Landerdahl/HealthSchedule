package com.dh.ReservaConsulta.controller;

import com.dh.ReservaConsulta.model.Paciente;
import com.dh.ReservaConsulta.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteServiceImpl pacienteService;

    @GetMapping
    public Paciente salvar(@RequestParam(value = "id") Integer id,
                           @RequestParam(value = "nome") String nome,
                           @RequestParam(value = "sobrenome") String sobrenome,
                           @RequestParam(value = "endereco") String endereco,
                           @RequestParam(value = "rg") String rg,
                           @RequestParam(value = "dataAlta") String dataAlta) {
        return pacienteService.salvar(new Paciente(id, nome, sobrenome, endereco, rg, dataAlta));
    }

    @GetMapping("/buscar")
    public List<Paciente> buscarTodos() {
        return pacienteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public String excluir(@PathVariable Integer id) {
        return pacienteService.excluir(id);
    }

}
