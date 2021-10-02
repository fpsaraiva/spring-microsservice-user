package dev.fpsaraiva.microserviceuser.criausuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class NovoUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/api/usuario")
    public String criar(@RequestBody @Valid NovoUsuarioRequest request) {
        NovoUsuario novoUsuario = request.paraUsuario();

        usuarioRepository.save(novoUsuario);

        return request.toString();
    }
}
