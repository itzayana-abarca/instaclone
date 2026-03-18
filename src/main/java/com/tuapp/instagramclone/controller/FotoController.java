package com.tuapp.instagramclone.controller;

import com.tuapp.instagramclone.model.Foto;
import com.tuapp.instagramclone.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
public class FotoController {

    @Autowired
    private FotoRepository fotoRepository;

    // Carpeta donde se guardarán las imágenes
    private String carpeta = "C:/Users/Lenovo/instagramclone/uploads/";

    // Mostrar formulario
    @GetMapping("/subir-foto")
    public String mostrarFormulario() {
        return "subir-foto";  // nombre del HTML en templates
    }

    // Guardar foto
    @PostMapping("/subir-foto")
    public String subirFoto(@RequestParam("archivo") MultipartFile archivo,
                            @RequestParam("descripcion") String descripcion) throws IOException {

        // Guardar archivo físicamente
        String nombreArchivo = archivo.getOriginalFilename();
        File destino = new File(carpeta + nombreArchivo);
        destino.getParentFile().mkdirs(); // Crear carpeta si no existe
        archivo.transferTo(destino);

        // Guardar información en base de datos
        Foto foto = new Foto();
        foto.setDescripcion(descripcion);
        foto.setFechaCreacion(LocalDateTime.now());
        foto.setUrl("/uploads/" + nombreArchivo);

        fotoRepository.save(foto);

        return "redirect:/subir-foto"; // vuelve al formulario
    }

    @GetMapping("/fotos")
public String verFotos(org.springframework.ui.Model model) {

    model.addAttribute("fotos", fotoRepository.findAll());

    return "fotos";
}

}