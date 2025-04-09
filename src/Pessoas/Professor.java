package Pessoas;

import Pessoas.infos.Telefone;

import java.util.Set;


public class Professor extends Pessoa {
    Set<Disciplina> disciplinasMinistradas;

    public Professor(String nome, Telefone telefone, String email,
                     boolean ativo, Set<Disciplina> disciplinasMinistradas) {
        super(nome, telefone, email, ativo);
        this.disciplinasMinistradas = disciplinasMinistradas;
    }

    public Set<Disciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    Professor professor = new Professor("a", "83981930005", "a@gmail.com", true, )
}