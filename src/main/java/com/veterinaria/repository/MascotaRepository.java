package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.entity.Mascota;


public interface MascotaRepository extends JpaRepository<Mascota, Long>{

}
