package dev.fpsaraiva.microserviceuser.criausuario;

public class NovoUsuarioRequest {

    private String nome;
    private String cpf;
    private String endereco;
    private String email;
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
