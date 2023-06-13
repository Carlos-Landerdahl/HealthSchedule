package com.dh.ReservaConsulta.repository;

import com.dh.ReservaConsulta.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// essa interface JPA substitue toda camada de metodos HTTP
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
