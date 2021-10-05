package dev.fpsaraiva.microserviceuser.features.atualizaporcpf;

import dev.fpsaraiva.microserviceuser.entity.Usuario;

public class UsuarioAtualizadoResponse {

    private	String nome;
    private	String cpf;
    private	String endereco;
    private	String email;
    private	String telefone;

    public UsuarioAtualizadoResponse(Usuario usuario) {
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
}
