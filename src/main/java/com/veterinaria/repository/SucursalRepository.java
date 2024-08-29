package com.veterinaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.entity.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long>{
	List<Sucursal> findByOrderByNombreAsc();
}
