package com.veterinaria.dto;

public class MedicoSucursal {
	private Long id;
	private Long medioId;
	private Long sucursalId;
	private Boolean titular;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMedioId() {
		return medioId;
	}
	public void setMedioId(Long medioId) {
		this.medioId = medioId;
	}
	public Long getSucursalId() {
		return sucursalId;
	}
	public void setSucursalId(Long sucursalId) {
		this.sucursalId = sucursalId;
	}
	public Boolean getTitular() {
		return titular;
	}
	public void setTitular(Boolean titular) {
		this.titular = titular;
	}
	
}
