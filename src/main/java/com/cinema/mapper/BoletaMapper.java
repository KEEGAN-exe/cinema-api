package com.cinema.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cinema.entity.Asiento;
import com.cinema.entity.Boleta;
import com.cinema.entity.Cine;
import com.cinema.entity.Sala;
import com.cinema.entity.Usuario;

public class BoletaMapper {
	private Integer id_boleta;
	private LocalDate fecha;
	private String estado;
	private Double igv;
	private Double sub_total;
	private Double total;
	private Integer codigo_sala;
	private String nombre_usuario;
	private String dni;
	private String ubicacion_cine;
	private List<AsientoInfo> asientos;
	
	public BoletaMapper() {}
	
	public BoletaMapper(Integer id_boleta, LocalDate fecha, String estado, Double igv, Double sub_total, Double total,
			Integer codigo_sala, String nombre_usuario, String dni, String ubicacion_cine, List<AsientoInfo> asientos) {
		this.id_boleta = id_boleta;
		this.fecha = fecha;
		this.estado = estado;
		this.igv = igv;
		this.sub_total = sub_total;
		this.total = total;
		this.codigo_sala = codigo_sala;
		this.nombre_usuario = nombre_usuario;
		this.dni = dni;
		this.ubicacion_cine = ubicacion_cine;
		this.asientos = asientos;
	}

	public BoletaMapper(Boleta boleta) {
		this.id_boleta = boleta.getIdBoleta();
		this.estado = boleta.getEstado();
		this.fecha = boleta.getFecha();
		this.igv = boleta.getIgv();
		this.sub_total = boleta.getSubTotal();
		this.total = boleta.getTotal();
		this.codigo_sala = identificadorSala(boleta.getSala());
		this.nombre_usuario = nombreUsuario(boleta.getUsuario());
		this.dni = dniUsuario(boleta.getUsuario());
		this.ubicacion_cine = ubicacionCine(boleta.getSala().getCine());
		this.asientos = asiento(boleta.getAsientos());
	}
	
	
	private List<AsientoInfo> asiento(List<Asiento> asientos) {
	    List<AsientoInfo> asientoInfoList = new ArrayList<>();
	    for (Asiento asiento : asientos) {
	        AsientoInfo asientoInfo = new AsientoInfo();
	        asientoInfo.setIdAsiento(asiento.getIdAsiento());
	        asientoInfo.setFila(asiento.getFila());
	        asientoInfo.setColumna(asiento.getColumna());
	        asientoInfoList.add(asientoInfo);
	    }
	    return asientoInfoList;
	}

	
	private String ubicacionCine(Cine cine) {
		String ubicacion = cine.getUbicacion();
		return ubicacion;
	}
	
	private Integer identificadorSala(Sala sala) {
		Integer codigo = sala.getIdSala();
		return codigo;
	}
	
	private String nombreUsuario(Usuario usuario) {
		String nombre =  usuario.getNombre();
		return nombre;
	}
	
	private String dniUsuario(Usuario usuario) {
		String dni = usuario.getDni();
		return dni;
	}

	public Integer getId_boleta() {
		return id_boleta;
	}

	public void setId_boleta(Integer id_boleta) {
		this.id_boleta = id_boleta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getSub_total() {
		return sub_total;
	}

	public void setSub_total(Double sub_total) {
		this.sub_total = sub_total;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getCodigo_sala() {
		return codigo_sala;
	}

	public void setCodigo_sala(Integer codigo_sala) {
		this.codigo_sala = codigo_sala;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getUbicacion_cine() {
		return ubicacion_cine;
	}

	public void setUbicacion_cine(String ubicacion_cine) {
		this.ubicacion_cine = ubicacion_cine;
	}

	public List<AsientoInfo> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<AsientoInfo> asientos) {
		this.asientos = asientos;
	}
	
}
