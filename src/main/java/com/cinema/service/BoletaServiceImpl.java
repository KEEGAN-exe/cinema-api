package com.cinema.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.entity.Boleta;
import com.cinema.repository.BoletaRepository;

@Service
public class BoletaServiceImpl implements BoletaService{

	@Autowired
	private BoletaRepository boletaRepository;

	@Override
	public void insert(Boleta boleta) {
		boletaRepository.save(boleta);
	}

	@Override
	public void update(Boleta boleta) {
		boletaRepository.save(boleta);
	}

	@Override
	public void delete(Integer idBoleta) {
		boletaRepository.deleteById(idBoleta);
	}

	@Override
	public Boleta findById(Integer idBoleta) {
		return boletaRepository.findById(idBoleta).orElse(null);
	}

	@Override
	public Collection<Boleta> findAll() {
		return boletaRepository.findAll();
	}

	@Override
	public Collection<Object[]> findAllWithNames() {
		return boletaRepository.findAllWithNames();
	}
}
