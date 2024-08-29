package com.veterinaria.controller;

import com.veterinaria.entity.Medico;
import com.veterinaria.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/registro")
    public String showRegistroMedicoForm(Model model) {
        model.addAttribute("medico", new Medico());
        return "medico/registro";
    }

    @PostMapping("/registro")
    public String registrarMedico(@ModelAttribute Medico medico) {
        medicoService.save(medico);
        return "redirect:/medico/lista";
    }

    @GetMapping("/lista")
    public String listarMedicos(Model model) {
        model.addAttribute("medicos", medicoService.findAll());
        return "medico/lista"; 
    }
}
