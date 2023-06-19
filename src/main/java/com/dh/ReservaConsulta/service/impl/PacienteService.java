package com.dh.ReservaConsulta.service.impl;

import com.dh.ReservaConsulta.repository.PacienteRepository;
import com.dh.ReservaConsulta.dto.request.PacienteRequestDTO;
import com.dh.ReservaConsulta.dto.response.PacienteResponseDTO;
import com.dh.ReservaConsulta.entity.Paciente;

import com.dh.ReservaConsulta.service.IPaciente;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPaciente<Paciente, PacienteRequestDTO, PacienteResponseDTO> {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteResponseDTO salvar(PacienteRequestDTO requestDTO) throws SQLException {
        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente = mapper.convertValue(requestDTO, Paciente.class);
        Paciente savePaciente = pacienteRepository.save(paciente);
        PacienteResponseDTO pacienteResponseDTO = mapper.convertValue(savePaciente, PacienteResponseDTO.class);

        return pacienteResponseDTO;
    }

    public PacienteResponseDTO atualizar(int id, PacienteRequestDTO pacienteAtualizadoDTO) throws SQLException, JsonMappingException {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

        if(pacienteOptional.isPresent()){
            Paciente paciente = pacienteOptional.get();

            ObjectMapper mapper = new ObjectMapper();
            mapper.updateValue(paciente, pacienteAtualizadoDTO);

            Paciente pacienteSalvo = pacienteRepository.save(paciente);
            PacienteResponseDTO pacienteResponseDTO = mapper.convertValue(pacienteSalvo, PacienteResponseDTO.class);

            return pacienteResponseDTO;
        }else{
            throw new SQLException("Paciente não encontrado com este id: " + id);
        }

    }

    public List<Paciente> buscarTodos() throws SQLException {
        return pacienteRepository.findAll();
    }


    public Optional<Paciente> buscarPorId(int id) throws SQLException{
        return pacienteRepository.findById(id);
    }

    public Optional<Paciente> buscarPorNome(String nome) throws SQLException{
        return pacienteRepository.findPacienteByNomeContainingIgnoreCase(nome);
    }

    public void excluir(int id) throws SQLException {
        pacienteRepository.deleteById(id);
    }
}
