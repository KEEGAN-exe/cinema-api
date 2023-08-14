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

import com.cinema.entity.Producto;
import com.cinema.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
 
	@Autowired
	private ProductoService productoService;
	
	public ProductoController() {}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		return new ResponseEntity<>(productoService.findAll(),HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Producto producto){
		productoService.insert(producto);
		return new ResponseEntity<>("Producto registrado", HttpStatus.OK);
	}
	
	@PatchMapping("/editar/{idProducto}")
	public ResponseEntity<?> editar_PATCH(@PathVariable Integer idProducto, @RequestBody Producto newProducto){
		Producto oldProducto = productoService.findById(idProducto);
		if(oldProducto != null) {
			if( newProducto.getNombreProducto() != null ) {
				oldProducto.setNombreProducto(newProducto.getNombreProducto());
			}if(newProducto.getDescripcion() != null) {
				oldProducto.setDescripcion(newProducto.getDescripcion());
			}if(newProducto.getPrecio() != null) {
				oldProducto.setPrecio(newProducto.getPrecio());
			}
			
			productoService.update(oldProducto);
			return new ResponseEntity<>("Producto actualizado",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Producto " + idProducto + " no encontrado",HttpStatus.OK);
	}
	
	@DeleteMapping("/borrar/{idProducto}")
	public ResponseEntity<?> eliminar_DELETE(@PathVariable Integer idProducto){
		Producto producto = productoService.findById(idProducto);
		if(producto != null) {
			return new ResponseEntity<>("Producto eliminado",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Producto " + idProducto + " no encontrado",HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{idProducto}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer idProducto){
		Producto producto = productoService.findById(idProducto);
		if(producto != null) {
			return new ResponseEntity<>(producto, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Producto " + idProducto + " no encontrado",HttpStatus.OK);
	}
}
