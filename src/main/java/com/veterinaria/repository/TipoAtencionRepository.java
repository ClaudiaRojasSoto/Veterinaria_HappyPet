package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.veterinaria.entity.TipoAtencion;

public interface TipoAtencionRepository extends JpaRepository<TipoAtencion, Long> {
    List<TipoAtencion> findAllByOrderByDescripcionAsc();
}
