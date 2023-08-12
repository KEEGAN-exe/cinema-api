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

import com.cinema.entity.Genero;
import com.cinema.service.GeneroService;


@RestController
@RequestMapping("/genero")
public class GeneroController {

	@Autowired
	private GeneroService generoService;
	
	public GeneroController() {}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		
		Collection<Genero> generos = generoService.findAll();
		if(generos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(generos,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Genero genero){
		generoService.insert(genero);
		return new ResponseEntity<>("Genero creado",HttpStatus.OK);
	}
	
	@PatchMapping("/editar/{idGenero}")
	public ResponseEntity<?> editar_PATCH(@PathVariable Integer idGenero,@RequestBody Genero newGenero){
		Genero oldGenero = generoService.findById(idGenero);
		
		if(oldGenero != null) {
			if(newGenero.getNombreGenero() != null) {
				oldGenero.setNombreGenero(newGenero.getNombreGenero());
			}
			generoService.update(oldGenero);
			return new ResponseEntity<>(oldGenero, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("No se encontro el genero con id: " + newGenero.getIdGenero(),HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/borrar/{idGenero}")
	public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer idGenero){
		Genero findGenero = generoService.findById(idGenero);
		if(findGenero != null) {
			generoService.delete(idGenero);
			return new ResponseEntity<>("Genero borrado",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Genero no encontrado", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{idGenero}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer idGenero){
		Genero findGenero = generoService.findById(idGenero);
		if(findGenero != null) {
			return new ResponseEntity<>(findGenero,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Genero no encontrado",HttpStatus.NOT_FOUND);
	}
	
}
