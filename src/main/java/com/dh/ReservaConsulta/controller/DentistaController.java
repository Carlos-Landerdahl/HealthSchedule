package com.dh.ReservaConsulta.controller;

import com.dh.ReservaConsulta.dto.request.DentistaRequestDTO;
import com.dh.ReservaConsulta.dto.response.DentistaResponseDTO;
import com.dh.ReservaConsulta.entity.Dentista;
import com.dh.ReservaConsulta.exception.InvalidDataException;
import com.dh.ReservaConsulta.exception.ResourceNotFoundException;
import com.dh.ReservaConsulta.service.impl.DentistaService;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;

    @PostMapping("/admin")
    public ResponseEntity<DentistaResponseDTO> salvar(@RequestBody DentistaRequestDTO dentista) throws SQLException, InvalidDataException {
        try{
            DentistaResponseDTO response = dentistaService.salvar(dentista);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch(Exception e){
            throw new InvalidDataException("Informe todos os dados do dentista");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DentistaResponseDTO> atualizar(@PathVariable int id, @RequestBody DentistaRequestDTO dentistaAtualizado) throws SQLException,InvalidDataException {
        try {
            DentistaResponseDTO dentista = dentistaService.atualizar(id, dentistaAtualizado);
            return ResponseEntity.status(HttpStatus.OK).body(dentista);
        } catch (Exception e) {
          throw new InvalidDataException("Informe todos os dados do dentista");
        }
    }


    @GetMapping("/buscar")
    public ResponseEntity<List<Dentista>> buscarTodos() throws SQLException, InvalidDataException {
        List<Dentista> dentistaList = dentistaService.buscarTodos();
        if(!dentistaList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(dentistaList);
        }else{
         throw new InvalidDataException("Nenhum registro encontrado");
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Dentista>> buscarPorId(@PathVariable int id) throws SQLException, ResourceNotFoundException {
        Optional<Dentista> dentista = dentistaService.buscarPorId(id);
        if (dentista.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(dentista);
        }else {
            throw new ResourceNotFoundException("O identificador não pertence a nenhum dentista");
        }
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<Optional<Dentista>> buscarPorNome(@PathVariable String nome) throws ResourceNotFoundException, SQLException {
        Optional<Dentista> dentista = dentistaService.buscarPorNome(nome);

        if (dentista.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(dentista);
        } else {
            throw new ResourceNotFoundException("Nome não encontrado nos registros");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) throws SQLException, ResourceNotFoundException {
        try{
        dentistaService.excluir(id);
        return ResponseEntity.accepted().build();
        } catch(Exception e) {
            throw new ResourceNotFoundException("O identificador não pertence a nenhum dentista");
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
