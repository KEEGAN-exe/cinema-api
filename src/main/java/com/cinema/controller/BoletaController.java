package com.cinema.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.entity.Boleta;
import com.cinema.mapper.BoletaMapper;
import com.cinema.service.BoletaService;
import com.cinema.util.Mapper;

@RestController
@RequestMapping("/boleta")
public class BoletaController {

	@Autowired
	private BoletaService boletaService;
	
	public BoletaController() {}
	
	@GetMapping("/mostrar")
	public ResponseEntity<?> listar_GET() {
		return new ResponseEntity<>(boletaService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> mapper_GET() {
		Collection<BoletaMapper> mapper = Mapper.toBoleta(boletaService.findAll());
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Boleta boleta){
		boleta.setEstado("pendiente");
		boletaService.insert(boleta);
		return new ResponseEntity<>("Boleta registrada",HttpStatus.OK);
	}
	
	@PatchMapping("/editar/{idBoleta}")
	public ResponseEntity<?> editar_PATCH(@PathVariable Integer idBoleta, @RequestBody Boleta newBoleta){
		Boleta oldBoleta = boletaService.findById(idBoleta);
		if (oldBoleta != null) {
			if( newBoleta.getSubTotal() != null) {
				oldBoleta.setSubTotal(newBoleta.getSubTotal());
			}if( newBoleta.getIgv() != null) {
				oldBoleta.setIgv(newBoleta.getIgv());
			}if(newBoleta.getTotal() != null) {
				oldBoleta.setTotal(newBoleta.getTotal());
			}if(newBoleta.getFecha() != null) {
				oldBoleta.setFecha(newBoleta.getFecha());
			}if(newBoleta.getUsuario() != null) {
				oldBoleta.setUsuario(newBoleta.getUsuario());
			}if(newBoleta.getSala() != null) {
				oldBoleta.setSala(newBoleta.getSala());
			}
			
			boletaService.update(oldBoleta);
			
			return new ResponseEntity<>("Boleta actualizada", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Boleta " + idBoleta + " no encontrada", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idBoleta}")
	public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer idBoleta) {
		Boleta boleta = boletaService.findById(idBoleta);
		if( boleta != null ) {
			boletaService.delete(idBoleta);
			return new ResponseEntity<>("Boleta eliminada", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Boleta " + idBoleta + " no encontrada", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{idBoleta}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer idBoleta){
		Boleta boleta = boletaService.findById(idBoleta);
		if(boleta != null) {
			return new ResponseEntity<>(boleta,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Boleta " + idBoleta + " no encontrada", HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
