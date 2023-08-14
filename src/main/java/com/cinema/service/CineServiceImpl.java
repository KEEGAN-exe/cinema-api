package com.cinema.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.entity.Cine;
import com.cinema.repository.CineRepository;

@Service
public class CineServiceImpl implements CineService{

	@Autowired
	private CineRepository cineRepository;

	@Override
	public void insert(Cine cine) {
		cineRepository.save(cine);
	}

	@Override
	public void update(Cine cine) {
		cineRepository.save(cine);
	}

	@Override
	public void delete(Integer idCine) {
		cineRepository.deleteById(idCine);
	}

	@Override
	public Cine findById(Integer idCine) {
		return cineRepository.findById(idCine).orElse(null);
	}

	@Override
	public Collection<Cine> findAll() {
		return cineRepository.findAll();
	}
	
	
}
