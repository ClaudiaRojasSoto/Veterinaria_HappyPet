package com.veterinaria.api.controller;

import com.veterinaria.dto.InventarioDTO;
import com.veterinaria.entity.Inventario;
import com.veterinaria.service.InventarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inventario")
public class InventarioApiController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/sucursal/{sucursalId}")
    public ResponseEntity<List<InventarioDTO>> getInventarioBySucursal(@PathVariable Long sucursalId) {
        List<Inventario> inventarios = inventarioService.findBySucursalId(sucursalId);
        
        List<InventarioDTO> inventarioDTOs = inventarios.stream()
            .map(inventario -> modelMapper.map(inventario, InventarioDTO.class))
            .collect(Collectors.toList());
        
        return new ResponseEntity<>(inventarioDTOs, HttpStatus.OK);
    }
}
