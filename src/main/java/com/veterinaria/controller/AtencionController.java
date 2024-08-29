package com.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.veterinaria.entity.Atencion;
import com.veterinaria.entity.Sucursal;
import com.veterinaria.entity.TipoAtencion;
import com.veterinaria.service.AtencionService;
import com.veterinaria.service.MascotaService;
import com.veterinaria.service.SucursalService;
import com.veterinaria.service.TipoAtencionService;

@Controller
public class AtencionController {
    
    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private TipoAtencionService tipoAtencionService;

    @Autowired
    private AtencionService atencionService;

    @GetMapping("/atencion/lista")
    public String listarAtenciones(
            @RequestParam(required = false) Long sucursalId,
            @RequestParam(required = false) Long tipoAtencionId,
            Model model) {

        List<Sucursal> sucursales = sucursalService.obtenerSucursalesOrdenadas();
        List<TipoAtencion> tiposAtencion = tipoAtencionService.obtenerTiposDeAtencionOrdenados();
        List<Atencion> atenciones = atencionService.buscarAtenciones(sucursalId, tipoAtencionId);

        model.addAttribute("sucursales", sucursales);
        model.addAttribute("tiposAtencion", tiposAtencion);
        model.addAttribute("atenciones", atenciones);

        return "atencion/lista";
    }
}
