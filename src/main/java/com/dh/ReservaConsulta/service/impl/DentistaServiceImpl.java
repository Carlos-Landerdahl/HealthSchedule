package com.dh.ReservaConsulta.service.impl;

import com.dh.ReservaConsulta.model.Dentista;
import com.dh.ReservaConsulta.service.IDentistaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistaServiceImpl implements IDentistaService<Dentista> {
    @Override
    public Dentista salvar(Dentista dentista) {
        return null;
    }

    @Override
    public List<Dentista> buscarTodos() {
        return null;
    }

    @Override
    public String excluir(Integer id) {
        return null;
    }
}
