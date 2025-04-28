package colecoes;

import entidades.Professor;
import excecoes.ProfessorExistenteException;
import excecoes.ProfessorNaoEncontradoException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class ColecaoDeProfessores implements Serializable {
    Set<Professor> colecaoDeProfessores = new HashSet<>();

    public ColecaoDeProfessores() {}

    public ColecaoDeProfessores(Set<Professor> colecaoDeProfessores) {
        this.colecaoDeProfessores = colecaoDeProfessores;
    }

    public void addProfessor(Professor professor) {
        if (colecaoDeProfessores.stream().anyMatch(p -> p.getCodigo() == professor.getCodigo())) {
            throw new ProfessorExistenteException();
        }
        colecaoDeProfessores.add(professor);
    }

    public void removeProfessor(int codigoProfessor) {
        Optional<Professor> professorOptional = colecaoDeProfessores.stream()
                .filter(p -> p.getCodigo() == codigoProfessor)
                .findFirst();

        if (professorOptional.isPresent()) {
            Professor professor = buscarProfessorPeloCodigo(codigoProfessor);
            professor.desligarProfessor();
        } else {
            throw new ProfessorNaoEncontradoException();
        }
    }

    public Set<Professor> listarProfessores() {
        Set<Professor> listarProfessores = new HashSet<>();
        for (Professor professor : colecaoDeProfessores) {
            if (professor.isAtivo()) {
                listarProfessores.add(professor);
            }
        }
        return colecaoDeProfessores;
    }

    public Professor buscarProfessorPeloCodigo(int codigoProfessor) {
        return colecaoDeProfessores.stream()
                .filter(p -> p.getCodigo() == codigoProfessor)
                .findFirst()
                .orElseThrow(ProfessorNaoEncontradoException::new);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColecaoDeProfessores that)) return false;
        return Objects.equals(colecaoDeProfessores, that.colecaoDeProfessores);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(colecaoDeProfessores);
    }

    @Override
    public String toString() {
        return "'ColecaoDeProfessores{" + colecaoDeProfessores +
                "'";
    }
}
