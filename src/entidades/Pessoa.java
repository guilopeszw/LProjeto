package entidades;

import java.util.Objects;

public abstract class Pessoa {
    private final String nome;
    private String telefone;
    private String email;
    private int codigo;
    public boolean ativo;

    public Pessoa(String nome, String telefone, String email,int codigo, boolean ativo) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.codigo = codigo;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pessoa pessoa)) return false;
        return ativo == pessoa.ativo && Objects.equals(nome, pessoa.nome) && Objects.equals(telefone, pessoa.telefone) && Objects.equals(email, pessoa.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, email, ativo);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", email='" + email + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}