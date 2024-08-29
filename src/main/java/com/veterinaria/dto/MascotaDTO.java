package com.veterinaria.dto;

public class MascotaDTO {
	
	private Long id;
	private String nombre;
	private String raza;
	private Long duenoId;
	private Long generoId;
	private Long tipoMascotaId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public Long getDuenoId() {
		return duenoId;
	}
	public void setDuenoId(Long duenoId) {
		this.duenoId = duenoId;
	}
	public Long getGeneroId() {
		return generoId;
	}
	public void setGeneroId(Long generoId) {
		this.generoId = generoId;
	}
	public Long getTipoMascotaId() {
		return tipoMascotaId;
	}
	public void setTipoMascotaId(Long tipoMascotaId) {
		this.tipoMascotaId = tipoMascotaId;
	}
	
}
