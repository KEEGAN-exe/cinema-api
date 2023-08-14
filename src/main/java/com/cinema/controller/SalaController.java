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

import com.cinema.entity.Sala;
import com.cinema.service.SalaService;

@RestController
@RequestMapping("/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	public SalaController() {}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<Sala> sala = salaService.findAll();
		return new ResponseEntity<>(sala,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> agregar_POST(@RequestBody Sala sala){
		salaService.insert(sala);
		return new ResponseEntity<>("Sala agregada",HttpStatus.OK);
	}
	
	@PatchMapping("/editar/{idSala}")
	public ResponseEntity<?> editar_PATCH(@PathVariable Integer idSala, @RequestBody Sala newSala){
		Sala oldSala = salaService.findById(idSala);
		if(oldSala != null) {
			if(newSala.getCapacidad() != null) {
				oldSala.setCapacidad(newSala.getCapacidad());
			}if(newSala.getTipo() != null) {
				oldSala.setTipo(newSala.getTipo());
			}if(newSala.getEstado() != null) {
				oldSala.setEstado(newSala.getEstado());
			}if(newSala.getAsientos_ocupados() != null) {
				oldSala.setAsientos_ocupados(newSala.getAsientos_ocupados());
			}if(newSala.getCine() != null) {
				oldSala.setCine(newSala.getCine());
			}
			
			salaService.update(oldSala);
			return new ResponseEntity<>("Sala actualizada", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Sala " + idSala + " no econtrada", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/borrar/{idSala}")
	public ResponseEntity<?> eliminar_PATCH(@PathVariable Integer idSala){
		Sala sala = salaService.findById(idSala);
		if(sala != null) {
			salaService.delete(idSala);
			return new ResponseEntity<>("Sala eliminada", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Sala " + idSala + " no econtrada", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{idSala}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer idSala){
		Sala sala = salaService.findById(idSala);
		if( sala != null) {
			return new ResponseEntity<>(sala,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Sala " + idSala + " no econtrada", HttpStatus.NOT_FOUND);
	}
}
