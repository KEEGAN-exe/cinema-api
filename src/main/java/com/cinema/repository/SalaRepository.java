package com.cinema.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cinema.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer>{
	@Query(value = "SELECT s.id_sala, p.id_pelicula FROM salas_peliculas sp \r\n"
			+ "INNER JOIN salas s ON sp.sala_id = s.id_sala\r\n"
			+ " INNER JOIN peliculas p ON sp.pelicula_id = p.id_pelicula\r\n"
			+ " ORDER BY s.id_sala;",nativeQuery = true)
	public abstract Collection<Object[]> findAllWithNames();
}
