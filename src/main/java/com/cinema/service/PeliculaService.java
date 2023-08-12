package com.cinema.service;

import java.util.Collection;

import com.cinema.entity.Pelicula;

public interface PeliculaService {

	public abstract void insert(Pelicula pelicula);
	public abstract void update(Pelicula pelicula);
	public abstract void delete(Integer idPelicula);
	public abstract Pelicula findById(Integer idPelicula);
	public abstract Collection<Pelicula> findAll();
}
