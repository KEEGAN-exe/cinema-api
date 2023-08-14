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

import com.cinema.entity.Usuario;
import com.cinema.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioController() {}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		return new ResponseEntity<>(usuarioService.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Usuario usuario){
		usuarioService.insert(usuario);
		return new ResponseEntity<>("Usuario registrado",HttpStatus.OK);
	}
	
	@PatchMapping("/editar/{idUsuario}")
	public ResponseEntity<?> editar_PATCH(@PathVariable Integer idUsuario, @RequestBody Usuario newUsuario){
		Usuario oldUsuario = usuarioService.findById(idUsuario);
		if(oldUsuario != null) {
			if(newUsuario.getNombre() != null) {
				oldUsuario.setNombre(newUsuario.getNombre());
			}if(newUsuario.getTelefono() != null) {
				oldUsuario.setTelefono(newUsuario.getTelefono());
			}if(newUsuario.getDni() != null) {
				oldUsuario.setDni(newUsuario.getDni());
			}if(newUsuario.getUsuario() != null) {
				oldUsuario.setUsuario(newUsuario.getUsuario());
			}if(newUsuario.getPassword() != null) {
				oldUsuario.setPassword(newUsuario.getPassword());
			}
			
			usuarioService.update(oldUsuario);
			return new ResponseEntity<>("Usuario actualizado", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Usuario " + idUsuario + " no encontrado", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idUsuario}")
	public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer idUsuario){
		Usuario usuario = usuarioService.findById(idUsuario);
		if( usuario != null ) {
			usuarioService.delete(idUsuario);
			return new ResponseEntity<>("Usuario eliminado",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Usuario " + idUsuario + " no encontrado", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{idUsuario}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer idUsuario){
		
		Usuario usuario = usuarioService.findById(idUsuario);
		
		if(usuario != null) {
			return new ResponseEntity<>(usuario,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Usuario " + idUsuario + " no encontrado", HttpStatus.NOT_FOUND);
	}
}
