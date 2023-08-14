package com.cinema.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "detalles")
public class Detalle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalle;
	@Column(nullable = false)
	private Double precio_unitario;
	@Column(nullable = false)
	private Integer cantidad;
	
	@ManyToOne
	@JoinColumn(name = "id_producto",nullable = false)
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "id_boleta", nullable = false)
	private Boleta boleta;
	
	public Detalle() {}

	
	public Detalle(Integer idDetalle, Double precio_unitario, Integer cantidad, Producto producto, Boleta boleta) {
		this.idDetalle = idDetalle;
		this.precio_unitario = precio_unitario;
		this.cantidad = cantidad;
		this.producto = producto;
		this.boleta = boleta;
	}

	public Double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(Double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}
	
}
