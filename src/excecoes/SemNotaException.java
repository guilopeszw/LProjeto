package excecoes;

public class SemNotaException extends IllegalArgumentException {
    public SemNotaException() {
        super("Sem nota. ");
    }
}
