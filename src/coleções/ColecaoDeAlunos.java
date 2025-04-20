package coleções;

import entidades.Aluno;
import entidades.Professor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ColecaoDeAlunos implements Serializable {
    Set<Aluno> colecaoDeAlunos = new HashSet<>();

    public ColecaoDeAlunos(Set<Aluno> colecaoDeAlunos) {
        this.colecaoDeAlunos = colecaoDeAlunos;
    }

    public void addAluno(Aluno aluno) {
        if (colecaoDeAlunos.stream().anyMatch(a -> a.getCodigo() == aluno.getCodigo())) {
            throw new IllegalArgumentException("Código de turma já existe");
        }
        colecaoDeAlunos.add(aluno);
    }

    public void removeAluno(int codigoAluno) {
        Optional<Aluno> alunoOptional = colecaoDeAlunos.stream()
                .filter(a -> a.getCodigo() == codigoAluno)
                .findFirst();

        if (alunoOptional.isPresent()) {
            colecaoDeAlunos.remove(alunoOptional.get());
            Aluno aluno = buscaAlunoPeloCodigo(codigoAluno);
            aluno.desligarAluno();
        } else {
            throw new IllegalArgumentException("Aluno não encontrado");
        }
    }

    public Set<Aluno> listarAlunos() {
        return colecaoDeAlunos;
    }

    public Aluno buscaAlunoPeloCodigo(int codigoAluno) {
        return colecaoDeAlunos.stream()
                .filter(a -> a.getCodigo() == codigoAluno)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));
    }
}
