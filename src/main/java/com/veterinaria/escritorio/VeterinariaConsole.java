package com.veterinaria.escritorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.veterinaria.entity.Atencion;
import com.veterinaria.entity.Inventario;
import com.veterinaria.entity.Mascota;
import com.veterinaria.service.AtencionService;
import com.veterinaria.service.InventarioService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class VeterinariaConsole implements CommandLineRunner {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private AtencionService atencionService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Parte 1: Verificar stock
        System.out.println("Indique el id de sucursal:");
        Long sucursalId = scanner.nextLong();
        scanner.nextLine(); // Consumir la línea residual para evitar problemas de buffer

        System.out.println("Indique el id del producto:");
        Long productoId = scanner.nextLong();
        scanner.nextLine(); // Consumir la línea residual para evitar problemas de buffer

        verificarStock(sucursalId, productoId);

        // Parte 2: Verificar citas de revisión
        System.out.println("Indique la fecha (YYYY-MM-DD):");
        String fechaStr = scanner.next();
        LocalDate fecha = LocalDate.parse(fechaStr);

        verificarRevisiones(fecha);
    }

    private void verificarStock(Long sucursalId, Long productoId) {
        Inventario inventario = inventarioService.findBySucursalAndProducto(sucursalId, productoId);
        if (inventario != null) {
            int stockMinimo = inventario.getTipoProducto().getDescripcion().equals("Remedio") ? 15 : 5;
            if (inventario.getExistencia() < stockMinimo) {
                System.out.println("Advertencia: El producto " + inventario.getNombre() + " tiene un stock bajo (" + inventario.getExistencia() + " unidades). Reposición inmediata requerida.");
            } else {
                System.out.println("El stock del producto " + inventario.getNombre() + " es suficiente (" + inventario.getExistencia() + " unidades).");
            }
        } else {
            System.out.println("Producto no encontrado en la sucursal indicada.");
        }
    }

    private void verificarRevisiones(LocalDate fecha) {
        List<Atencion> atenciones = atencionService.findByFechaProximaRevision(fecha);
        if (atenciones.isEmpty()) {
            System.out.println("No hay revisiones programadas para la fecha " + fecha);
        } else {
            atenciones.forEach(atencion -> {
                Mascota mascota = atencion.getMascota();
                System.out.println("La mascota " + mascota.getNombre() + " debe tener una cita de revisión el " + fecha);
            });
        }
    }
}
