package com.cinema.service;

import java.util.Collection;


import com.cinema.entity.Usuario;

public interface UsuarioService {
	
	public abstract void insert(Usuario usuario);
	public abstract void update(Usuario usuario);
	public abstract void delete(Integer idUsuario);
	public abstract Usuario findById(Integer idUsuario);
	public abstract Collection<Usuario> findAll();
	public abstract Collection<Object[]> findAllWithNames();
}
