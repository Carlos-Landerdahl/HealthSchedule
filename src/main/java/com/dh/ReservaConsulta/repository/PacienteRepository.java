package com.dh.ReservaConsulta.repository;

import com.dh.ReservaConsulta.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
//    @Query("SELECT j FROM TB_PACIENTES j WHERE j.nome = ?1")
    Optional<Paciente> findPacienteByNomeContainingIgnoreCase(String nome);
}
