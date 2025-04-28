package colecoes;

import abstrato.Turma;
import excecoes.TurmaCodigoExistenteException;
import excecoes.TurmaNaoEncontradaException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class ColecaoDeTurmas implements Serializable{
    private Set<Turma> colecaoDeTurmas = new HashSet<>();

    public ColecaoDeTurmas() {}

    public ColecaoDeTurmas(Set<Turma> turmas) {
        this.colecaoDeTurmas.addAll(turmas);
    }

    public void adicionarTurma(Turma turma) {
        if (colecaoDeTurmas.stream().anyMatch(t -> t.getCodigo() == turma.getCodigo())) {
            throw new TurmaCodigoExistenteException();
        }
        colecaoDeTurmas.add(turma);
    }

    public void removerTurma(int codigoTurma) {
        Optional<Turma> turma = colecaoDeTurmas.stream()
                .filter(t -> t.getCodigo() == codigoTurma)
                .findFirst();

        if (turma.isPresent()) {
            Turma turmaPorCodigo = buscarTurmaPorCodigo(codigoTurma);
            turmaPorCodigo.encerrarTurma();
        } else {
            throw new TurmaNaoEncontradaException();
        }
    }

    public Set<Turma> listarTurmas() {
        HashSet<Turma> listaDeTurmas = new HashSet<>();
        for (Turma turma : colecaoDeTurmas) {
            if (turma.isAtivo()) {
                listaDeTurmas.add(turma);
            }
        }
        return listaDeTurmas;
    }

    public Turma buscarTurmaPorCodigo(int codigo) {
        return colecaoDeTurmas.stream()
                .filter(t -> t.getCodigo() == codigo)
                .findFirst()
                .orElseThrow(TurmaNaoEncontradaException::new);
    }

    public Set<Turma> filtrarTurmasPorDisciplina(String nomeDisciplina) {
        Set<Turma> turmasFiltradas = new HashSet<>();
        for (Turma turma : colecaoDeTurmas) {
            if (turma.getDisciplina().getNomeDisciplina().equalsIgnoreCase(nomeDisciplina)) {
                turmasFiltradas.add(turma);
            }
        }
        return turmasFiltradas;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColecaoDeTurmas that)) return false;
        return Objects.equals(colecaoDeTurmas, that.colecaoDeTurmas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(colecaoDeTurmas);
    }

    @Override
    public String toString() {
        return "'ColecaoDeTurmas{" + colecaoDeTurmas +
                "'";
    }
}