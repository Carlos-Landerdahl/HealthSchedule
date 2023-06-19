package com.dh.ReservaConsulta.service;

import com.fasterxml.jackson.databind.JsonMappingException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IPaciente <TYPE, REQ, RES>{

    RES salvar(REQ requestDTO) throws SQLException;

    RES atualizar(int id, REQ atualizadoDTO) throws JsonMappingException,SQLException;

    List<TYPE> buscarTodos() throws SQLException;

    Optional<TYPE> buscarPorId(int id) throws SQLException;

    Optional<TYPE> buscarPorNome(String nome) throws SQLException;

    void excluir(int id) throws SQLException;

}
