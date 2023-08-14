package com.cinema.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.entity.Sala;
import com.cinema.repository.SalaRepository;

@Service
public class SalaServiceImpl implements SalaService{

	@Autowired
	private SalaRepository salaRepository;

	@Override
	public void insert(Sala sala) {
		salaRepository.save(sala);
	}

	@Override
	public void update(Sala sala) {
		salaRepository.save(sala);
	}

	@Override
	public void delete(Integer idSala) {
		salaRepository.deleteById(idSala);
	}

	@Override
	public Sala findById(Integer idSala) {
		return salaRepository.findById(idSala).orElse(null);
	}

	@Override
	public Collection<Sala> findAll() {
		return salaRepository.findAll();
	}
	
	
}
