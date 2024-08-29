package com.veterinaria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MedicoSucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="medico_sucursal_id", nullable=false)
	private Long id;
	@ManyToOne
	@JoinColumn(name="medico_id", nullable=false)
	private Medico  medico;
	@ManyToOne
	@JoinColumn(name="sucursal_id", nullable=false)
	private Sucursal  sucursal;
	private Boolean titular;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public Boolean getTitular() {
		return titular;
	}
	public void setTitular(Boolean titular) {
		this.titular = titular;
	}
	
}
