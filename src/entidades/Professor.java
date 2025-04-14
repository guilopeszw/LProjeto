package entidades;

import java.util.HashSet;
import java.util.Set;

public class Professor extends Pessoa {
    private Set<Disciplina> disciplinasMinistradas;

    public Professor(String nome, String telefone, String email, int codigo) {
        super(nome, telefone, email, true);
    }

    public Professor(String nome, String telefone, String email, int codigo, Set<Disciplina> disciplinasMinistradas) {
        super(nome, telefone, email, true);
        this.disciplinasMinistradas = new HashSet<>();
    }

    public Set<Disciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    public void setDisciplinasMinistradas(Set<Disciplina> disciplinasMinistradas) {
        this.disciplinasMinistradas = disciplinasMinistradas;
    }
}