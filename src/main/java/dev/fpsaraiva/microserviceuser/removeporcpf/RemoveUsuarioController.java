package dev.fpsaraiva.microserviceuser.removeporcpf;

import dev.fpsaraiva.microserviceuser.entity.Usuario;
import dev.fpsaraiva.microserviceuser.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RemoveUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final Logger logger = LoggerFactory.getLogger(RemoveUsuarioController.class);

    @DeleteMapping("/api/usuario/{cpf}")
    public ResponseEntity<?> removePorId(@PathVariable String cpf) {
        Optional<Usuario> usuarioBuscado = usuarioRepository.findByCpf(cpf);

        if(usuarioBuscado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuario = usuarioBuscado.get();
        usuarioRepository.delete(usuario);
        logger.info("Usuário 'id={}' removido com SUCESSO.", usuario.getId());

        return ResponseEntity.ok().build();
    }

}
