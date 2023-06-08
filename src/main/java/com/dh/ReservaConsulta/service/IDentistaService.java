package com.dh.ReservaConsulta.service;

import com.dh.ReservaConsulta.dto.request.DentistaRequestDTO;
import com.dh.ReservaConsulta.dto.response.DentistaResponseDTO;
import com.dh.ReservaConsulta.entity.Dentista;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDentistaService {

    DentistaResponseDTO salvar(DentistaRequestDTO requestDTO) throws SQLException;

    List<Dentista> buscarTodos() throws SQLException;

    Optional<Dentista> buscarPorId(int id) throws SQLException;

    void excluir(int id) throws SQLException;
}
