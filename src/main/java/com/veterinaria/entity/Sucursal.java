package com.veterinaria.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sucursal_id", nullable=false)
	private Long id;
	@Column(name="sucursal_nombre", nullable=false)
	private String nombre;
	@Column(name="sucursal_direccion", nullable=false)
	private String direccion;
	@Column(name="sucursal_telefono", nullable=false)
	private String telefono;
	
	@OneToMany(mappedBy="sucursal",cascade=CascadeType.ALL)
	private List<MedicoSucursal> medicoSucursales;
	@OneToMany(mappedBy="sucursal",cascade=CascadeType.ALL)
	private List<Inventario> inventario;
	@OneToMany(mappedBy="sucursal",cascade=CascadeType.ALL)
	private List<Atencion> atenciones;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<MedicoSucursal> getMedicoSucursales() {
		return medicoSucursales;
	}
	public void setMedicoSucursales(List<MedicoSucursal> medicoSucursales) {
		this.medicoSucursales = medicoSucursales;
	}
	public List<Inventario> getInventario() {
		return inventario;
	}
	public void setInventario(List<Inventario> inventario) {
		this.inventario = inventario;
	}
	public List<Atencion> getAtenciones() {
		return atenciones;
	}
	public void setAtenciones(List<Atencion> atenciones) {
		this.atenciones = atenciones;
	}

}
