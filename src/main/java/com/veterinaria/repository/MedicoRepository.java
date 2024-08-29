package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.entity.Medico;


public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
