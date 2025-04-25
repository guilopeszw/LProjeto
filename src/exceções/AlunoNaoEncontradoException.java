package exceções;

// Exceção para aluno não encontrado
public class AlunoNaoEncontradoException extends AlunoException {
    public AlunoNaoEncontradoException() {
        super("Aluno não encontrado");
    }
}
