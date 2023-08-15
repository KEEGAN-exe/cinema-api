package com.cinema.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "asientos")
public class Asiento implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAsiento;
	@Column(nullable = false)
	private Integer fila;
	@Column(nullable = false)
	private Integer columna;
	@Column(nullable = false)
	private String tipo;
	@Column(nullable = false)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_sala",nullable = false)
	private Sala sala;
	
	@ManyToMany(mappedBy = "asientos")
    private List<Boleta> boletas;
	
	public Asiento() {}

	

	public Asiento(Integer idAsiento, Integer fila, Integer columna, String tipo, String estado, Sala sala,
			List<Boleta> boletas) {
		this.idAsiento = idAsiento;
		this.fila = fila;
		this.columna = columna;
		this.tipo = tipo;
		this.estado = estado;
		this.sala = sala;
		this.boletas = boletas;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getIdAsiento() {
		return idAsiento;
	}

	public void setIdAsiento(Integer idAsiento) {
		this.idAsiento = idAsiento;
	}

	public Integer getFila() {
		return fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}

	public Integer getColumna() {
		return columna;
	}

	public void setColumna(Integer columna) {
		this.columna = columna;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Boleta> getBoletas() {
		return boletas;
	}

	public void setBoletas(List<Boleta> boletas) {
		this.boletas = boletas;
	}
	
}
