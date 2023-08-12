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
@Table(name = "generos")
public class Genero implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGenero;
	@Column(nullable = false)
	private String nombreGenero;
	@ManyToMany(mappedBy = "generos")
	@JsonIgnore
	private List<Pelicula> itemsPeliculas;
	
	public Genero() {}

	public Genero(Integer idGenero, String nombreGenero) {
		this.idGenero = idGenero;
		this.nombreGenero = nombreGenero;
	}

	public Integer getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

	public String getNombreGenero() {
		return nombreGenero;
	}

	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}

	public List<Pelicula> getItemsPeliculas() {
		return itemsPeliculas;
	}

	public void setItemsPeliculas(List<Pelicula> itemsPeliculas) {
		this.itemsPeliculas = itemsPeliculas;
	}
	
}
