package dev.fpsaraiva.microserviceuser.listausuarios;

import dev.fpsaraiva.microserviceuser.entity.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioResponse {

    private	String nome;
    private	String cpf;
    private	String endereco;
    private	String email;
    private	String telefone;

    public UsuarioResponse(String nome, String cpf, String endereco, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
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
    
    public static List<UsuarioResponse> converterEmResposta(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(usuario -> new UsuarioResponse(usuario.getNome(), usuario.getCpf(), usuario.getEndereco(),
                        usuario.getEmail(), usuario.getTelefone())).collect(Collectors.toList());
    }
}
