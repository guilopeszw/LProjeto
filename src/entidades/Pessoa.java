package entidades;

import java.util.Objects;
import java.util.UUID;

public abstract class Pessoa {
    private final String nome;
    private String telefone;
    private String email;
    private boolean ativo;
    private UUID codigo;

    public Pessoa(String nome, String telefone, String email, boolean ativo, UUID codigo) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.ativo = ativo;
        this.codigo = codigo;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pessoa pessoa)) return false;
        return ativo == pessoa.ativo && Objects.equals(nome, pessoa.nome) && Objects.equals(telefone, pessoa.telefone) && Objects.equals(email, pessoa.email) && Objects.equals(codigo, pessoa.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, email, ativo, codigo);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", ativo=" + ativo +
                ", codigo=" + codigo +
                '}';
    }
}