package com.dh.ReservaConsulta.service.impl;

import com.dh.ReservaConsulta.repository.PacienteRepository;
import com.dh.ReservaConsulta.dto.request.PacienteRequestDTO;
import com.dh.ReservaConsulta.dto.response.PacienteResponseDTO;
import com.dh.ReservaConsulta.entity.Paciente;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService{

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteResponseDTO salvar(PacienteRequestDTO requestDTO) throws SQLException {
        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente = mapper.convertValue(requestDTO, Paciente.class);
        Paciente savePaciente = pacienteRepository.save(paciente);
        PacienteResponseDTO pacienteResponseDTO = mapper.convertValue(savePaciente, PacienteResponseDTO.class);

        return pacienteResponseDTO;
    }


    public List<Paciente> buscarTodos() throws SQLException {
        return pacienteRepository.findAll();
    }


    public Optional<Paciente> buscarPorId(int id) throws SQLException{
        return pacienteRepository.findById(id);
    }


    public void excluir(Integer id) throws SQLException {
        pacienteRepository.deleteById(id);
    }
}
