package dev.fpsaraiva.microserviceuser.criausuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoUsuarioRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    private String endereco;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 13)
    private String telefone;

    public NovoUsuarioRequest(String nome, String cpf, String endereco, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "NovoUsuarioRequest{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public NovoUsuario paraUsuario() {
        return new NovoUsuario(nome, cpf, endereco, email, telefone);
    }
}
