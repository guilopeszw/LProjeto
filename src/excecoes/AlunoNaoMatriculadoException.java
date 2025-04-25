package excecoes;

//Exceção para aluno não matriculado
public class AlunoNaoMatriculadoException extends AlunoException {
    public AlunoNaoMatriculadoException() {
        super("Aluno não está matriculado nesta turma");
    }
}