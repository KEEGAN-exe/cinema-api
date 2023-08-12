package com.cinema.util;

import java.util.ArrayList;
import java.util.Collection;

import com.cinema.entity.Pelicula;
import com.cinema.mapper.PeliculaMapper;


public class Mapper {

	public static Collection<PeliculaMapper> toPelicula(Collection<Pelicula> peliculas){
		
		Collection<PeliculaMapper> collectionPelicula = new ArrayList<>();
		for(Pelicula pelicula : peliculas) {
			PeliculaMapper mapper = new PeliculaMapper(pelicula);
			collectionPelicula.add(mapper);
		}
		
		return collectionPelicula;
		
	}
}
