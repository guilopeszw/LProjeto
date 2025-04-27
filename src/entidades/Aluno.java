package entidades;


import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable {
    private String curso;

    public Aluno(String nome, String telefone, String email, String curso, int matricula, boolean ativo) {
        super(nome, telefone, email, matricula, true);
        this.curso = curso;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCurso() {
        return curso;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void desligarAluno() {
        this.ativo = false;
    }
}