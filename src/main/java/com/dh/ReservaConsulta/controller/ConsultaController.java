package com.dh.ReservaConsulta.controller;

import com.dh.ReservaConsulta.entity.Consulta;
import com.dh.ReservaConsulta.exception.InvalidDataException;
import com.dh.ReservaConsulta.exception.ResourceNotFoundException;
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

    @PostMapping("/admin")
    public ResponseEntity<Consulta> salvar(@RequestBody Consulta consulta) throws InvalidDataException {
        Consulta novaConsulta = consultaService.salvar(consulta);
        if(novaConsulta != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(novaConsulta);
        }else{
            throw new InvalidDataException("Informe todos os dados da consulta");
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Consulta>> buscarTodos() throws InvalidDataException {
        List<Consulta> consultaList = consultaService.buscarTodos();
        if(!consultaList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(consultaList);
        }else{
            throw new InvalidDataException("Nenhum registro encontrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizar(@PathVariable int id, @RequestBody Consulta consultaAtualizada) throws InvalidDataException, ResourceNotFoundException {
        Consulta consulta = consultaService.atualizar(id, consultaAtualizada);
        if (consulta != null) {
            return ResponseEntity.status(HttpStatus.OK).body(consulta);
        } else {
            throw new InvalidDataException("Não foi possível atualizar a consulta, verifique se todos os dados estão corretos");
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Consulta>> buscarPorIdConsulta(@PathVariable int id) throws ResourceNotFoundException {
        Optional<Consulta> consulta = consultaService.buscarPorIdConsulta(id);
        if (consulta.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(consulta);
        }else {
            throw new ResourceNotFoundException("O identificador não pertence a nenhuma consulta");
        }
    }

    @GetMapping("/dentista/{dentistaId}")
    public ResponseEntity<List<Consulta>> listarConsultasPorDentista(@PathVariable int dentistaId) throws ResourceNotFoundException {
        List<Consulta> consultaList = consultaService.listarConsultasPorDentista(dentistaId);
        if(!consultaList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(consultaList);
        }else{
            throw new ResourceNotFoundException("O identificador não pertence a nenhum dentista");
        }
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Consulta>> listarConsultasPorPaciente(@PathVariable int pacienteId) throws ResourceNotFoundException {
        List<Consulta> consultaList = consultaService.listarConsultasPorPaciente(pacienteId);
        if(!consultaList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(consultaList);
        }else{
            throw new ResourceNotFoundException("O identificador não pertence a nenhum paciente");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) throws ResourceNotFoundException {
        try {
            consultaService.excluir(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("O identificador não pertence a nenhuma consulta");
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
