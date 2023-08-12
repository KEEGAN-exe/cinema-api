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

import com.cinema.entity.Director;
import com.cinema.service.DirectorService;


@RestController
@RequestMapping("/director")
public class DirectorController {

	@Autowired
	private DirectorService directorService;
	
	public DirectorController() {}
	
	@GetMapping("/listar")
	private ResponseEntity<?> listar_GET(){
		Collection<Director> director = directorService.findAll();
		if(director != null) {
			return new ResponseEntity<>(director,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/registrar")
	private ResponseEntity<?> registrar_POST(@RequestBody Director director){
		directorService.insert(director);
		return new ResponseEntity<>("Director registrado",HttpStatus.OK);
	}
	
	@PatchMapping("/editar/{idDirector}")
	private ResponseEntity<?> editar_PATCH(@PathVariable Integer idDirector, @RequestBody Director newDirector){
		Director oldDirector = directorService.findById(idDirector);
		if(oldDirector != null) {
			if(newDirector.getNombreDirector() != null) {
				oldDirector.setNombreDirector(newDirector.getNombreDirector());
			}
			
			directorService.update(oldDirector);
			
			return new ResponseEntity<>("Director actualizado", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Director " + idDirector + " no encontrado", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idDirector}")
	private ResponseEntity<?> eliminar_DELETE(@PathVariable Integer idDirector){
		Director director = directorService.findById(idDirector);
		if( director != null ) {
			directorService.delete(idDirector);
			return new ResponseEntity<>("Director eliminado", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Director " + idDirector + " no encontrado", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{idDirector}")
	private ResponseEntity<?> buscar_GET(@PathVariable Integer idDirector){
		Director director = directorService.findById(idDirector);
		if(director != null) {
			return new ResponseEntity<>(director,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Director " + idDirector + " no encontrado", HttpStatus.NOT_FOUND);
	}
}
