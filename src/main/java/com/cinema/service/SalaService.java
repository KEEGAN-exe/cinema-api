package com.cinema.service;

import java.util.Collection;

import com.cinema.entity.Sala;

public interface SalaService {

	public abstract void insert(Sala sala);
	public abstract void update(Sala sala);
	public abstract void delete(Integer idSala);
	public abstract Sala findById(Integer idSala);
	public abstract Collection<Sala> findAll();

}
