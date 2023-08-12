package com.cinema.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPelicula;
	@Column(nullable = false)
	private String nombrePelicula;
	@Column(nullable = false)
	private String sinopsis;
	@Column(nullable = false)
	private Integer clasificacion;
	@Column(nullable = false)
	private Date fechaEstreno;
	@Column(nullable = false)
	private Integer duracionMinutos;
	@Column(nullable = false)
	private String pais;
	@Column(nullable = false)
	private String imagenUrl;
	
	public Pelicula() {}

	public Pelicula(Integer idPelicula, String nombrePelicula, String sinopsis, Integer clasificacion,
			Date fechaEstreno, Integer duracionMinutos, String pais, String imagenUrl) {
		this.idPelicula = idPelicula;
		this.nombrePelicula = nombrePelicula;
		this.sinopsis = sinopsis;
		this.clasificacion = clasificacion;
		this.fechaEstreno = fechaEstreno;
		this.duracionMinutos = duracionMinutos;
		this.pais = pais;
		this.imagenUrl = imagenUrl;
	}

	public Integer getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Integer getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Integer clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public Integer getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(Integer duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

}
