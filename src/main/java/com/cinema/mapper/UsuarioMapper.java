package com.cinema.mapper;

import java.util.ArrayList;
import java.util.List;

import com.cinema.entity.Rol;
import com.cinema.entity.Usuario;

public class UsuarioMapper {

	private Integer idUsuario;
	private String dni;
	private String email;
	private String nombre;
	private String telefono;
	private String usuario;
	private List<String> roles;
	
	public UsuarioMapper() {}

	public UsuarioMapper(Integer idUsuario, String dni, String email, String nombre, String telefono, String usuario,
			List<String> roles) {
		this.idUsuario = idUsuario;
		this.dni = dni;
		this.email = email;
		this.nombre = nombre;
		this.telefono = telefono;
		this.usuario = usuario;
		this.roles = roles;
	}
	
	public UsuarioMapper(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.dni = usuario.getDni();
		this.email = usuario.getEmail();
		this.nombre = usuario.getNombre();
		this.telefono = usuario.getTelefono();
		this.usuario = usuario.getUsuario();
		this.roles = rol(usuario.getRoles());
	}
	
	private List<String> rol(List<Rol> roles){
		List<String> nombre = new ArrayList<>();
		for (Rol rol : roles) {
			nombre.add(rol.getNombreRol());
		}
		
		return nombre;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
