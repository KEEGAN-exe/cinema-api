package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
