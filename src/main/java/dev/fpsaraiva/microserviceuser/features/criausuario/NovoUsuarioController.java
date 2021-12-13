package dev.fpsaraiva.microserviceuser.features.criausuario;

import dev.fpsaraiva.microserviceuser.dto.request.NovoUsuarioRequest;
import dev.fpsaraiva.microserviceuser.dto.response.NovoUsuarioResponse;
import dev.fpsaraiva.microserviceuser.entity.Usuario;
import dev.fpsaraiva.microserviceuser.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
public class NovoUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final Logger logger = LoggerFactory.getLogger(NovoUsuarioController.class);

    @PostMapping("/api/usuario")
    public ResponseEntity<NovoUsuarioResponse> criar(@RequestBody @Valid NovoUsuarioRequest request,
                                                     UriComponentsBuilder uriComponentsBuilder) {
        Usuario novoUsuario = request.paraUsuario();

        usuarioRepository.save(novoUsuario);
        logger.info("Usuário 'id={}' criado com SUCESSO.", novoUsuario.getId());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/api/usuario/{id}").buildAndExpand(novoUsuario.getId()).toUri());

        return new ResponseEntity<>(new NovoUsuarioResponse(novoUsuario), responseHeaders, HttpStatus.CREATED);
    }
}
