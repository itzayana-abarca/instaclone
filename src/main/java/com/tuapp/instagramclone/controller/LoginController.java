package com.tuapp.instagramclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tuapp.instagramclone.model.Usuario;
import com.tuapp.instagramclone.repository.UsuarioRepository;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Model model) {

        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getPassword().equals(password)) {
            model.addAttribute("mensaje", "Bienvenido " + email);
            return "home";
        } else {
            model.addAttribute("error", "Email o contraseña incorrectos");
            return "login";
        }
    }
}