package coleções;

import entidades.Turma;

import java.io.Serializable;
import java.util.HashSet;
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
            throw new IllegalArgumentException("Código de turma já existe");
        }
        colecaoDeTurmas.add(turma);
    }

    public void removerTurma(int codigoTurma) {
        Optional<Turma> turma = colecaoDeTurmas.stream()
                .filter(t -> t.getCodigo() == codigoTurma)
                .findFirst();

        if (turma.isPresent()) {
            colecaoDeTurmas.remove(turma.get());
            Turma turmaPorCodigo = buscarTurmaPorCodigo(codigoTurma);
            turmaPorCodigo.encerrarTurma();
        } else {
            throw new IllegalArgumentException("Turma não encontrada");
        }
    }

    public Set<Turma> listarTurmas() {
        return new HashSet<>(colecaoDeTurmas);
    }

    public Turma buscarTurmaPorCodigo(int codigo) {
        return colecaoDeTurmas.stream()
                .filter(t -> t.getCodigo() == codigo)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));
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

    public void encerrarTurma(int codigoTurma) {
        Turma turma = buscarTurmaPorCodigo(codigoTurma);
        turma.encerrarTurma();
    }
}