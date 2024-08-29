package com.veterinaria.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.entity.Atencion;

public interface AtencionRepository extends JpaRepository<Atencion, Long> {

    // Encuentra todas las atenciones por sucursal y tipo de atención
    List<Atencion> findBySucursalIdAndTipoAtencionId(Long sucursalId, Long tipoAtencionId);

    // Encuentra todas las atenciones por sucursal
    List<Atencion> findBySucursalId(Long sucursalId);

    // Encuentra todas las atenciones por tipo de atención
    List<Atencion> findByTipoAtencionId(Long tipoAtencionId);
    
    List<Atencion> findByFechaProximaRevisionBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
