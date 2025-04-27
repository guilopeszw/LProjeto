package colecoes;

import abstrato.Disciplina;
import excecoes.DisciplinaExistenteException;
import excecoes.DisciplinaNaoEncontradaException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class ColecaoDeDisciplinas implements Serializable {
    private Set<Disciplina> disciplinas = new HashSet<>();

    public void adicionarDisciplina(Disciplina disciplina) {
        if (disciplinas.stream().anyMatch(d -> d.getCodigoDisciplina() == disciplina.getCodigoDisciplina())) {
            throw new DisciplinaExistenteException();
        }
        disciplinas.add(disciplina);
    }

    public Set<Disciplina> listarDisciplinas() {
        return new HashSet<>(disciplinas);
    }

    public Disciplina buscarDisciplinaPorCodigo(int codigo) {
        return disciplinas.stream()
                .filter(d -> d.getCodigoDisciplina() == codigo)
                .findFirst()
                .orElseThrow(DisciplinaNaoEncontradaException::new);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColecaoDeDisciplinas that)) return false;
        return Objects.equals(disciplinas, that.disciplinas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(disciplinas);
    }

    @Override
    public String toString() {
        return "'ColecaoDeDisciplinas{" + disciplinas +
                "'";
    }
}