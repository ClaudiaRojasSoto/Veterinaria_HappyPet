package com.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veterinaria.entity.Inventario;
import java.util.List;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    // Definición del método para encontrar inventarios por ID de sucursal
    List<Inventario> findBySucursalId(Long sucursalId);
}
