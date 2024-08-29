package com.veterinaria.api.controller;

import com.veterinaria.dto.MedicoDTO;
import com.veterinaria.entity.Medico;
import com.veterinaria.service.MedicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/medicos")
public class MedicoApiController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> getAllMedicos() {
        List<Medico> medicos = medicoService.findAll();
        List<MedicoDTO> medicoDTOs = medicos.stream()
                .map(medico -> modelMapper.map(medico, MedicoDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(medicoDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> getMedicoById(@PathVariable Long id) {
        Optional<Medico> medico = medicoService.findById(id);
        if (medico.isPresent()) {
            MedicoDTO medicoDTO = modelMapper.map(medico.get(), MedicoDTO.class);
            return new ResponseEntity<>(medicoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<MedicoDTO> save(@RequestBody MedicoDTO medicoDTO) {
        // Convertir MedicoDTO a la entidad Medico usando ModelMapper
        Medico medico = modelMapper.map(medicoDTO, Medico.class);
        
        // Guardar el objeto Medico usando el servicio
        Medico savedMedico = medicoService.save(medico);
        
        // Convertir la entidad guardada de nuevo a MedicoDTO
        MedicoDTO savedMedicoDTO = modelMapper.map(savedMedico, MedicoDTO.class);
        
        // Devolver la respuesta con el DTO guardado y el estado HTTP 201 Created
        return new ResponseEntity<>(savedMedicoDTO, HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> updateMedico(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO) {
        Optional<Medico> existingMedico = medicoService.findById(id);
        if (existingMedico.isPresent()) {
            Medico medico = modelMapper.map(medicoDTO, Medico.class);
            medico.setId(id);
            Medico updatedMedico = medicoService.save(medico);
            MedicoDTO updatedMedicoDTO = modelMapper.map(updatedMedico, MedicoDTO.class);
            return new ResponseEntity<>(updatedMedicoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        Optional<Medico> medico = medicoService.findById(id);
        if (medico.isPresent()) {
            medicoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
