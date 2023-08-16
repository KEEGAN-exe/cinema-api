package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.entity.Pelicula;
import com.cinema.entity.Sala;
import com.cinema.service.PeliculaService;
import com.cinema.service.SalaService;

@RestController
@RequestMapping("/sala_pelicula")
public class SalaPeliculaController {

	@Autowired
	private SalaService salaService;
	
	@Autowired
	private PeliculaService peliculaService;
	
	public SalaPeliculaController() {}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		return new ResponseEntity<>(salaService.findAllWithNames(),HttpStatus.OK);
	}
	
	@PostMapping("/registrar/{idSala}/{idPelicula}")
	public ResponseEntity<?> registrar_POST(@PathVariable Integer idSala, @PathVariable Integer idPelicula){
		Sala sala = salaService.findById(idSala);
		if(sala != null) {
			Pelicula pelicula = peliculaService.findById(idPelicula);
			if(pelicula != null) {
				sala.addPelicula(pelicula);
				salaService.update(sala);
				return new ResponseEntity<>("Pelicula agregada a la sala",HttpStatus.OK);
			}
			
			return new ResponseEntity<>("Pelicula no encontrada", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("Sala no encontrada", HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/borrar/{idSala}/{idPelicula}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer idSala, @PathVariable Integer idPelicula){
		Sala sala = salaService.findById(idSala);
		if(sala != null) {
			Pelicula pelicula = peliculaService.findById(idPelicula);
			if(pelicula != null) {
				boolean removed = sala.removePelicula(pelicula);
				if(removed) {
					salaService.update(sala);
					return new ResponseEntity<>("Pelicula eliminada de la sala",HttpStatus.OK);
				}else {
					return new ResponseEntity<>("Pelicula no asociada a la sala",HttpStatus.OK);
				}
			}
			
			return new ResponseEntity<>("Pelicula no encontrada", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("Sala no encontrada", HttpStatus.NO_CONTENT);
	}
	
}
