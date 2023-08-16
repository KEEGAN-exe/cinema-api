package com.cinema.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cinema.entity.Boleta;

public interface BoletaRepository extends JpaRepository<Boleta, Integer>{

	@Query(value = "SELECT b.id_boleta, a.id_asiento FROM boleta_asiento ba \r\n"
			+ "INNER JOIN boletas b ON ba.id_boleta = b.id_boleta\r\n"
			+ " INNER JOIN asientos a ON ba.id_asiento = a.id_asiento \r\n"
			+ " ORDER BY b.id_boleta;",nativeQuery = true)
	public abstract Collection<Object[]> findAllWithNames();
	
}
