package com.cinema.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.entity.Director;
import com.cinema.repository.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService{

	@Autowired
	private DirectorRepository directorRepository;

	@Override
	@Transactional
	public void insert(Director director) {
		directorRepository.save(director);
	}

	@Override
	@Transactional
	public void update(Director director) {
		directorRepository.save(director);
	}

	@Override
	@Transactional
	public void delete(Integer idDirector) {
		directorRepository.deleteById(idDirector);
	}

	@Override
	@Transactional(readOnly = true)
	public Director findById(Integer idDirector) {
		return directorRepository.findById(idDirector).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Director> findAll() {
		return directorRepository.findAll();
	}
	
}
