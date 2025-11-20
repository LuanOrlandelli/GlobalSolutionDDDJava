package com.skillbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillbridge.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}
