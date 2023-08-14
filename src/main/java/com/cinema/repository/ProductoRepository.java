package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{}
