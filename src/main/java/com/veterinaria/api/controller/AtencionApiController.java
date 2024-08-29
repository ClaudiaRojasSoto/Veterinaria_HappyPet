package com.veterinaria.api.controller;


import com.veterinaria.entity.Atencion;
import com.veterinaria.service.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/atenciones")
public class AtencionApiController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping("/lista")
    public List<Atencion> listarAtenciones(
            @RequestParam(required = false) Long sucursalId,
            @RequestParam(required = false) Long tipoAtencionId) {

        // Reutiliza el servicio para buscar las atenciones basadas en los filtros proporcionados
        return atencionService.buscarAtenciones(sucursalId, tipoAtencionId);
    }
}
