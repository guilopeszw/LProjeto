package coleções;

import entidades.Aluno;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ColecaoDeAlunos implements Serializable {
    Set<Aluno> colecaoDeAlunos = new HashSet<>();

    public ColecaoDeAlunos(Set<Aluno> colecaoDeAlunos) {
        this.colecaoDeAlunos = colecaoDeAlunos;
    }

    public void addAluno(Aluno aluno) {
        colecaoDeAlunos.add(aluno);
    }

    public void removeAluno(Aluno aluno) {
        colecaoDeAlunos.remove(aluno);
    }

    public Set<Aluno> listarAlunos() {
        return colecaoDeAlunos;
    }
}
