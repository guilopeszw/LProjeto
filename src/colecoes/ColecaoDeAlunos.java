package colecoes;

import entidades.Aluno;
import excecoes.AlunoNaoEncontradoException;
import excecoes.TurmaCodigoExistenteException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class ColecaoDeAlunos implements Serializable {
    Set<Aluno> colecaoDeAlunos = new HashSet<>();

    public ColecaoDeAlunos() {}

    public ColecaoDeAlunos(Set<Aluno> colecaoDeAlunos) {
        this.colecaoDeAlunos = colecaoDeAlunos;
    }

    public void addAluno(Aluno aluno) {
        if (colecaoDeAlunos.stream().anyMatch(a -> a.getCodigo() == aluno.getCodigo())) {
            throw new TurmaCodigoExistenteException();
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
            throw new AlunoNaoEncontradoException();
        }
    }

    public Set<Aluno> listarAlunos() {
        return colecaoDeAlunos;
    }

    public Aluno buscaAlunoPeloCodigo(int codigoAluno) {
        return colecaoDeAlunos.stream()
                .filter(a -> a.getCodigo() == codigoAluno)
                .findFirst()
                .orElseThrow(AlunoNaoEncontradoException::new);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColecaoDeAlunos that)) return false;
        return Objects.equals(colecaoDeAlunos, that.colecaoDeAlunos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(colecaoDeAlunos);
    }

    @Override
    public String toString() {
        return "'ColecaoDeAlunos{" + colecaoDeAlunos +
                "'";
    }
}
