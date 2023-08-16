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

import com.cinema.entity.Asiento;
import com.cinema.entity.Boleta;
import com.cinema.service.AsientoService;
import com.cinema.service.BoletaService;

@RestController
@RequestMapping("/boleta_asiento")
public class BoletaAsientoController {
	
	@Autowired
	private BoletaService boletaService;
	
	@Autowired
	private AsientoService asientoService;
	
	public BoletaAsientoController() {}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		return new ResponseEntity<>(boletaService.findAllWithNames(),HttpStatus.OK);
	}
	
	@PostMapping("/registrar/{idBoleta}/{idAsiento}")
	public ResponseEntity<?> registrar_POST(@PathVariable Integer idBoleta, @PathVariable Integer idAsiento){
		Boleta boleta = boletaService.findById(idBoleta);
		if( boleta != null ) {
			Asiento asiento = asientoService.findById(idAsiento);
			if(asiento != null) {
				boleta.addAsiento(asiento);
				boletaService.update(boleta);
				return new ResponseEntity<>("Asiento agregado a la boleta",HttpStatus.OK);
			}
			return new ResponseEntity<>("No se encontro el asiento",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("No se encontro la boleta",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{idBoleta}/{idAsiento}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer idBoleta, @PathVariable Integer idAsiento){
		Boleta boleta = boletaService.findById(idBoleta);
		if( boleta != null ) {
			Asiento asiento = asientoService.findById(idAsiento);
			if(asiento != null) {
				boolean removed = boleta.removeAsiento(asiento);
				if( removed ) {
					boletaService.update(boleta);
					return new ResponseEntity<>("Asiento eliminado de la boleta",HttpStatus.OK);
				}
				return new ResponseEntity<>("Asiento no asociado a la boleta",HttpStatus.OK);
			}
			return new ResponseEntity<>("No se encontro el asiento",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("No se encontro la boleta",HttpStatus.NOT_FOUND);
	}
	
}
