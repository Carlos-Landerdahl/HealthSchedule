package com.dh.ReservaConsulta.controller;

import com.dh.ReservaConsulta.entity.Consulta;
import com.dh.ReservaConsulta.service.impl.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> salvar(@RequestBody Consulta consulta) {
        Consulta novaConsulta = consultaService.salvar(consulta);
        if(novaConsulta != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(novaConsulta);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Consulta>> buscarTodos() {
        List<Consulta> consultaList = consultaService.buscarTodos();
        if(!consultaList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(consultaList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Consulta>> buscarPorIdConsulta(@PathVariable int id) {
        Optional<Consulta> consulta = consultaService.buscarPorIdConsulta(id);
        if (consulta.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(consulta);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/dentista/{dentistaId}")
    public ResponseEntity<List<Consulta>> listarConsultasPorDentista(@PathVariable int dentistaId) {
        List<Consulta> consultaList = consultaService.listarConsultasPorDentista(dentistaId);
        if(!consultaList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(consultaList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Consulta>> listarConsultasPorPaciente(@PathVariable int pacienteId) {
        List<Consulta> consultaList = consultaService.listarConsultasPorPaciente(pacienteId);
        if(!consultaList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(consultaList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        try {
            consultaService.excluir(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
