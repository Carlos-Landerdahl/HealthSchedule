package com.dh.ReservaConsulta.service.impl;

import com.dh.ReservaConsulta.repository.DentistaRepository;
import com.dh.ReservaConsulta.dto.request.DentistaRequestDTO;
import com.dh.ReservaConsulta.dto.response.DentistaResponseDTO;
import com.dh.ReservaConsulta.entity.Dentista;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {
    private DentistaRepository dentistaIDao;

    @Autowired
    private DentistaRepository dentistaRepository;

    public DentistaResponseDTO salvar(DentistaRequestDTO requestDTO) throws SQLException {
        ObjectMapper mapper = new ObjectMapper();
        Dentista dentista = mapper.convertValue(requestDTO, Dentista.class );
        Dentista saveDentista = dentistaRepository.save(dentista);
        DentistaResponseDTO dentistaResponseDTO = mapper.convertValue(saveDentista, DentistaResponseDTO.class);

        return dentistaResponseDTO;
    }

    public DentistaResponseDTO atualizar(int id, DentistaRequestDTO dentistaAtualizadoDTO) throws SQLException, JsonMappingException {
        Optional<Dentista> dentistaOptional = dentistaRepository.findById(id);

        if (dentistaOptional.isPresent()) {
            Dentista dentista = dentistaOptional.get();

            ObjectMapper mapper = new ObjectMapper();
            mapper.updateValue(dentista, dentistaAtualizadoDTO);

            Dentista dentistaSalvo = dentistaRepository.save(dentista);
            DentistaResponseDTO dentistaResponseDTO = mapper.convertValue(dentistaSalvo, DentistaResponseDTO.class);

            return dentistaResponseDTO;
        } else {
            throw new SQLException("Dentista não encontrado para este id : " + id);
        }
    }



    public List<Dentista> buscarTodos() throws SQLException {
        return dentistaRepository.findAll();
    }


    public Optional<Dentista> buscarPorId(int id) throws SQLException{
        return dentistaRepository.findById(id);
    }

    public Optional<Dentista> buscarPorNome(String nome) throws SQLException{
        return dentistaRepository.findDentistaByNomeContainingIgnoreCase(nome);
    }

    public void excluir(int id) throws SQLException{
        dentistaRepository.deleteById(id);
    }
}
