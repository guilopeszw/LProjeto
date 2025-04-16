package coleções;

import entidades.Professor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ColecaoDeProfessores implements Serializable {
    Set<Professor> colecaoDeProfessores = new HashSet<>();

    public ColecaoDeProfessores(Set<Professor> colecaoDeProfessores) {
        this.colecaoDeProfessores = colecaoDeProfessores;
    }

    public void addProfessor(Professor professor) {
        colecaoDeProfessores.add(professor);
    }

    public void removeProfessor(Professor professor) {
        colecaoDeProfessores.remove(professor);
    }

    public Set<Professor> listarProfessores() {
        return colecaoDeProfessores;
    }
}
