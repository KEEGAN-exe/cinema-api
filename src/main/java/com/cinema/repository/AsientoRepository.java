package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cinema.entity.Asiento;

public interface AsientoRepository extends JpaRepository<Asiento, Integer>{

	@Query(value = "SELECT * FROM asientos a WHERE a.id_sala = ?1",nativeQuery = true)
	public abstract List<Asiento> findBySalaId(Long idSala);
}
