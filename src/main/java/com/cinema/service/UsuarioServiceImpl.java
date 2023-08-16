package com.cinema.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.entity.Usuario;
import com.cinema.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void insert(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public void delete(Integer idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}

	@Override
	public Usuario findById(Integer idUsuario) {
		return usuarioRepository.findById(idUsuario).orElse(null);
	}

	@Override
	public Collection<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Collection<Object[]> findAllWithNames() {
		return usuarioRepository.findAllWithNames();
	}
}
