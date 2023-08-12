package com.cinema.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cinema.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
	@Query(value = "SELECT p.nombre_pelicula, g.nombre_genero FROM peliculas_generos pg \r\n"
			+ "INNER JOIN peliculas p ON pg.pelicula_id = p.id_pelicula \r\n"
			+ "INNER JOIN generos g ON pg.genero_id = g.id_genero \r\n"
			+ "ORDER BY p.id_pelicula;",nativeQuery = true)
	public abstract Collection<Object[]> findAll_withNames();
}
