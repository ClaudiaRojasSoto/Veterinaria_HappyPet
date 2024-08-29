package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.entity.Dueno;

public interface DuenoRepository extends JpaRepository<Dueno, Long>{
//podemos agregar metodos personalizados segun los requerimientos
	
	//por ejemplo si quisieramos buscar medicos por algun dato especifico
	//optional<Dueno> findByRut(String rut)
}
