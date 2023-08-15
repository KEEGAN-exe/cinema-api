package com.cinema.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "boletas")
public class Boleta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBoleta;
	@Column(nullable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd", iso=ISO.DATE)
	private LocalDate fecha;
	@Column(nullable = false)
	private Double igv;
	@Column(nullable = false)
	private Double subTotal;
	@Column(nullable = false)
	private Double total;
	@Column(nullable = false)
	private String estado;
	@OneToMany(mappedBy = "boleta")
	@JsonIgnore
	private List<Detalle>  detalles;
	
	@ManyToOne
	@JoinColumn(name = "id_sala",nullable = false)
	private Sala sala;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario",nullable = false)
	private Usuario usuario;
	
	@ManyToMany
    @JoinTable(
        name = "boleta_asiento",
        joinColumns = @JoinColumn(name = "id_boleta"),
        inverseJoinColumns = @JoinColumn(name = "id_asiento")
    )
    private List<Asiento> asientos;
		
	public Boleta() {}

	public Boleta(Integer idBoleta, LocalDate fecha, Double igv, Double subTotal, Double total, String estado,
			List<Detalle> detalles, Sala sala, Usuario usuario) {
		this.idBoleta = idBoleta;
		this.fecha = fecha;
		this.igv = igv;
		this.subTotal = subTotal;
		this.total = total;
		this.estado = estado;
		this.detalles = detalles;
		this.sala = sala;
		this.usuario = usuario;
	}
	
	@PrePersist
	public void prePersiste() {
		fecha = LocalDate.now();
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public Integer getIdBoleta() {
		return idBoleta;
	}

	public void setIdBoleta(Integer idBoleta) {
		this.idBoleta = idBoleta;
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

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}
}
