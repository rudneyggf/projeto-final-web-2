package com.codex.nova.events.api.repository;

import com.codex.nova.events.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
