package Pessoas;

import Pessoas.infos.Telefone;

import java.util.Objects;

public class Pessoa implements PessoaIF{
    private final String nome;
    private Telefone telefone;
    private String email;
    private boolean ativo;

    public Pessoa(String nome, Telefone telefone, String email, boolean ativo) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.ativo = ativo;
    }

    @Override
    public String nome() {
        return "";
    }

    @Override
    public Telefone telefone() {
        return null;
    }

    @Override
    public String email() {
        return "";
    }

    @Override
    public boolean ativo() {
        return false;
    }

    public String getNome() {
        return nome;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
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

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
