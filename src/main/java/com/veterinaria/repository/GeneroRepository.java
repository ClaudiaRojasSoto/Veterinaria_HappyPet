package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.entity.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long>{
//pueden agregar metodos personalizados
}
