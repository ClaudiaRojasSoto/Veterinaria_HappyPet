package com.veterinaria.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        // Agrega el nombre del usuario autenticado al modelo
        model.addAttribute("name", authentication.getName());
        return "home"; // Retorna la vista "home.html"
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Retorna la vista "login.html"
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout"; // Redirige al usuario a la página de login después de salir
    }
}
