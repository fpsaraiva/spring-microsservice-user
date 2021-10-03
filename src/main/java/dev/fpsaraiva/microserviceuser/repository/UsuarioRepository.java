package dev.fpsaraiva.microserviceuser.repository;

import dev.fpsaraiva.microserviceuser.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
