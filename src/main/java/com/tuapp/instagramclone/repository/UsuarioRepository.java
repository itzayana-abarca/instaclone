package com.tuapp.instagramclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tuapp.instagramclone.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}