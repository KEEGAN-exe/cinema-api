package com.cinema.service;

import java.util.Collection;
import java.util.List;

import com.cinema.entity.Detalle;
public interface DetalleService {

	public abstract void insert(Detalle detalle);
	public abstract void update(Detalle detalle);
	public abstract void delete(Integer idDetalle);
	public abstract Detalle findById(Integer idDetalle);
	public abstract Collection<Detalle> findAll();
	public abstract List<Detalle> findByBoletaId(Long idBoleta);
}
