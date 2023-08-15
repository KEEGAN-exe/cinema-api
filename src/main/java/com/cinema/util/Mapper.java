package com.cinema.util;

import java.util.ArrayList;
import java.util.Collection;

import com.cinema.entity.Asiento;
import com.cinema.entity.Boleta;
import com.cinema.entity.Detalle;
import com.cinema.entity.Pelicula;
import com.cinema.entity.Sala;
import com.cinema.entity.Usuario;
import com.cinema.mapper.AsientoMapper;
import com.cinema.mapper.BoletaMapper;
import com.cinema.mapper.DetalleMapper;
import com.cinema.mapper.PeliculaMapper;
import com.cinema.mapper.SalaMapper;
import com.cinema.mapper.UsuarioMapper;


public class Mapper {

	public static Collection<PeliculaMapper> toPelicula(Collection<Pelicula> peliculas){
		
		Collection<PeliculaMapper> collectionPelicula = new ArrayList<>();
		for(Pelicula pelicula : peliculas) {
			PeliculaMapper mapper = new PeliculaMapper(pelicula);
			collectionPelicula.add(mapper);
		}
		
		return collectionPelicula;
		
	}
	
	public static Collection<SalaMapper> toSala(Collection<Sala> salas){
		
		Collection<SalaMapper> collectionSala = new ArrayList<>();
		for(Sala sala : salas) {
			SalaMapper mapper = new SalaMapper(sala);
			collectionSala.add(mapper);
		}
		
		return collectionSala;
		
	}
	
	public static Collection<AsientoMapper> toAsiento(Collection<Asiento> asientos){
		Collection<AsientoMapper> collectionAsiento = new ArrayList<>();
		for(Asiento asiento: asientos) {
			AsientoMapper mapper = new AsientoMapper(asiento);
			collectionAsiento.add(mapper);
		}
		
		return collectionAsiento;
	}
	
	public static Collection<DetalleMapper> toDetalle(Collection<Detalle> detalles){
		Collection<DetalleMapper> collectionDetalle = new ArrayList<>();
		for(Detalle detalle: detalles) {
			DetalleMapper mapper = new DetalleMapper(detalle);
			collectionDetalle.add(mapper);
		}
		
		return collectionDetalle;
	}
	
	public static Collection<UsuarioMapper> toUsuario(Collection<Usuario> usuarios){
		Collection<UsuarioMapper> collectionUsuario = new ArrayList<>();
		for(Usuario usuario: usuarios) {
			UsuarioMapper mapper = new UsuarioMapper(usuario);
			collectionUsuario.add(mapper);
		}
		
		return collectionUsuario;
	}
	
	public static Collection<BoletaMapper> toBoleta(Collection<Boleta> boletas){
		Collection<BoletaMapper> collectionBoleta = new ArrayList<>();
		for(Boleta boleta: boletas) {
			BoletaMapper mapper = new BoletaMapper(boleta);
			collectionBoleta.add(mapper);
		}
		
		return collectionBoleta;
	}
}
