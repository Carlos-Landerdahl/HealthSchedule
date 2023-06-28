package com.dh.ReservaConsulta.service.impl;

import com.dh.ReservaConsulta.entity.Consulta;
import com.dh.ReservaConsulta.entity.Dentista;
import com.dh.ReservaConsulta.entity.Paciente;
import com.dh.ReservaConsulta.repository.ConsultaRepository;
import com.dh.ReservaConsulta.repository.DentistaRepository;
import com.dh.ReservaConsulta.repository.PacienteRepository;
import com.dh.ReservaConsulta.service.IConsulta;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService implements IConsulta<Consulta>{

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private DentistaRepository dentistaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public Consulta salvar(Consulta consulta) {
        Dentista dentista = dentistaRepository.findById(consulta.getDentista().getId()).orElse(null);
        Paciente paciente = pacienteRepository.findById(consulta.getPaciente().getId()).orElse(null);

        if (dentista == null || paciente == null) {
            return null;
        }

        consulta.setDentista(dentista);
        consulta.setPaciente(paciente);

        return consultaRepository.save(consulta);
    }

    public List<Consulta> buscarTodos() {
        return consultaRepository.findAll();
    }

    public Consulta atualizar(int id, Consulta consultaAtualizada) {
        Optional<Consulta> consultaOptional = consultaRepository.findById(id);
        if (consultaOptional.isPresent()) {
            Consulta consultaExistente = consultaOptional.get();

            if (consultaAtualizada.getDentista() != null) {
                consultaExistente.setDentista(consultaAtualizada.getDentista());
            }
            if (consultaAtualizada.getPaciente() != null) {
                consultaExistente.setPaciente(consultaAtualizada.getPaciente());
            }
            if (consultaAtualizada.getDataConsulta() != null) {
                consultaExistente.setDataConsulta(consultaAtualizada.getDataConsulta());
            }
            if (consultaAtualizada.getHoraConsulta() != null) {
                consultaExistente.setHoraConsulta(consultaAtualizada.getHoraConsulta());
            }

            return consultaRepository.save(consultaExistente);
        } else {
            throw new RuntimeException("Consulta não encontrada para este id : " + id);
        }
    }



    public Optional<Consulta> buscarPorIdConsulta(int id) {
        return consultaRepository.findById(id);
    }

    public List<Consulta> listarConsultasPorDentista(int dentistaId) {
        return consultaRepository.findAllByDentistaId(dentistaId);
    }

    public List<Consulta> listarConsultasPorPaciente(int pacienteId) {
        return consultaRepository.findAllByPacienteId(pacienteId);
    }

    public void excluir(int id) {
        if (consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Consulta não encontrada para este id : " + id);
        }
    }
}