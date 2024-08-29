package com.veterinaria.api.controller;

import com.veterinaria.entity.Sucursal;
import com.veterinaria.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalApiController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/lista")
    public List<Sucursal> listarSucursales() {
        return sucursalService.obtenerSucursalesOrdenadas();
    }
}
