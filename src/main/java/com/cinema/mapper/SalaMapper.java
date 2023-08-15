package com.cinema.mapper;

import com.cinema.entity.Cine;
import com.cinema.entity.Sala;

public class SalaMapper {
	private Integer id_sala;
	private String estado;
	private String tipo;
	private Integer capacidad;
	private Integer asientos_ocupados;
	private String nombre_cine;
	
	public SalaMapper() {}

	public SalaMapper(Integer id_sala, String estado, String tipo, Integer capacidad, Integer asientos_ocupados,
			String nombre_cine) {
		this.id_sala = id_sala;
		this.estado = estado;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.asientos_ocupados = asientos_ocupados;
		this.nombre_cine = nombre_cine;
	}

	public SalaMapper(Sala sala) {
		this.id_sala = sala.getIdSala();
		this.estado = sala.getEstado();
		this.tipo = sala.getTipo();
		this.capacidad = sala.getCapacidad();
		this.asientos_ocupados = sala.getAsientos_ocupados();
		this.nombre_cine = nombreCine(sala.getCine());
	}
	
	private String nombreCine(Cine cine) {
		String nombre = cine.getNombreCine();
		return nombre;
	}

	public Integer getId_sala() {
		return id_sala;
	}

	public void setId_sala(Integer id_sala) {
		this.id_sala = id_sala;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getNombre_cine() {
		return nombre_cine;
	}

	public void setNombre_cine(String nombre_cine) {
		this.nombre_cine = nombre_cine;
	}
	
	
}
