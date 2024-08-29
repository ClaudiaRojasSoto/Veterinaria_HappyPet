package com.veterinaria.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Atencion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="atencion_id", nullable=false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="medico_id",nullable=false)
	private Medico medico;
	@ManyToOne
	@JoinColumn(name="sucursal_id",nullable=false)
	private Sucursal sucursal;
	@ManyToOne
	@JoinColumn(name="mascota_id",nullable=false)
	private Mascota mascota;
	@ManyToOne
	@JoinColumn(name="tipo_atencion_id",nullable=false)
	private TipoAtencion tipoAtencion;
	@Column(name="fecha_realizacion",nullable=false)
	private LocalDateTime fechaRealizacion;
	@Column(name="fecha_proxima_revision",nullable=false)
	private LocalDateTime fechaProximaRevision;
	@Column(name="box_atencion",nullable=false)
	private String boxAtencion;
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
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	public TipoAtencion getTipoAtencion() {
		return tipoAtencion;
	}
	public void setTipoAtencion(TipoAtencion tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
	}
	public LocalDateTime getFechaRealizacion() {
		return fechaRealizacion;
	}
	public void setFechaRealizacion(LocalDateTime fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}
	public LocalDateTime getFechaProximaRevision() {
		return fechaProximaRevision;
	}
	public void setFechaProximaRevision(LocalDateTime fechaProximaRevision) {
		this.fechaProximaRevision = fechaProximaRevision;
	}
	public String getBoxAtencion() {
		return boxAtencion;
	}
	public void setBoxAtencion(String boxAtencion) {
		this.boxAtencion = boxAtencion;
	}
	
}
