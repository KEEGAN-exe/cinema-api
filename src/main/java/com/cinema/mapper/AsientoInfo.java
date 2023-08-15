package com.cinema.mapper;

public class AsientoInfo {
	private int idAsiento;
    private int fila;
    private int columna;
    
    public AsientoInfo() {
		// TODO Auto-generated constructor stub
	}

	public AsientoInfo(int idAsiento, int fila, int columna) {
		this.idAsiento = idAsiento;
		this.fila = fila;
		this.columna = columna;
	}

	public int getIdAsiento() {
		return idAsiento;
	}

	public void setIdAsiento(int idAsiento) {
		this.idAsiento = idAsiento;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
    
    
}
