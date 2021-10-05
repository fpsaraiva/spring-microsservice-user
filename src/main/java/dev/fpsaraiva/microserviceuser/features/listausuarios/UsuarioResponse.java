package dev.fpsaraiva.microserviceuser.features.listausuarios;

import dev.fpsaraiva.microserviceuser.entity.Usuario;
import org.springframework.data.domain.Page;

public class UsuarioResponse {

    private	String nome;
    private	String cpf;
    private	String endereco;
    private	String email;
    private	String telefone;

    public UsuarioResponse(Usuario usuario) {
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.endereco = usuario.getEndereco();
        this.email = usuario.getEmail();
        this.telefone = usuario.getTelefone();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public static Page<UsuarioResponse> toList(Page<Usuario> page) {
        return page.map(UsuarioResponse::new);
    }
}
