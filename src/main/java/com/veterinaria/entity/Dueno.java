package com.veterinaria.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Dueno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dueno_id", nullable=false)
	private Long id;
	@Column(name="dueno_rut", nullable=false)
	private String rut;
	@Column(name="dueno_nombre", nullable=false)
	private String nombre;
	@Column(name="dueno_apellidos", nullable=false)
	private String apellido;
	@Column(name="dueno_email", nullable=false,unique=true)
	private String email;
	
	@OneToMany(mappedBy="dueno")
	private List<Mascota> mascota;
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Mascota> getMascota() {
		return mascota;
	}
	public void setMascota(List<Mascota> mascota) {
		this.mascota = mascota;
	}
	
	
}
