package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.entity.TipoAtencion;
import com.veterinaria.repository.TipoAtencionRepository;

@Service
public class TipoAtencionService {

    @Autowired
    private TipoAtencionRepository tipoAtencionRepository;

    public List<TipoAtencion> findAll() {
        return tipoAtencionRepository.findAll();
    }

    public Optional<TipoAtencion> findById(Long id) {
        return tipoAtencionRepository.findById(id);
    }

    public TipoAtencion save(TipoAtencion tipoAtencion) {
        return tipoAtencionRepository.save(tipoAtencion);
    }

    public void deleteById(Long id) {
        tipoAtencionRepository.deleteById(id);
    }

    public List<TipoAtencion> obtenerTiposDeAtencionOrdenados() {
        return tipoAtencionRepository.findAllByOrderByDescripcionAsc();
    }
}
