package com.dh.ReservaConsulta.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IPaciente<T>{
    T salvar(T t) throws SQLException;

    List<T> buscarTodos() throws SQLException;

    Optional<T> buscarPorId(int id) throws SQLException;

    void excluir(int id) throws SQLException;
}
