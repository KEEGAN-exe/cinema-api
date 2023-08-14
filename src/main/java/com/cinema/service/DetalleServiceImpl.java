package com.cinema.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.entity.Detalle;
import com.cinema.repository.DetalleRepository;

@Service
public class DetalleServiceImpl implements DetalleService{

	@Autowired
	private DetalleRepository detalleRepository;

	@Override
	public void insert(Detalle detalle) {
		detalleRepository.save(detalle);
	}

	@Override
	public void update(Detalle detalle) {
		detalleRepository.save(detalle);
	}

	@Override
	public void delete(Integer idDetalle) {
		detalleRepository.deleteById(idDetalle);
	}

	@Override
	public Detalle findById(Integer idDetalle) {
		return detalleRepository.findById(idDetalle).orElse(null);
	}

	@Override
	public Collection<Detalle> findAll() {
		return detalleRepository.findAll();
	}

	@Override
	public List<Detalle> findByBoletaId(Long idBoleta) {
		return detalleRepository.findByBoletaId(idBoleta);
	}





}
