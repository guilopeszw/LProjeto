package colecoes;

import abstrato.Disciplina;
import excecoes.DisciplinaExistenteException;
import excecoes.DisciplinaNaoEncontradaException;

import java.io.Serializable;
import java.util.HashSet;
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
}