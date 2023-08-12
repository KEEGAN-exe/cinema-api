package com.cinema.service;

import java.util.Collection;

import com.cinema.entity.Director;

public interface DirectorService {

	public abstract void insert(Director director);
	public abstract void update(Director director);
	public abstract void delete(Integer idDirector);
	public abstract Director findById(Integer idDirector);
	public abstract Collection<Director> findAll();
}
