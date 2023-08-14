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

import com.cinema.entity.Cine;
import com.cinema.service.CineService;

@RestController
@RequestMapping("/cine")
public class CineController {

	@Autowired
	private CineService cineService;
	
	public CineController() {}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Cine> cine = cineService.findAll(); 
		return new ResponseEntity<>(cine,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Cine cine){
		cineService.insert(cine);
		return new ResponseEntity<>("Cine agregado", HttpStatus.OK);
	}
	
	@PatchMapping("/editar/{idCine}")
	public ResponseEntity<?> editar_PATCH(@PathVariable Integer idCine, @RequestBody Cine newCine){
		Cine oldCine = cineService.findById(idCine);
		if(oldCine != null) {
			if(newCine.getUbicacion() != null) {
				oldCine.setUbicacion(newCine.getUbicacion());
			}if(newCine.getTelefono() != null) {
				oldCine.setTelefono(newCine.getTelefono());
			}
			
			cineService.update(oldCine);
			
			return new ResponseEntity<>("Cine actualizado",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Cine " + idCine + " no encontrada",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idCine}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer idCine){
		Cine cine = cineService.findById(idCine);
		if(cine != null) {
			cineService.delete(idCine);
			
			return new ResponseEntity<>("Cine eliminado",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Cine " + idCine + " no encontrada",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{idCine}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer idCine){
		Cine cine = cineService.findById(idCine);
		if(cine != null) {
			return new ResponseEntity<>(cine,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Cine " + idCine + " no encontrada",HttpStatus.NOT_FOUND);
	}
}
