package com.cinema.service;

import java.util.Collection;

import com.cinema.entity.Rol;

public interface RolService {

	public abstract void insert(Rol rol);
	public abstract void update(Rol rol);
	public abstract void delete(Integer idRol);
	public abstract Rol findById(Integer idRol);
	public abstract Collection<Rol> findAll();

}
