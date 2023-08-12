package com.cinema.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.entity.Genero;
import com.cinema.repository.GeneroRepository;

@Service
public class GeneroServiceImpl implements GeneroService{

	@Autowired
	private GeneroRepository generoRepository;

	@Override
	@Transactional
	public void insert(Genero genero) {
		generoRepository.save(genero);
	}

	@Override
	@Transactional
	public void update(Genero genero) {
		generoRepository.save(genero);
	}

	@Override
	@Transactional
	public void delete(Integer idGenero) {
		generoRepository.deleteById(idGenero);
	}

	@Override
	@Transactional(readOnly = true)
	public Genero findById(Integer idGenero) {
		return generoRepository.findById(idGenero).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Genero> findAll() {
		return generoRepository.findAll();
	}
}
