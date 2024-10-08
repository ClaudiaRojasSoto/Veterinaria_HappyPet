package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.entity.Inventario;
import com.veterinaria.repository.InventarioRepository;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public List<Inventario> findAll(){
        return inventarioRepository.findAll();
    }

    public Optional<Inventario> findById(Long id){
        return inventarioRepository.findById(id);
    }

    public Inventario save(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public void deleteById(Long id) {
        inventarioRepository.deleteById(id);
    }

    public List<Inventario> findBySucursalId(Long sucursalId) {
        return inventarioRepository.findBySucursalId(sucursalId);
    }
    
    public Inventario findBySucursalAndProducto(Long sucursalId, Long productoId) {
        Optional<Inventario> inventario = inventarioRepository.findBySucursalIdAndId(sucursalId, productoId);
        return inventario.orElse(null);
    }
}
