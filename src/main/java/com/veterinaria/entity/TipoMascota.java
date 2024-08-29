package com.veterinaria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoMascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tipo_mascota_id", nullable=false)
	private Long id;
	@Column(name="tipo_mascota_descripcion",nullable=false)
	private String descripcion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
