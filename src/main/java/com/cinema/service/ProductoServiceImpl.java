package com.cinema.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.entity.Producto;
import com.cinema.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public void insert(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public void update(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public void delete(Integer idProducto) {
		productoRepository.deleteById(idProducto);
	}

	@Override
	public Producto findById(Integer idProducto) {
		return productoRepository.findById(idProducto).orElse(null);
	}

	@Override
	public Collection<Producto> findAll() {
		return productoRepository.findAll();
	}
}
