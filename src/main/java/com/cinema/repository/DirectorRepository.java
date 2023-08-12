package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.entity.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer>{}
