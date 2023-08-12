package com.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.entity.Genero;
import com.cinema.entity.Pelicula;
import com.cinema.service.GeneroService;
import com.cinema.service.PeliculaService;

@RestController
@RequestMapping("/pelicula_genero")
public class PeliculaGeneroController {

	@Autowired
	private GeneroService generoService;
	
	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		return new ResponseEntity<>(peliculaService.findAll_withNames(),HttpStatus.OK);
	}
	
	@PostMapping("/registrar/{idPelicula}/{idGenero}")
	public ResponseEntity<?> registrar_POST(@PathVariable Integer idPelicula, @PathVariable Integer idGenero){
		Pelicula pelicula =  peliculaService.findById(idPelicula);
		if(pelicula != null) {
			Genero genero =  generoService.findById(idGenero);
			if(genero != null) {
				pelicula.addGenero(genero);
				peliculaService.update(pelicula);
				return new ResponseEntity<>("Genero agregado a la pelicula",HttpStatus.OK);
			}
			
			return new ResponseEntity<>("No se encontro el genero",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("No se encontro la pelicula",HttpStatus.NOT_FOUND);
	}
}
