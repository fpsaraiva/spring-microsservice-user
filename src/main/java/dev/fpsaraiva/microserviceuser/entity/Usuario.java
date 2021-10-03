package dev.fpsaraiva.microserviceuser.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private	String nome;
    private	String cpf;
    private	String endereco;
    private	String email;
    private	String telefone;
    private LocalDateTime dataCadastro;

    @Deprecated
    public Usuario() {
    }

    public Usuario(String nome, String cpf, String endereco, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = LocalDateTime.now();
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
