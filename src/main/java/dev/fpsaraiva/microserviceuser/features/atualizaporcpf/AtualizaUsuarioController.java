package dev.fpsaraiva.microserviceuser.features.atualizaporcpf;

import dev.fpsaraiva.microserviceuser.entity.Usuario;
import dev.fpsaraiva.microserviceuser.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class AtualizaUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PersistenceContext
    private EntityManager em;

    @PutMapping("/api/usuario/{id}")
    @Transactional
    public ResponseEntity<UsuarioAtualizadoResponse> atualizaPorId(@PathVariable Long id,
                                           @RequestBody @Valid AtualizaUsuarioRequest request) {
        Optional<Usuario> usuarioBuscado = usuarioRepository.findById(id);
        Usuario usuario = usuarioBuscado.get();

        usuario.setNome(request.getNome());
        usuario.setEndereco(request.getEndereco());
        usuario.setTelefone(request.getTelefone());

        em.merge(usuario);

        return new ResponseEntity<>(new UsuarioAtualizadoResponse(usuario), HttpStatus.OK);
    }
}
