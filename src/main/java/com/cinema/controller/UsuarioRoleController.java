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

import com.cinema.entity.Rol;
import com.cinema.entity.Usuario;
import com.cinema.service.RolService;
import com.cinema.service.UsuarioService;

@RestController
@RequestMapping("/usuario_rol")
public class UsuarioRoleController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		return new ResponseEntity<>(usuarioService.findAllWithNames(),HttpStatus.OK);
	}
	
	@PostMapping("/registrar/{idUsuario}/{idRol}")
	public ResponseEntity<?> registrar_POST(@PathVariable Integer idUsuario, @PathVariable Integer idRol){
		Usuario usuario = usuarioService.findById(idUsuario);
		if( usuario != null ) {
			Rol rol = rolService.findById(idRol);
			if(rol != null) {
				usuario.addRol(rol);
				usuarioService.update(usuario);
				return new ResponseEntity<>("Rol agregado al usuario",HttpStatus.OK);
			}
			return new ResponseEntity<>("No se encontro el rol",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("No se encontro el usuario",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idUsuario}/{idRol}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer idUsuario, @PathVariable Integer idRol){
		Usuario usuario = usuarioService.findById(idUsuario);
		if( usuario != null ) {
			Rol rol = rolService.findById(idRol);
			if(rol != null) {
				boolean removed = usuario.removeRol(rol);
				if(removed) {
					usuarioService.update(usuario);
					return new ResponseEntity<>("Rol eliminado del usuario",HttpStatus.OK);
				}else {
					return new ResponseEntity<>("Rol no asociado al usuario",HttpStatus.OK);
				}
			}
			return new ResponseEntity<>("No se encontro el rol",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("No se encontro el usuario",HttpStatus.NOT_FOUND);
	}
}
