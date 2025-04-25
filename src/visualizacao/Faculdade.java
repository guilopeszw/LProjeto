package visualizacao;

import abstrato.Turma;
import colecoes.ColecaoDeAlunos;
import colecoes.ColecaoDeProfessores;
import colecoes.ColecaoDeTurmas;
import entidades.Aluno;
import entidades.Professor;

import java.util.Set;

public class Faculdade {
    ColecaoDeAlunos colecaoDeAlunos = new ColecaoDeAlunos();
    ColecaoDeProfessores colecaoDeProfessores = new ColecaoDeProfessores();
    ColecaoDeTurmas colecaoDeTurmas = new ColecaoDeTurmas();

    // aluno
    public void addAluno(Aluno aluno) {
        colecaoDeAlunos.addAluno(aluno);
    }

    public void removeAluno(int codigoAluno) {
        colecaoDeAlunos.removeAluno(codigoAluno);
    }

    public Set<Aluno> listarAlunos() {
        return colecaoDeAlunos.listarAlunos();
    }

    public Aluno buscaAlunoPeloCodigo(int codigoAluno) {
        return colecaoDeAlunos.buscaAlunoPeloCodigo(codigoAluno);
    }

    // professor

    public void addProfessor(Professor professor) {
        colecaoDeProfessores.addProfessor(professor);
    }

    public void removeProfessor(int codigoProfessor) {
        colecaoDeProfessores.removeProfessor(codigoProfessor);
    }

    public Set<Professor> listarProfessores() {
        return colecaoDeProfessores.listarProfessores();
    }

    public Professor buscarProfessorPeloCodigo(int codigoProfessor) {
        return colecaoDeProfessores.buscarProfessorPeloCodigo(codigoProfessor);
    }

    // turma

    public void adicionarTurma(Turma turma) {
        colecaoDeTurmas.adicionarTurma(turma);
    }

    public void removerTurma(int codigoTurma) {
        colecaoDeTurmas.removerTurma(codigoTurma);
    }

    public Set<Turma> listarTurmas() {
        return colecaoDeTurmas.listarTurmas();
    }

    public Turma buscarTurmaPorCodigo(int codigo) {
        return colecaoDeTurmas.buscarTurmaPorCodigo(codigo);
    }

    public Set<Turma> filtrarTurmasPorDisciplina(String nomeDisciplina) {
        return colecaoDeTurmas.filtrarTurmasPorDisciplina(nomeDisciplina);
    }
}
