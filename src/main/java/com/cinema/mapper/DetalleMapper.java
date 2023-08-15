package com.cinema.mapper;

import com.cinema.entity.Boleta;
import com.cinema.entity.Detalle;
import com.cinema.entity.Producto;

public class DetalleMapper {
	private Integer id_detalle;
	private Double precio_unitario;
	private Integer cantidad;
	private String nombre_producto;
	private Integer id_boleta;
	
	public DetalleMapper() {}

	public DetalleMapper(Integer id_detalle, Double precio_unitario, Integer cantidad, String nombre_producto,
			Integer id_boleta) {
		this.id_detalle = id_detalle;
		this.precio_unitario = precio_unitario;
		this.cantidad = cantidad;
		this.nombre_producto = nombre_producto;
		this.id_boleta = id_boleta;
	}
	
	public DetalleMapper(Detalle detalle) {
		this.id_detalle = detalle.getIdDetalle();
		this.precio_unitario = detalle.getPrecio_unitario();
		this.cantidad = detalle.getCantidad();
		this.nombre_producto = nombreProducto(detalle.getProducto());
		this.id_boleta = codigoBoleta(detalle.getBoleta());
	}
	
	private Integer codigoBoleta(Boleta boleta) {
		Integer codigo = boleta.getIdBoleta();
		return codigo;
	}
	
	private String nombreProducto(Producto producto) {
		String nombre = producto.getNombreProducto();
		return nombre;
	}

	public Integer getId_detalle() {
		return id_detalle;
	}

	public void setId_detalle(Integer id_detalle) {
		this.id_detalle = id_detalle;
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

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Integer getId_boleta() {
		return id_boleta;
	}

	public void setId_boleta(Integer id_boleta) {
		this.id_boleta = id_boleta;
	}
}
