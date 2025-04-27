package visualizacao;

import abstrato.Disciplina;
import abstrato.Turma;
import colecoes.ColecaoDeAlunos;
import colecoes.ColecaoDeDisciplinas;
import colecoes.ColecaoDeProfessores;
import colecoes.ColecaoDeTurmas;
import entidades.Aluno;
import entidades.Professor;
import medias.CalculaMediaIF;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Faculdade implements Serializable {
    ColecaoDeAlunos colecaoDeAlunos = new ColecaoDeAlunos();
    ColecaoDeProfessores colecaoDeProfessores = new ColecaoDeProfessores();
    ColecaoDeTurmas colecaoDeTurmas = new ColecaoDeTurmas();
    ColecaoDeDisciplinas colecaoDeDisciplinas = new ColecaoDeDisciplinas();


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

    public void matricularAlunoEmTurma(int codigoTurma, int matriculaAluno) {
        colecaoDeTurmas.buscarTurmaPorCodigo(codigoTurma).matricularAluno(colecaoDeAlunos.buscaAlunoPeloCodigo(matriculaAluno));
    }

    public void atribuirNotaEmTurma(int codigoTurma, int matricula, int unidade, double nota) {
        colecaoDeTurmas.buscarTurmaPorCodigo(codigoTurma).atribuirNota(matricula, unidade, nota);
    }

    public double calcularMediaAlunoEmTurma(int codigoTurma, int matricula, CalculaMediaIF estrategia) {
        return colecaoDeTurmas.buscarTurmaPorCodigo(codigoTurma).calcularMediaAluno(matricula, estrategia);
    }

    public double calcularMediaGeralDaTurma(int codigoTurma, CalculaMediaIF estrategia) {
        return colecaoDeTurmas.buscarTurmaPorCodigo(codigoTurma).calcularMediaGeral(estrategia);
    }

    // Disciplina:
    public void adicionarDisciplina(Disciplina disciplina) {
        colecaoDeDisciplinas.adicionarDisciplina(disciplina);
    }

    public Set<Disciplina> listarDisciplinas() {
        return colecaoDeDisciplinas.listarDisciplinas();
    }

    public Disciplina buscarDisciplinaPorCodigo(int codigo) {
        return colecaoDeDisciplinas.buscarDisciplinaPorCodigo(codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Faculdade faculdade)) return false;
        return Objects.equals(colecaoDeAlunos, faculdade.colecaoDeAlunos) && Objects.equals(colecaoDeProfessores, faculdade.colecaoDeProfessores) && Objects.equals(colecaoDeTurmas, faculdade.colecaoDeTurmas) && Objects.equals(colecaoDeDisciplinas, faculdade.colecaoDeDisciplinas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colecaoDeAlunos, colecaoDeProfessores, colecaoDeTurmas, colecaoDeDisciplinas);
    }

    @Override
    public String toString() {
        return "Faculdade{" +
                "" + colecaoDeAlunos +
                "" + colecaoDeProfessores +
                "" + colecaoDeTurmas +
                "" + colecaoDeDisciplinas;
    }
}
