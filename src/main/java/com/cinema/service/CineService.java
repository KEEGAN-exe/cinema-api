package com.cinema.service;

import java.util.Collection;

import com.cinema.entity.Cine;

public interface CineService {

	public abstract void insert(Cine cine);
	public abstract void update(Cine cine);
	public abstract void delete(Integer idCine);
	public abstract Cine findById(Integer idCine);
	public abstract Collection<Cine> findAll();

}
