package com.veterinaria.api.controller;

import com.veterinaria.dto.AtencionDetalleDTO;
import com.veterinaria.entity.Atencion;
import com.veterinaria.service.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/atenciones")
public class AtencionApiController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping("/lista")
    public List<AtencionDetalleDTO> listarAtenciones(
            @RequestParam(required = false) Long sucursalId,
            @RequestParam(required = false) Long tipoAtencionId) {
        List<Atencion> atenciones = atencionService.buscarAtenciones(sucursalId, tipoAtencionId);
        return atenciones.stream().map(this::convertirAtencionADetalleDTO).collect(Collectors.toList());
    }

    private AtencionDetalleDTO convertirAtencionADetalleDTO(Atencion atencion) {
        AtencionDetalleDTO dto = new AtencionDetalleDTO();
        
        if (atencion.getSucursal() != null) {
            dto.setSucursalNombre(atencion.getSucursal().getNombre());
        }
        
        if (atencion.getMedico() != null) {
            dto.setMedicoNombre(atencion.getMedico().getNombre());
        }
        
        if (atencion.getTipoAtencion() != null) {
            dto.setTipoAtencionDescripcion(atencion.getTipoAtencion().getDescripcion());
        }
        
        if (atencion.getMascota() != null) {
            dto.setMascotaNombre(atencion.getMascota().getNombre());
            if (atencion.getMascota().getDueno() != null) {
                dto.setDuenoNombre(atencion.getMascota().getDueno().getNombre());
            }
        }
        
        dto.setFechaRealizacion(atencion.getFechaRealizacion());
        dto.setBoxAtencion(atencion.getBoxAtencion());
        
        return dto;
    }

}
