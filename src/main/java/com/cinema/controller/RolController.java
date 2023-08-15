package com.cinema.controller;

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

import com.cinema.entity.Rol;
import com.cinema.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {

	@Autowired
	private RolService rolService;
	
	public RolController() {}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET() {
		return new ResponseEntity<>(rolService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Rol rol){
		rolService.insert(rol);
		return new ResponseEntity<>("Rol registrado",HttpStatus.OK);
	}
	
	@PatchMapping("/editar/{idRol}")
	public ResponseEntity<?> editar_PATCH(@PathVariable Integer idRol, @RequestBody Rol newRol){
		Rol oldRol = rolService.findById(idRol);
		if( oldRol != null) {
			if(newRol.getNombreRol() != null) {
				oldRol.setNombreRol(newRol.getNombreRol());
			}
			
			rolService.update(oldRol);
			
			return new ResponseEntity<>("Rol actualizado", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Rol " + idRol + " no encontrado", HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/borrar/{idRol}")
	public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer idRol){
		Rol rol = rolService.findById(idRol);
		if(rol != null) {
			rolService.delete(idRol);
			return new ResponseEntity<>("Rol eliminado",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Rol " + idRol + " no encontrado", HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/buscar/{idRol}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer idRol){
		Rol rol = rolService.findById(idRol);
		if(rol != null) {
			return new ResponseEntity<>(rol,HttpStatus.OK);
		}
		return new ResponseEntity<>("Rol " + idRol + " no encontrado", HttpStatus.NO_CONTENT);
	}
}
