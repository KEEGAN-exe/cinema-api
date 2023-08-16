package com.cinema.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cinema.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value = "SELECT u.nombre, r.nombre_rol FROM usuarios_roles ur \r\n"
			+ "INNER JOIN usuarios u ON ur.usuario_id = u.id_usuario\r\n"
			+ " INNER JOIN roles r ON ur.rol_id = r.id_rol \r\n"
			+ " ORDER BY u.id_usuario;", nativeQuery = true)
	public abstract Collection<Object[]> findAllWithNames();



}
