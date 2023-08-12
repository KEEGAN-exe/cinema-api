package com.cinema.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "directores")
public class Director implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDirector;
	@Column(nullable = false)
	private String nombreDirector;
	
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
	
	
}
