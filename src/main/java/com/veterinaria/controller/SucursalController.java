package com.veterinaria.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.veterinaria.dto.SucursalDTO;
import com.veterinaria.service.SucursalService;

@Controller
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<SucursalDTO> obtenerSucursales() {
        return sucursalService.obtenerSucursalesOrdenadas()
                              .stream()
                              .map(sucursal -> modelMapper.map(sucursal, SucursalDTO.class))
                              .collect(Collectors.toList());
    }
}
