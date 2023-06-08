package com.dh.ReservaConsulta.service;

import com.dh.ReservaConsulta.repository.IPaciente;
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
public class PacienteService implements IPacienteService {

    private IPaciente<Paciente> pacienteIDao;

    @Autowired
    public PacienteService(IPaciente<Paciente> pacienteIDao){
        this.pacienteIDao = pacienteIDao;
    }

    @Override
    public PacienteResponseDTO salvar(PacienteRequestDTO requestDTO) throws SQLException {
        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente = mapper.convertValue(requestDTO, Paciente.class);
        Paciente savePaciente = pacienteIDao.salvar(paciente);
        PacienteResponseDTO pacienteResponseDTO = mapper.convertValue(savePaciente, PacienteResponseDTO.class);

        return pacienteResponseDTO;
    }

    @Override
    public List<Paciente> buscarTodos() throws SQLException {
        return pacienteIDao.buscarTodos();
    }

    @Override
    public Optional<Paciente> buscarPorId(int id) throws SQLException{
        return pacienteIDao.buscarPorId(id);
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        pacienteIDao.excluir(id);
    }
}
