package excecoes;

public class SemUltimaNotaException extends IllegalArgumentException {
    public SemUltimaNotaException() {
        super("Última prova não registrada. ");
    }
}
