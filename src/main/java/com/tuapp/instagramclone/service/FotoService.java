package com.tuapp.instagramclone.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.tuapp.instagramclone.model.Foto;
import com.tuapp.instagramclone.repository.FotoRepository;

@Service
public class FotoService {

    private final FotoRepository fotoRepository;

    public FotoService(FotoRepository fotoRepository) {
        this.fotoRepository = fotoRepository;
    }

    public List<Foto> obtenerTodas() {
        return fotoRepository.findAll();
    }

    public Foto obtenerPorId(Long id) {
        return fotoRepository.findById(id).orElse(null);
    }
}