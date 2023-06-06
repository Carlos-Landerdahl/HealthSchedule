package com.dh.ReservaConsulta.service;

import com.dh.ReservaConsulta.dao.IDentista;
import com.dh.ReservaConsulta.model.Dentista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DentistaService implements IDentista<Dentista> {
    private IDentista<Dentista> dentistaIDao;

    @Autowired
    public DentistaService(IDentista<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }

    @Override
    public Dentista salvar(Dentista dentista) throws SQLException {
        return dentistaIDao.salvar(dentista);
    }

    @Override
    public List<Dentista> buscarTodos() throws SQLException {
        return dentistaIDao.buscarTodos();
    }

    @Override
    public void excluir(int id) throws SQLException{
        dentistaIDao.excluir(id);
    }
}
