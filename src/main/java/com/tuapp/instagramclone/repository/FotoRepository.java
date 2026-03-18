package com.tuapp.instagramclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tuapp.instagramclone.model.Foto;

public interface FotoRepository extends JpaRepository<Foto, Long> {
}