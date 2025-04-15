import entidades.Disciplina;
import entidades.Professor;
import entidades.Aluno;
import java.util.HashMap;
import java.util.Map;

public class Turma {
    private Disciplina disciplina;
    private Professor professor;
    private Map<Integer, Aluno> alunosMatriculados; // Matrícula como Integer
    private Map<Integer, NotaPorUnidade> notasPorAluno;
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

    //Método para matricular aluno usando matrícula (int), Aluno ainda não esta pronto, lembrar de checar a´pos a criação de Aluno
    public void matricularAluno(Aluno aluno) {
        int matricula = aluno.getCodigo();
        if (alunosMatriculados.containsKey(matricula)) {
            throw new IllegalArgumentException("Matrícula já existe");
        }
        alunosMatriculados.put(matricula, aluno);
        notasPorAluno.put(matricula, new NotaPorUnidade());
    }

    // Método para atribuir nota a um aluno, Aluno ainda não esta pronto, lembrar de checar a´pos a criação de Aluno
    public void atribuirNota(int matricula, int unidade, double nota) {
        if (!alunosMatriculados.containsKey(matricula)) {
            throw new IllegalArgumentException("Aluno não matriculado");
        }
        if (unidade < 1 || unidade > quantUnidades) {
            throw new IllegalArgumentException("Unidade inválida");
        }
        notasPorAluno.get(matricula).addNota(unidade, nota);
    }

    // Método para obter todas as notas do aluno (por unidade) Aluno ainda não esta pronto, lembrar de checar a´pos a criação de Aluno
    public Map<Integer, Double> getNotasAluno(int matricula) {
        if (!alunosMatriculados.containsKey(matricula)) {
            throw new IllegalArgumentException("Aluno não está matriculado nesta turma");
        }

        NotaPorUnidade notas = notasPorAluno.get(matricula);
        if (notas == null || notas.getNotas().isEmpty()) {
            throw new IllegalStateException("Nenhuma nota registrada para este aluno");
        }

        return notas.getNotas(); // Retorna um Map<Integer, Double> (unidade → nota)
    }

    // Método para obter a nota de uma unidade específica Aluno ainda não esta pronto, lembrar de checar a´pos a criação de Aluno
    public double getNotaPorUnidade(int matricula, int unidade) {
        if (unidade < 1 || unidade > quantUnidades) {
            throw new IllegalArgumentException("Unidade inválida");
        }
        if (!alunosMatriculados.containsKey(matricula)) {
            throw new IllegalArgumentException("Aluno não matriculado");
        }

        NotaPorUnidade notas = notasPorAluno.get(matricula);
        Double nota = notas.getNota(unidade);

        return nota != null ? nota : 0.0;
    }

    public double calcularMediaAluno(int matricula, String tipoMedia) {
        if (!alunosMatriculados.containsKey(matricula)) {
            throw new IllegalArgumentException("Aluno não matriculado");
        }
        NotaPorUnidade notas = notasPorAluno.get(matricula);

        return switch (tipoMedia.toLowerCase()) {
            case "comum" -> notas.calculaMedia();
            case "ultimaprova" -> notas.calculaMediaUltimaProva(this.quantUnidades);
            case "removemenor" -> notas.calculaMediaRemoveMenor();
            default -> throw new IllegalArgumentException("Tipo de média inválido");
        };
    }

    public double calcularMediaGeral(String tipoMedia) {
        if (notasPorAluno.isEmpty()) {
            throw new IllegalArgumentException("Turma sem alunos");
        }

        double soma = 0;
        for (NotaPorUnidade notas : notasPorAluno.values()) {
            soma += switch (tipoMedia.toLowerCase()) {
                case "comum" -> notas.calculaMedia();
                case "ultimaprova" -> notas.calculaMediaUltimaProva(this.quantUnidades);
                case "removemenor" -> notas.calculaMediaRemoveMenor();
                default -> throw new IllegalArgumentException("Tipo de média inválido");
            };
        }

        return soma / notasPorAluno.size();
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
