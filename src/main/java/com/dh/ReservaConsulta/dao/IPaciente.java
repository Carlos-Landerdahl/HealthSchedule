package com.dh.ReservaConsulta.dao;

import java.sql.SQLException;
import java.util.List;

public interface IPaciente<T>{
    T salvar(T t) throws SQLException;

    List<T> buscarTodos() throws SQLException;

    void excluir(int id) throws SQLException;
}
