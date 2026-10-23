package model;
public class Pessoa {
    private String nome;
    private final String cpf;
    private String email;
    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
    public String getNome() {
        return this.nome;
    }
    public String getCpf() {
        return this.cpf;
    }
    public String getEmail() {
        return this.email;
    }
    public String toString() {
        return "Nome: " + getNome() + "| CPF: " + getCpf();
    }
}
    