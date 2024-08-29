package com.veterinaria.dto;

public class InventarioDTO {
	
	private Long id;
	private String nombre;
	private String marca;
	private Long tipoProductoId;
	private Long sucursalId;
	private int existencia;
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Long getTipoProductoId() {
		return tipoProductoId;
	}
	public void setTipoProductoId(Long tipoProductoId) {
		this.tipoProductoId = tipoProductoId;
	}
	public Long getSucursalId() {
		return sucursalId;
	}
	public void setSucursalId(Long sucursalId) {
		this.sucursalId = sucursalId;
	}
	public int getExistencia() {
		return existencia;
	}
	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}
	
}
