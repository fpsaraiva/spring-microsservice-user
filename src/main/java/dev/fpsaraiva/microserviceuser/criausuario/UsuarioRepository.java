package dev.fpsaraiva.microserviceuser.criausuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<NovoUsuario, Long> {
}
