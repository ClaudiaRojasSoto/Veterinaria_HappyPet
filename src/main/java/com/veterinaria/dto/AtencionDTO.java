package com.veterinaria.dto;

import java.time.LocalDateTime;

public class AtencionDTO {
	private Long id;
	private Long medicoId;
	private Long sucursalId;
	private Long mascotaId;
	private Long tipoAtencionId;
	private LocalDateTime fechaRealizacion;
	private LocalDateTime fechaProximaRevision;
	private String boxAtencion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMedicoId() {
		return medicoId;
	}
	public void setMedicoId(Long medicoId) {
		this.medicoId = medicoId;
	}
	public Long getSucursalId() {
		return sucursalId;
	}
	public void setSucursalId(Long sucursalId) {
		this.sucursalId = sucursalId;
	}
	public Long getMascotaId() {
		return mascotaId;
	}
	public void setMascotaId(Long mascotaId) {
		this.mascotaId = mascotaId;
	}
	public Long getTipoAtencionId() {
		return tipoAtencionId;
	}
	public void setTipoAtencionId(Long tipoAtencionId) {
		this.tipoAtencionId = tipoAtencionId;
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
