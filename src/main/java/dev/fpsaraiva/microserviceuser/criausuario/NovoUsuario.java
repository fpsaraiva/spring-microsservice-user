package dev.fpsaraiva.microserviceuser.criausuario;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class NovoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private	String	nome;
    private	String	cpf;
    private	String	endereco;
    private	String	email;
    private	String	telefone;
    private LocalDateTime dataCadastro;

    public NovoUsuario(String nome, String cpf, String endereco, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = LocalDateTime.now();
    }

}
