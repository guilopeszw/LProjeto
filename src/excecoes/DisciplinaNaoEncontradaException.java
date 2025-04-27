package excecoes;

public class DisciplinaNaoEncontradaException extends RuntimeException {
    public DisciplinaNaoEncontradaException() {
        super("Disciplina não encontrada!");
    }
}
