package com.dh.ReservaConsulta.service;

import java.util.List;
import java.util.Optional;

public interface IConsulta<TYPE> {
    TYPE salvar(TYPE entity);

    List<TYPE> buscarTodos();

    Optional<TYPE> buscarPorIdConsulta(int id);

    void excluir(int id);
}
