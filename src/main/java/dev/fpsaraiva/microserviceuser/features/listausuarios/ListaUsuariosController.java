package dev.fpsaraiva.microserviceuser.features.listausuarios;

import dev.fpsaraiva.microserviceuser.dto.UsuarioResponse;
import dev.fpsaraiva.microserviceuser.repository.UsuarioRepository;
import dev.fpsaraiva.microserviceuser.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListaUsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/api/usuarios")
    public ResponseEntity<?> lista(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 5) Pageable page) {
        Page<Usuario> usuariosCadastrados =  usuarioRepository.findAll(page);

        return ResponseEntity.ok(UsuarioResponse.toList(usuariosCadastrados).getContent());
    }
}
