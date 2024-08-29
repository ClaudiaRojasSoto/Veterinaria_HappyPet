package com.veterinaria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity	
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iventario_id", nullable=false)
	private Long id;
	
	private String nombre;
	private String marca;
	@ManyToOne
	@JoinColumn(name="tipo_producto_id", nullable=false)
	private TipoProducto tipoProducto;
	@ManyToOne
	@JoinColumn(name="sucursal_id", nullable=false)
	private Sucursal  sucursal;
	@Column(name="inventario_existencia", nullable=false)
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
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public int getExistencia() {
		return existencia;
	}
	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}
	
}
