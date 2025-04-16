package entidades;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Turma implements Serializable {
    private Disciplina disciplina;
    private Professor professor;
    private Map<Integer, Aluno> alunosMatriculados; // Matrícula como Integer
    private Map<Integer, Map<Integer, Double>> notasPorAluno;
    private int quantUnidades;
    private int codigo;
    private Boolean ativo;

    public Turma(Disciplina disciplina, Professor professor, int quantUnidades, int codigo) {
        this.disciplina = disciplina;
        this.professor = professor; // Campo professor corrigido
        this.quantUnidades = quantUnidades;
        this.codigo = codigo;
        this.ativo = true;
        this.alunosMatriculados = new HashMap<>();
        this.notasPorAluno = new HashMap<>();
    }

    public void matricularAluno(Aluno aluno) {
        int matricula = aluno.getCodigo();
        if (alunosMatriculados.containsKey(matricula)) {
            throw new IllegalArgumentException("Matrícula já existe");
        }
        alunosMatriculados.put(matricula, aluno);
        notasPorAluno.put(matricula, new HashMap<>());
    }

    public void atribuirNota(int matricula, int unidade, double nota) {
        validarUnidade(unidade);
        validarNota(nota);
        notasPorAluno.computeIfAbsent(matricula, k -> new HashMap<>()).put(unidade, nota);
    }

    public Map<Integer, Double> getNotasAluno(int matricula) {
        if (!alunosMatriculados.containsKey(matricula)) {
            throw new IllegalArgumentException("Aluno não está matriculado nesta turma");
        }

        Map<Integer, Double> notas = notasPorAluno.get(matricula);
        if (notas == null || notas.isEmpty()) {
            throw new IllegalStateException("Nenhuma nota registrada para este aluno");
        }

        return new HashMap<>(notas);
    }

    public double getNotaPorUnidade(int matricula, int unidade) {
        if (unidade < 1 || unidade > quantUnidades) {
            throw new IllegalArgumentException("Unidade inválida");
        }
        if (!alunosMatriculados.containsKey(matricula)) {
            throw new IllegalArgumentException("Aluno não matriculado");
        }

        Map<Integer, Double> notas = notasPorAluno.get(matricula);
        Double nota = notas.get(unidade);

        return nota != null ? nota : 0.0;
    }

    public double calcularMediaAluno(int matricula, CalculaMediaIF estrategia) {
        Map<Integer, Double> notas = notasPorAluno.getOrDefault(matricula, new HashMap<>());
        return estrategia.calculaMedia(notas, quantUnidades);
    }

    public double calcularMediaGeral(CalculaMediaIF estrategia) {
        return notasPorAluno.values().stream()
                .mapToDouble(notas -> estrategia.calculaMedia(notas, quantUnidades))
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Turma sem alunos"));
    }

    private void validarUnidade(int unidade) {
        if (unidade < 1 || unidade > quantUnidades) throw new IllegalArgumentException("Unidade inválida");
    }

    private void validarNota(double nota) {
        if (nota < 0 || nota > 10) throw new IllegalArgumentException("Nota inválida");
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Map<Integer, Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public int getCodigo() {
        return codigo;
    }

    public void encerrarTurma() {
        this.ativo = false;
    }

}
