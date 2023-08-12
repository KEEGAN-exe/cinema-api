package com.cinema.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cinema.entity.Director;
import com.cinema.entity.Genero;
import com.cinema.entity.Pelicula;


public class PeliculaMapper {
	
	private Integer idPelicula;
	private String nombrePelicula;
	private String sinopsis;
	private Integer clasificacion;
	private Date fechaEstreno;
	private Integer duracionMinutos;
	private String pais;
	private List<String> generos;
	private String director;
	private String imagenUrl;
	
	public PeliculaMapper() {}

	public PeliculaMapper(Integer idPelicula, String nombrePelicula, String sinopsis, Integer clasificacion,
			Date fechaEstreno, Integer duracionMinutos, String pais, List<String> generos, String director,
			String imagenUrl) {
		this.idPelicula = idPelicula;
		this.nombrePelicula = nombrePelicula;
		this.sinopsis = sinopsis;
		this.clasificacion = clasificacion;
		this.fechaEstreno = fechaEstreno;
		this.duracionMinutos = duracionMinutos;
		this.pais = pais;
		this.generos = generos;
		this.director = director;
		this.imagenUrl = imagenUrl;
	}
	
	public PeliculaMapper(Pelicula pelicula) {
		this.idPelicula = pelicula.getIdPelicula();
		this.nombrePelicula = pelicula.getNombrePelicula();
		this.sinopsis = pelicula.getSinopsis();
		this.clasificacion = pelicula.getClasificacion();
		this.fechaEstreno = pelicula.getFechaEstreno();
		this.duracionMinutos = pelicula.getDuracionMinutos();
		this.pais = pelicula.getPais();
		this.generos = genero(pelicula.getGeneros());
		this.director = nombreDirector(pelicula.getDirector());
		this.imagenUrl = pelicula.getImagenUrl();
		
	}
	
	private String nombreDirector(Director director){
	    String nombre =  director.getNombreDirector();
	    return nombre;
	}
	
	
	private List<String> genero(List<Genero> generos){
		List<String> nombres = new ArrayList<>();
		for(Genero itemGenero : generos) {
			nombres.add(itemGenero.getNombreGenero());
		}
		
		return nombres;
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

	public List<String> getGeneros() {
		return generos;
	}

	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

}
