package dev.fpsaraiva.microserviceuser.criausuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoUsuarioRequest {

    @NotBlank(message = "{name.not.blank}")
    private String nome;

    @NotBlank(message = "{cpf.not.blank}")
    @Size(max = 11, message = "{cpf.max.size}")
    private String cpf;

    @NotBlank(message = "{address.not.blank}")
    private String endereco;

    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;

    @NotBlank(message = "{phone.not.blank}")
    @Size(min = 8, max = 13, message = "{phone.max.size}")
    private String telefone;

    public NovoUsuarioRequest(String nome, String cpf, String endereco, String email, String telefone) {
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

    public NovoUsuario paraUsuario() {
        return new NovoUsuario(nome, cpf, endereco, email, telefone);
    }
}
