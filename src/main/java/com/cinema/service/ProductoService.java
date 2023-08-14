package com.cinema.service;

import java.util.Collection;

import com.cinema.entity.Producto;

public interface ProductoService {

	public abstract void insert(Producto producto);
	public abstract void update(Producto producto);
	public abstract void delete(Integer idProducto);
	public abstract Producto findById(Integer idProducto);
	public abstract Collection<Producto> findAll();

}
