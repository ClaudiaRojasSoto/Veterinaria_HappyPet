package com.veterinaria.controller;

import com.veterinaria.entity.Dueno;
import com.veterinaria.service.DuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dueno")
public class DuenoController {

    @Autowired
    private DuenoService duenoService;

    @GetMapping("/registro")
    public String showRegistrationForm(Model model) {
        model.addAttribute("dueno", new Dueno());
        return "dueno/registro";
    }

    @PostMapping("/registro")
    public String registerDueno(@ModelAttribute Dueno dueno) {
        duenoService.save(dueno);
        return "redirect:/dueno/lista";
    }

    @GetMapping("/lista")
    public String listDuenos(Model model) {
        model.addAttribute("duenos", duenoService.findAll());
        return "dueno/lista";
    }
}
