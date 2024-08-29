package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.entity.TipoProducto;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long>  {

}
