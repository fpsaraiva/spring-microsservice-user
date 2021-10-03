package dev.fpsaraiva.microserviceuser.buscaporcpf;

import dev.fpsaraiva.microserviceuser.entity.Usuario;
import dev.fpsaraiva.microserviceuser.listausuarios.UsuarioResponse;
import dev.fpsaraiva.microserviceuser.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BuscaUsuarioPorCpf {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/api/usuario/{cpf}")
    public ResponseEntity<?> buscaPorId(@PathVariable String cpf) {
        Optional<Usuario> usuarioBuscado = usuarioRepository.findByCpf(cpf);

        if(usuarioBuscado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        UsuarioResponse usuario = new UsuarioResponse(usuarioBuscado.get());

        return ResponseEntity.ok(usuario);
    }
}
