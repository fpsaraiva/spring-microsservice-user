package dev.fpsaraiva.microserviceuser.features.criausuario;

import dev.fpsaraiva.microserviceuser.entity.Usuario;

import java.time.LocalDateTime;

public class NovoUsuarioResponse {

    private Long id;
    private	String nome;
    private	String cpf;
    private	String endereco;
    private	String email;
    private	String telefone;
    private LocalDateTime dataCadastro;

    public NovoUsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.endereco = usuario.getEndereco();
        this.email = usuario.getEmail();
        this.telefone = usuario.getTelefone();
        this.dataCadastro = usuario.getDataCadastro();
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
}
