package com.cinema.mapper;

public class PeliculaInfo {
	private Integer id_pelicula;
	private String nombre_pelicula;
	
	public PeliculaInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public PeliculaInfo(Integer id_pelicula, String nombre_pelicula) {
		this.id_pelicula = id_pelicula;
		this.nombre_pelicula = nombre_pelicula;
	}
	public Integer getId_pelicula() {
		return id_pelicula;
	}
	public void setId_pelicula(Integer id_pelicula) {
		this.id_pelicula = id_pelicula;
	}
	public String getNombre_pelicula() {
		return nombre_pelicula;
	}
	public void setNombre_pelicula(String nombre_pelicula) {
		this.nombre_pelicula = nombre_pelicula;
	}
	
	
}
