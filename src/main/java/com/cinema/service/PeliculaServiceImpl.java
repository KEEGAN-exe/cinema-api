package com.cinema.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.entity.Pelicula;
import com.cinema.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService{

	@Autowired
	private PeliculaRepository peliculaRepository;

	@Override
	@Transactional
	public void insert(Pelicula pelicula) {
		peliculaRepository.save(pelicula);
	}

	@Override
	@Transactional
	public void update(Pelicula pelicula) {
		peliculaRepository.save(pelicula);
	}

	@Override
	@Transactional
	public void delete(Integer idPelicula) {
		peliculaRepository.deleteById(idPelicula);
	}

	@Override
	@Transactional(readOnly = true)
	public Pelicula findById(Integer idPelicula) {
		return peliculaRepository.findById(idPelicula).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Pelicula> findAll() {
		return peliculaRepository.findAll();
	}

	@Override
	public Collection<Object[]> findAll_withNames() {
		return peliculaRepository.findAll_withNames();
	}
	
	
	
}
