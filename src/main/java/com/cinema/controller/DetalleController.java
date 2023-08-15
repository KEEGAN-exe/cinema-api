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

import com.cinema.entity.Detalle;
import com.cinema.mapper.DetalleMapper;
import com.cinema.service.DetalleService;
import com.cinema.util.Mapper;

@RestController
@RequestMapping("/detalle")
public class DetalleController {

	@Autowired
	private DetalleService detalleService;
	
	public DetalleController() {}
	
	@GetMapping("/mostrar")
	public ResponseEntity<?> listar_GET(){
		Collection<Detalle> detalle = detalleService.findAll();
		if(detalle != null) {
			return new ResponseEntity<>(detalle,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> mapper_GET(){
		Collection<DetalleMapper> detalle = Mapper.toDetalle(detalleService.findAll());
		if(detalle != null) {
			return new ResponseEntity<>(detalle,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Detalle detalle){
		detalleService.insert(detalle);
		return new ResponseEntity<>("Detalle Registrado", HttpStatus.OK);
	}
	
	@PatchMapping("/editar/{idDetalle}")
	public ResponseEntity<?> editar_PATCH(@PathVariable Integer idDetalle, @RequestBody Detalle newDetalle){
		Detalle oldDetalle = detalleService.findById(idDetalle);
		if(oldDetalle != null) {
			if(newDetalle.getPrecio_unitario() != null) {
				oldDetalle.setPrecio_unitario(newDetalle.getPrecio_unitario());
			}if(newDetalle.getCantidad() != null) {
				oldDetalle.setCantidad(newDetalle.getCantidad());
			}if(newDetalle.getBoleta() != null) {
				oldDetalle.setBoleta(newDetalle.getBoleta());
			}if(newDetalle.getProducto() != null) {
				oldDetalle.setProducto(newDetalle.getProducto());
			}
			
			detalleService.update(oldDetalle);
			
			return new ResponseEntity<>("Detalle actualizado", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Detalle " + idDetalle + " no encontrado",HttpStatus.OK);
	}
	
	@DeleteMapping("/borrar/{idDetalle}")
	public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer idDetalle){
		Detalle detalle = detalleService.findById(idDetalle);
		if(detalle != null) {
			detalleService.delete(idDetalle);
			return new ResponseEntity<>("Detalle eliminado", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Detalle " + idDetalle + " no encontrado",HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idBoleta}")
	public ResponseEntity<?> buscar_GET(@PathVariable Long idBoleta){
		List<Detalle> detalle = detalleService.findByBoletaId(idBoleta);
		if(detalle != null) {
			return new ResponseEntity<>(detalle,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Detalle " + idBoleta + " no encontrado",HttpStatus.OK);
	}
}
