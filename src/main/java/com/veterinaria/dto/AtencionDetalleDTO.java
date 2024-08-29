package com.veterinaria.dto;

import java.time.LocalDateTime;

public class AtencionDetalleDTO {
    private String sucursalNombre;
    private String medicoNombre;
    private String tipoAtencionDescripcion;
    private String mascotaNombre;
    private String duenoNombre;
    private LocalDateTime fechaRealizacion;
    private String boxAtencion;

    // Constructor por defecto
    public AtencionDetalleDTO() {}

    // Constructor con todos los campos
    public AtencionDetalleDTO(String sucursalNombre, String medicoNombre, String tipoAtencionDescripcion, 
                              String mascotaNombre, String duenoNombre, LocalDateTime fechaRealizacion, 
                              String boxAtencion) {
        this.sucursalNombre = sucursalNombre;
        this.medicoNombre = medicoNombre;
        this.tipoAtencionDescripcion = tipoAtencionDescripcion;
        this.mascotaNombre = mascotaNombre;
        this.duenoNombre = duenoNombre;
        this.fechaRealizacion = fechaRealizacion;
        this.boxAtencion = boxAtencion;
    }

    // Getters y Setters
    public String getSucursalNombre() {
        return sucursalNombre;
    }

    public void setSucursalNombre(String sucursalNombre) {
        this.sucursalNombre = sucursalNombre;
    }

    public String getMedicoNombre() {
        return medicoNombre;
    }

    public void setMedicoNombre(String medicoNombre) {
        this.medicoNombre = medicoNombre;
    }

    public String getTipoAtencionDescripcion() {
        return tipoAtencionDescripcion;
    }

    public void setTipoAtencionDescripcion(String tipoAtencionDescripcion) {
        this.tipoAtencionDescripcion = tipoAtencionDescripcion;
    }

    public String getMascotaNombre() {
        return mascotaNombre;
    }

    public void setMascotaNombre(String mascotaNombre) {
        this.mascotaNombre = mascotaNombre;
    }

    public String getDuenoNombre() {
        return duenoNombre;
    }

    public void setDuenoNombre(String duenoNombre) {
        this.duenoNombre = duenoNombre;
    }

    public LocalDateTime getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDateTime fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public String getBoxAtencion() {
        return boxAtencion;
    }

    public void setBoxAtencion(String boxAtencion) {
        this.boxAtencion = boxAtencion;
    }
}
