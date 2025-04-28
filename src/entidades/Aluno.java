package entidades;


import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Aluno aluno)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(curso, aluno.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), curso);
    }

    @Override
    public String toString() {
        return "'Aluno | " + "nome: " + getNome()+
                ", curso: '" + curso + '\'' +
                ", ativo: " + ativo +
                "'";
    }
}