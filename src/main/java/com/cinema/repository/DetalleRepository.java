package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cinema.entity.Detalle;

public interface DetalleRepository extends JpaRepository<Detalle, Integer>{

	@Query(value = "SELECT * FROM detalles d WHERE d.id_boleta = ?1", nativeQuery = true)
	public abstract List<Detalle> findByBoletaId(Long idBoleta);

}
