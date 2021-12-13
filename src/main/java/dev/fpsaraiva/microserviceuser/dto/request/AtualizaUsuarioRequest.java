package dev.fpsaraiva.microserviceuser.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AtualizaUsuarioRequest {

    @NotBlank(message = "{name.not.blank}")
    private String nome;

    @NotBlank(message = "{address.not.blank}")
    private String endereco;

    @NotBlank(message = "{phone.not.blank}")
    @Size(min = 8, max = 13, message = "{phone.max.size}")
    private String telefone;

    public AtualizaUsuarioRequest(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
}
