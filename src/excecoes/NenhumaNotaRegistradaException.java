package excecoes;

public class NenhumaNotaRegistradaException extends AlunoException {
    public NenhumaNotaRegistradaException() {
        super("Nenhuma nota registrada para este aluno");
    }
}
