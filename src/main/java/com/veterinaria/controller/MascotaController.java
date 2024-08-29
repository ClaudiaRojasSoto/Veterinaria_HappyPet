package com.veterinaria.controller;

import com.veterinaria.dto.MascotaDTO;
import com.veterinaria.entity.Mascota;
import com.veterinaria.service.DuenoService;
import com.veterinaria.service.GeneroService;
import com.veterinaria.service.MascotaService;
import com.veterinaria.service.TipoMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private DuenoService duenoService;

    @Autowired
    private GeneroService generoService;

    @Autowired
    private TipoMascotaService tipoMascotaService;

    @GetMapping("/registro")
    public String showRegistroMascotaForm(Model model) {
        model.addAttribute("mascota", new MascotaDTO());
        model.addAttribute("duenos", duenoService.findAll());
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("tiposMascota", tipoMascotaService.findAll());
        return "mascota/registro";
    }

    @PostMapping("/registro")
    public String registrarMascota(@ModelAttribute MascotaDTO mascotaDTO) {
        Mascota mascota = convertDtoToEntity(mascotaDTO);
        mascotaService.save(mascota);
        return "redirect:/mascota/lista";
    }

    @GetMapping("/lista")
    public String listarMascotas(Model model) {
        model.addAttribute("mascotas", mascotaService.findAll());
        return "mascota/lista";
    }

    @GetMapping("/editar/{id}")
    public String showEditarMascotaForm(@PathVariable Long id, Model model) {
        Mascota mascota = mascotaService.findById(id).orElse(null);
        MascotaDTO mascotaDTO = convertEntityToDto(mascota);
        model.addAttribute("mascota", mascotaDTO);
        model.addAttribute("duenos", duenoService.findAll());
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("tiposMascota", tipoMascotaService.findAll());
        return "mascota/editar";
    }

    @PostMapping("/editar")
    public String editarMascota(@ModelAttribute MascotaDTO mascotaDTO) {
        Mascota mascota = convertDtoToEntity(mascotaDTO);
        mascotaService.save(mascota);
        return "redirect:/mascota/lista";
    }

    private Mascota convertDtoToEntity(MascotaDTO mascotaDTO) {
        Mascota mascota = new Mascota();
        mascota.setId(mascotaDTO.getId());
        mascota.setNombre(mascotaDTO.getNombre());
        mascota.setRaza(mascotaDTO.getRaza());
        mascota.setDueno(duenoService.findById(mascotaDTO.getDuenoId()).orElse(null));
        mascota.setGenero(generoService.findById(mascotaDTO.getGeneroId()).orElse(null));
        mascota.setTipoMascota(tipoMascotaService.findById(mascotaDTO.getTipoMascotaId()).orElse(null));
        return mascota;
    }

    private MascotaDTO convertEntityToDto(Mascota mascota) {
        MascotaDTO mascotaDTO = new MascotaDTO();
        mascotaDTO.setId(mascota.getId());
        mascotaDTO.setNombre(mascota.getNombre());
        mascotaDTO.setRaza(mascota.getRaza());
        if (mascota.getDueno() != null) {
            mascotaDTO.setDuenoId(mascota.getDueno().getId());
        }
        if (mascota.getGenero() != null) {
            mascotaDTO.setGeneroId(mascota.getGenero().getId());
        }
        if (mascota.getTipoMascota() != null) {
            mascotaDTO.setTipoMascotaId(mascota.getTipoMascota().getId());
        }
        return mascotaDTO;
    }
}
