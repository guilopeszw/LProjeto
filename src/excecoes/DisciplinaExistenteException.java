package excecoes;

public class DisciplinaExistenteException extends RuntimeException {
    public DisciplinaExistenteException() {
        super("Disciplina já cadastrada!");
    }
}