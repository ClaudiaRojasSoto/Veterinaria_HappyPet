package com.veterinaria.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mascota_id", nullable=false)
	private Long id;
	@Column(name="mascota_nombre", nullable=false)
	private String nombre;
	@Column(name="mascota_raza", nullable=false)
	private String raza;
	@ManyToOne
	@JoinColumn(name="dueno_id",nullable=false)
	private Dueno dueno;
	@ManyToOne
	@JoinColumn(name="genero_id",nullable=false)
	private Genero genero;
	@ManyToOne
	@JoinColumn(name="tipo_mascota_id",nullable=false)
	private TipoMascota tipoMascota;
	
	@OneToMany(mappedBy="mascota")
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

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public TipoMascota getTipoMascota() {
		return tipoMascota;
	}

	public void setTipoMascota(TipoMascota tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public List<Atencion> getAtencions() {
		return atenciones;
	}

	public void setAtencions(List<Atencion> atencions) {
		this.atenciones = atencions;
	}
	
	
}
