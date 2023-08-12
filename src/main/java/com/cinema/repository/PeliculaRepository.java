package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{}
