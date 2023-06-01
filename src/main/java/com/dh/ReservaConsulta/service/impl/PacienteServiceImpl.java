package com.dh.ReservaConsulta.service.impl;

import com.dh.ReservaConsulta.model.Paciente;
import com.dh.ReservaConsulta.service.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements IPacienteService<Paciente> {
    @Override
    public Paciente salvar(Paciente paciente) {
        return null;
    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }

    @Override
    public String excluir(Integer id) {
        return null;
    }
}
