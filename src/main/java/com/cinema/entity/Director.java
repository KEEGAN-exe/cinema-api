package com.cinema.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "directores")
public class Director implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDirector;
	@Column(nullable = false)
	private String nombreDirector;
	
	@OneToMany(mappedBy = "director")
	@JsonIgnore
	private List<Pelicula> itemsPeliculas;
	
	public Director() {}
	
	public Director(Integer idDirector, String nombreDirector) {
		this.idDirector = idDirector;
		this.nombreDirector = nombreDirector;
	}

	public Integer getIdDirector() {
		return idDirector;
	}
	public void setIdDirector(Integer idDirector) {
		this.idDirector = idDirector;
	}
	public String getNombreDirector() {
		return nombreDirector;
	}
	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}

	public List<Pelicula> getItemsPeliculas() {
		return itemsPeliculas;
	}

	public void setItemsPeliculas(List<Pelicula> itemsPeliculas) {
		this.itemsPeliculas = itemsPeliculas;
	}
	
}
