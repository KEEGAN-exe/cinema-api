package com.cinema.service;

import java.util.Collection;

import com.cinema.entity.Genero;

public interface GeneroService {
	
	public abstract void insert(Genero genero);
	public abstract void update(Genero genero);
	public abstract void delete(Integer idGenero);
	public abstract Genero findById(Integer idGenero);
	public abstract Collection<Genero> findAll();
	
}
