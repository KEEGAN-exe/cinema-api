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

import com.cinema.entity.Pelicula;
import com.cinema.mapper.PeliculaMapper;
import com.cinema.service.PeliculaService;
import com.cinema.util.Mapper;


@RestController
@RequestMapping("/pelicula")
public class PeliculaController {

	@Autowired
	private PeliculaService peliculaService;
	
	public PeliculaController() {}
	
	@GetMapping("/listar")
	private ResponseEntity<?> listar_GET(){
		Collection<PeliculaMapper> pelicula = Mapper.toPelicula(peliculaService.findAll());
		if(pelicula != null) {
			return new ResponseEntity<>(pelicula, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
		
	@PostMapping("/registrar")
	private ResponseEntity<?> registrar_POST(@RequestBody Pelicula pelicula){
		peliculaService.insert(pelicula);
		return new ResponseEntity<>("Pelicula registrada", HttpStatus.OK);
	}
	
	@PatchMapping("/editar/{idPelicula}")
	private ResponseEntity<?> editar_PATCH(@PathVariable Integer idPelicula, @RequestBody Pelicula newPelicula){
		Pelicula oldPelicula = peliculaService.findById(idPelicula);
		if(oldPelicula != null) {
			if( newPelicula.getNombrePelicula() != null) {
				oldPelicula.setNombrePelicula(newPelicula.getNombrePelicula());
			}if(newPelicula.getSinopsis() != null) {
				oldPelicula.setSinopsis(newPelicula.getSinopsis());
			}if(newPelicula.getClasificacion() != null) {
				oldPelicula.setClasificacion(newPelicula.getClasificacion());
			}if(newPelicula.getFechaEstreno() != null) {
				oldPelicula.setFechaEstreno(newPelicula.getFechaEstreno());
			}if(newPelicula.getDirector() != null) {
				oldPelicula.setDirector(newPelicula.getDirector());
			}if(newPelicula.getDuracionMinutos() != null) {
				oldPelicula.setDuracionMinutos(newPelicula.getDuracionMinutos());
			}if(newPelicula.getPais() != null) {
				oldPelicula.setPais(newPelicula.getPais());
			}if(newPelicula.getImagenUrl() != null) {
				oldPelicula.setImagenUrl(newPelicula.getImagenUrl());
			}
			
			peliculaService.update(oldPelicula);
			
			return new ResponseEntity<>("Pelicula actualizada", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Pelicula " + idPelicula + " no encontrada", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idPelicula}")
	private ResponseEntity<?> eliminar_DELETE(@PathVariable Integer idPelicula){
		Pelicula pelicula = peliculaService.findById(idPelicula);
		if( pelicula != null) {
			peliculaService.delete(idPelicula);
			return new ResponseEntity<>("Pelicula eliminada", HttpStatus.OK);
		}
		return new ResponseEntity<>("Pelicula " + idPelicula + " no encontrada", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{idPelicula}")
	private ResponseEntity<?> buscar_GET(@PathVariable Integer idPelicula){
		Pelicula pelicula = peliculaService.findById(idPelicula);
		if( pelicula != null ) {
			PeliculaMapper mapper = new PeliculaMapper(pelicula);
			return new ResponseEntity<>(mapper, HttpStatus.OK);
		}
		return new ResponseEntity<>("Pelicula " + idPelicula + " no encontrada", HttpStatus.NOT_FOUND);
	}
}
