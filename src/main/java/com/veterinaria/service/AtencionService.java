package com.veterinaria.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.entity.Atencion;
import com.veterinaria.repository.AtencionRepository;

@Service
public class AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;

    // Obtener todas las atenciones
    public List<Atencion> findAll() {
        return atencionRepository.findAll();
    }

    // Obtener atención por ID
    public Optional<Atencion> findById(Long id) {
        return atencionRepository.findById(id);
    }

    // Guardar una atención
    public Atencion save(Atencion atencion) {
        return atencionRepository.save(atencion);
    }

    // Eliminar una atención por ID
    public void deleteById(Long id) {
        atencionRepository.deleteById(id);
    }

    // Buscar atenciones por sucursal y tipo de atención
    public List<Atencion> buscarAtenciones(Long sucursalId, Long tipoAtencionId) {
        if (sucursalId != null && tipoAtencionId != null) {
            return atencionRepository.findBySucursalIdAndTipoAtencionId(sucursalId, tipoAtencionId);
        } else if (sucursalId != null) {
            return atencionRepository.findBySucursalId(sucursalId);
        } else if (tipoAtencionId != null) {
            return atencionRepository.findByTipoAtencionId(tipoAtencionId);
        } else {
            return atencionRepository.findAll();
        }
    }
    
    //  para buscar todas las atenciones en un dia sin considerar las horas
    public List<Atencion> findByFechaProximaRevision(LocalDate fecha) {
        LocalDateTime startOfDay = fecha.atStartOfDay(); // 2024-08-29 00:00
        LocalDateTime endOfDay = fecha.atTime(LocalTime.MAX); // 2024-08-29 23:59:59.999
        return atencionRepository.findByFechaProximaRevisionBetween(startOfDay, endOfDay);
    }

}
