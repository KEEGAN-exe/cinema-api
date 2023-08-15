package com.cinema.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "roles")
public class Rol implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRol;
	@Column(nullable = false)
	private String nombreRol;
	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private List<Usuario> itemsUsuarios;
	
	public Rol() {}

	public Rol(Integer idRol, String nombreRol) {
		this.idRol = idRol;
		this.nombreRol = nombreRol;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public List<Usuario> getItemsUsuarios() {
		return itemsUsuarios;
	}

	public void setItemsUsuarios(List<Usuario> itemsUsuarios) {
		this.itemsUsuarios = itemsUsuarios;
	}
	
}
