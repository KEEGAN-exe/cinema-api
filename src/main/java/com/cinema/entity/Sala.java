package com.cinema.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "salas")
public class Sala implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSala;
	@Column(nullable = false)
	private String tipo;
	@Column(nullable = false)
	private String estado;
	@Column(nullable = false)
	private Integer capacidad;
	@Column(nullable = false)
	private Integer asientos_ocupados;
	
	@OneToMany(mappedBy = "sala")
	@JsonIgnore
	private List<Boleta> boletas;
	
	@ManyToOne
	@JoinColumn(name = "idCine",nullable = false)
	private Cine cine;
	
	@ManyToMany
	@JoinTable(name = "salas_peliculas",joinColumns = @JoinColumn(name = "pelicula_id"), inverseJoinColumns = @JoinColumn(name = "sala_id"))
    private List<Pelicula> peliculas;
	
	@OneToMany(mappedBy = "sala")
	@JsonIgnore
	private List<Asiento> asiento;
	
	public Sala() {}

	public Sala(Integer idSala, String tipo, String estado, Integer capacidad, Integer asientos_ocupados,
			List<Boleta> boletas, Cine cine, List<Pelicula> peliculas, List<Asiento> asiento) {
		this.idSala = idSala;
		this.tipo = tipo;
		this.estado = estado;
		this.capacidad = capacidad;
		this.asientos_ocupados = asientos_ocupados;
		this.boletas = boletas;
		this.cine = cine;
		this.peliculas = peliculas;
		this.asiento = asiento;
	}

	public void addPelicula(Pelicula pelicula) {
		peliculas.add(pelicula);
	}
	
	public boolean removePelicula(Pelicula pelicula) {
		return peliculas.remove(pelicula);
	}
	
	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public List<Boleta> getBoletas() {
		return boletas;
	}

	public void setBoletas(List<Boleta> boletas) {
		this.boletas = boletas;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public Integer getIdSala() {
		return idSala;
	}

	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getAsientos_ocupados() {
		return asientos_ocupados;
	}

	public void setAsientos_ocupados(Integer asientos_ocupados) {
		this.asientos_ocupados = asientos_ocupados;
	}
	
}
