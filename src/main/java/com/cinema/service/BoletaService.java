package com.cinema.service;

import java.util.Collection;

import com.cinema.entity.Boleta;

public interface BoletaService {

	public abstract void insert(Boleta boleta);
	public abstract void update(Boleta boleta);
	public abstract void delete(Integer idBoleta);
	public abstract Boleta findById(Integer idBoleta);
	public abstract Collection<Boleta> findAll();

}
