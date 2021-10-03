package dev.fpsaraiva.microserviceuser.listausuarios;

import dev.fpsaraiva.microserviceuser.repository.UsuarioRepository;
import dev.fpsaraiva.microserviceuser.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListaUsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/api/usuarios")
    public List<UsuarioResponse> lista() {
        List<Usuario> usuariosCadastrados =  usuarioRepository.findAll();

        return UsuarioResponse.converterEmResposta(usuariosCadastrados);
    }
}
