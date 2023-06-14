package com.dh.ReservaConsulta.controller;

import com.dh.ReservaConsulta.dto.request.DentistaRequestDTO;
import com.dh.ReservaConsulta.dto.response.DentistaResponseDTO;
import com.dh.ReservaConsulta.entity.Dentista;
import com.dh.ReservaConsulta.service.impl.DentistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;


    @PostMapping
    public ResponseEntity<DentistaResponseDTO> salvar(@RequestBody DentistaRequestDTO dentista) throws SQLException {

        if(dentista.getNome() != null && dentista.getSobrenome() != null && dentista.getMatricula() != null){
            DentistaResponseDTO response = dentistaService.salvar(dentista);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Dentista>> buscarTodos() throws SQLException {
        List<Dentista> dentistaList = dentistaService.buscarTodos();
        if(!dentistaList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(dentistaList);
        }else{
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Dentista>> buscarPorId(@PathVariable int id) throws SQLException {
        Optional<Dentista> dentista = dentistaService.buscarPorId(id);
        if (dentista.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(dentista);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<Optional<Dentista>> buscarPorNome(@PathVariable String nome) throws SQLException{
        Optional<Dentista> dentista = dentistaService.buscarPorNome(nome);
        if (dentista.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(dentista);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) throws SQLException{
        dentistaService.excluir(id);
        return ResponseEntity.accepted().build();
    }

}
