package com.cinema.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.entity.Asiento;
import com.cinema.repository.AsientoRepository;

@Service
public class AsientoServiceImpl implements AsientoService{

	@Autowired
	private AsientoRepository asientoRepository;

	@Override
	public void insert(Asiento asiento) {
		asientoRepository.save(asiento);
	}

	@Override
	public void update(Asiento asiento) {
		asientoRepository.save(asiento);
	}

	@Override
	public void delete(Integer idAsiento) {
		asientoRepository.deleteById(idAsiento);
	}

	@Override
	public Asiento findById(Integer idAsiento) {
		return asientoRepository.findById(idAsiento).orElse(null);
	}

	@Override
	public Collection<Asiento> findAll() {
		return asientoRepository.findAll();
	}
	
	
}
