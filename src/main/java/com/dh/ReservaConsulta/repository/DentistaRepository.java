package com.dh.ReservaConsulta.repository;

import com.dh.ReservaConsulta.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// essa interface JPA substitue toda camada de metodos HTTP

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Integer> {
}
