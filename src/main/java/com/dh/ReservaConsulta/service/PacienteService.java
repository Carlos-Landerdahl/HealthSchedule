package com.dh.ReservaConsulta.service;

import com.dh.ReservaConsulta.dao.IPaciente;
import com.dh.ReservaConsulta.model.Paciente;

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

    public Paciente salvar(Paciente paciente) throws SQLException {
        return pacienteIDao.salvar(paciente);
    }

    public List<Paciente> buscarTodos() throws SQLException {
        return pacienteIDao.buscarTodos();
    }

    public void excluir(Integer id) throws SQLException {
        pacienteIDao.excluir(id);
    }
}
