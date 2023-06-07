package com.dh.ReservaConsulta.service;

import com.dh.ReservaConsulta.dao.IPaciente;
import com.dh.ReservaConsulta.dto.request.PacienteRequestDTO;
import com.dh.ReservaConsulta.dto.response.PacienteResponseDTO;
import com.dh.ReservaConsulta.model.Paciente;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PacienteService {

    private IPaciente<Paciente> pacienteIDao;

    @Autowired
    public PacienteService(IPaciente<Paciente> pacienteIDao){
        this.pacienteIDao = pacienteIDao;
    }

    public PacienteResponseDTO salvar(PacienteRequestDTO requestDTO) throws SQLException {
        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente = mapper.convertValue(requestDTO, Paciente.class);
        Paciente savePaciente = pacienteIDao.salvar(paciente);
        PacienteResponseDTO pacienteResponseDTO = mapper.convertValue(savePaciente, PacienteResponseDTO.class);

        return pacienteResponseDTO;
    }

    public List<Paciente> buscarTodos() throws SQLException {
        return pacienteIDao.buscarTodos();
    }

    public void excluir(Integer id) throws SQLException {
        pacienteIDao.excluir(id);
    }
}
