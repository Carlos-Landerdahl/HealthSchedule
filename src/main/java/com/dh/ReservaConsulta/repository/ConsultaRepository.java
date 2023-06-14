package com.dh.ReservaConsulta.repository;

import com.dh.ReservaConsulta.entity.Consulta;
import com.dh.ReservaConsulta.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// essa interface JPA substitue toda camada de metodos HTTP

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    List<Consulta> findAllByDentistaId(int dentistaId);
    List<Consulta> findAllByPacienteId(int pacienteId);
}
