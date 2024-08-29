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
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="medico_id", nullable=false)
	private Long id;
	@Column(name="medico_rut",nullable=false, unique=true)
	private String rut;
	@Column(name="medico_nombre",nullable=false)
	private String nombre;
	@Column(name="medico_apellidos",nullable=false)
	private String apellidos;
	@Column(name="medico_email",nullable=false)
	private String email;
	@OneToMany(mappedBy="medico",cascade=CascadeType.ALL)
	private List<Atencion> atenciones;
	
	public List<Atencion> getAtenciones() {
		return atenciones;
	}
	public void setAtenciones(List<Atencion> atenciones) {
		this.atenciones = atenciones;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
