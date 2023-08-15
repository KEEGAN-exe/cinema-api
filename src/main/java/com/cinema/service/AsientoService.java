package com.cinema.service;

import java.util.Collection;

import com.cinema.entity.Asiento;

public interface AsientoService {

	public abstract void insert(Asiento asiento);
	public abstract void update(Asiento asiento);
	public abstract void delete(Integer idAsiento);
	public abstract Asiento findById(Integer idAsiento);
	public abstract Collection<Asiento> findAll();
}
