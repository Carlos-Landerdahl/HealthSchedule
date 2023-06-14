package com.dh.ReservaConsulta.repository;

import com.dh.ReservaConsulta.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Integer> {
//    @Query("SELECT j FROM TB_DENTISTAS j WHERE j.nome = ?1")
    Optional<Dentista> findDentistaByNomeContainingIgnoreCase(String nome);
}
