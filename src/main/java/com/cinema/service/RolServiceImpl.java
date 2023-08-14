package com.cinema.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.entity.Rol;
import com.cinema.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepository rolRepository;

	@Override
	public void insert(Rol rol) {
		rolRepository.save(rol);
	}

	@Override
	public void update(Rol rol) {
		rolRepository.save(rol);
	}

	@Override
	public void delete(Integer idRol) {
		rolRepository.deleteById(idRol);
	}

	@Override
	public Rol findById(Integer idRol) {
		return rolRepository.findById(idRol).orElse(null);
	}

	@Override
	public Collection<Rol> findAll() {
		return rolRepository.findAll();
	}
	
	
	
}
