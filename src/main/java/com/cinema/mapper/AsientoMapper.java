package com.cinema.mapper;


import com.cinema.entity.Asiento;
import com.cinema.entity.Sala;

public class AsientoMapper {
	private Integer id_asiento;
	private String estado;
	private Integer columna;
	private Integer fila;
	private String tipo;
	private Integer codigo_sala;
	
	public AsientoMapper(Integer id_asiento, String estado, Integer columna, Integer fila, String tipo,
			Integer codigo_sala) {
		this.id_asiento = id_asiento;
		this.estado = estado;
		this.columna = columna;
		this.fila = fila;
		this.tipo = tipo;
		this.codigo_sala = codigo_sala;
	}
	
	public AsientoMapper(Asiento asiento) {
		this.id_asiento = asiento.getIdAsiento();
		this.estado = asiento.getEstado();
		this.columna = asiento.getColumna();
		this.fila = asiento.getFila();
		this.tipo = asiento.getTipo();
		this.codigo_sala = codigoSala(asiento.getSala());
	}
	
	private Integer codigoSala(Sala sala) {
		Integer codigo = sala.getIdSala();
		return codigo;
	}

	public Integer getId_asiento() {
		return id_asiento;
	}

	public void setId_asiento(Integer id_asiento) {
		this.id_asiento = id_asiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getColumna() {
		return columna;
	}

	public void setColumna(Integer columna) {
		this.columna = columna;
	}

	public Integer getFila() {
		return fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCodigo_sala() {
		return codigo_sala;
	}

	public void setCodigo_sala(Integer codigo_sala) {
		this.codigo_sala = codigo_sala;
	}
	
	
}
