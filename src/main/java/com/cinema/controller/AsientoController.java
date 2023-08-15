package com.cinema.controller;

import java.util.Collection;
import java.util.List;

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

import com.cinema.entity.Asiento;
import com.cinema.mapper.AsientoMapper;
import com.cinema.service.AsientoService;
import com.cinema.util.Mapper;

@RestController
@RequestMapping("/asiento")
public class AsientoController {

	@Autowired
	private AsientoService asientoService;
	
	public AsientoController() {}
	
	@GetMapping("/mostrar")
	public ResponseEntity<?> listar_GET(){
		return new ResponseEntity<>(asientoService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> mapper_GET(){
		Collection<AsientoMapper> mapper = Mapper.toAsiento(asientoService.findAll());
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Asiento asiento){
		asientoService.insert(asiento);
		return new ResponseEntity<>("Asiento registrado",HttpStatus.OK);
	}
	
	@PatchMapping("/editar/{idAsiento}")
	public ResponseEntity<?> editar_PATCH(@PathVariable Integer idAsiento, @RequestBody Asiento newAsiento){
		Asiento oldAsiento = asientoService.findById(idAsiento);
		if(oldAsiento != null) {
			if(newAsiento.getColumna() != null) {
				oldAsiento.setColumna(newAsiento.getColumna());
			}if(newAsiento.getFila() != null) {
				oldAsiento.setFila(newAsiento.getFila());
			}if(newAsiento.getTipo() != null) {
				oldAsiento.setTipo(newAsiento.getTipo());
			}if(newAsiento.getSala() != null) {
				oldAsiento.setSala(newAsiento.getSala());
			}if(newAsiento.getEstado() != null) {
				oldAsiento.setEstado(newAsiento.getEstado());
			}
			
			asientoService.update(oldAsiento);
			
			return new ResponseEntity<>("Asiento actualizado", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Asiento " + idAsiento + " no encontrado", HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/borrar/{idAsiento}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer idAsiento){
		Asiento asiento = asientoService.findById(idAsiento);
		if(asiento != null) {
			asientoService.delete(idAsiento);
			return new ResponseEntity<>("Asiento eliminado", HttpStatus.OK);
		}
		return new ResponseEntity<>("Asiento " + idAsiento + " no encontrado", HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/buscar/{idAsiento}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer idAsiento){
		Asiento asiento = asientoService.findById(idAsiento);
		if(asiento != null) {
			return new ResponseEntity<>(asiento, HttpStatus.OK);
		}
		return new ResponseEntity<>("Asiento " + idAsiento + " no encontrado", HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/buscar_sala/{idSala}")
	public ResponseEntity<?> buscar_sala_GET(@PathVariable Long idSala){
		List<Asiento> asiento = asientoService.findBySalaId(idSala);
		if(asiento != null) {
			return new ResponseEntity<>(asiento, HttpStatus.OK);
		}
		return new ResponseEntity<>("Asiento " + idSala + " no encontrado", HttpStatus.NO_CONTENT);
	}
}
