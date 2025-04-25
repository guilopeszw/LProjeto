package coleções;

import entidades.Professor;
import exceções.ProfessorExistenteException;
import exceções.ProfessorNaoEncontradoException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ColecaoDeProfessores implements Serializable {
    Set<Professor> colecaoDeProfessores = new HashSet<>();

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
            colecaoDeProfessores.remove(professorOptional.get());
            Professor professor = buscarProfessorPeloCodigo(codigoProfessor);
            professor.desligarProfessor();
        } else {
            throw new ProfessorNaoEncontradoException();
        }
    }

    public Set<Professor> listarProfessores() {
        return colecaoDeProfessores;
    }

    public Professor buscarProfessorPeloCodigo(int codigoProfessor) {
        return colecaoDeProfessores.stream()
                .filter(p -> p.getCodigo() == codigoProfessor)
                .findFirst()
                .orElseThrow(ProfessorNaoEncontradoException::new);
    }
}
