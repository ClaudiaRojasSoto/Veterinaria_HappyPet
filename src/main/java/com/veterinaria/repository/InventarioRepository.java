package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veterinaria.entity.Inventario;
import java.util.List;
import java.util.Optional;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    List<Inventario> findBySucursalId(Long sucursalId);
    Optional<Inventario> findBySucursalIdAndId(Long sucursalId, Long productoId);
}
