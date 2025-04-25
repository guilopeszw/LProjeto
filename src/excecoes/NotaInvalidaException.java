package excecoes;

// Exceção para notas inválidas
public class NotaInvalidaException extends SistemaAcademicoException {
    public NotaInvalidaException() {
        super("Nota inválida");
    }
}
