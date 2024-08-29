package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dto.MascotaDTO;
import com.veterinaria.entity.Dueno;
import com.veterinaria.entity.Genero;
import com.veterinaria.entity.Mascota;
import com.veterinaria.entity.TipoMascota;
import com.veterinaria.repository.MascotaRepository;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;
    
    @Autowired
    private DuenoService duenoService;
    
    @Autowired
    private GeneroService generoService;
    
    @Autowired
    private TipoMascotaService tipoMascotaService;

    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> findById(Long id) {
        return mascotaRepository.findById(id);
    }

    public Mascota save(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public void deleteById(Long id) {
        mascotaRepository.deleteById(id);
    }

    // Método para convertir MascotaDTO a Mascota
    public Mascota convertirDTOaEntidad(MascotaDTO mascotaDTO) {
        Mascota mascota = new Mascota();
        mascota.setId(mascotaDTO.getId());
        mascota.setNombre(mascotaDTO.getNombre());
        mascota.setRaza(mascotaDTO.getRaza());

        // Obtener las entidades relacionadas a partir de los IDs en MascotaDTO
        Optional<Dueno> dueno = duenoService.findById(mascotaDTO.getDuenoId());
        Optional<Genero> genero = generoService.findById(mascotaDTO.getGeneroId());
        Optional<TipoMascota> tipoMascota = tipoMascotaService.findById(mascotaDTO.getTipoMascotaId());

        dueno.ifPresent(mascota::setDueno);
        genero.ifPresent(mascota::setGenero);
        tipoMascota.ifPresent(mascota::setTipoMascota);

        return mascota;
    }

    // Método para guardar la mascota a partir de MascotaDTO
    public Mascota save(MascotaDTO mascotaDTO) {
        Mascota mascota = convertirDTOaEntidad(mascotaDTO);
        return save(mascota);
    }
}
