package com.dh.ReservaConsulta.service;

import com.dh.ReservaConsulta.dto.request.PacienteRequestDTO;
import com.dh.ReservaConsulta.dto.response.PacienteResponseDTO;
import com.dh.ReservaConsulta.entity.Paciente;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    PacienteResponseDTO salvar(PacienteRequestDTO requestDTO) throws SQLException;

    List<Paciente> buscarTodos() throws SQLException;

    Optional<Paciente> buscarPorId(int id) throws SQLException;

    void excluir(Integer id) throws SQLException;
}
