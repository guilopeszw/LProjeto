package exceções;

// Exceção para matrícula duplicada
public class MatriculaExistenteException extends AlunoException {
    public MatriculaExistenteException() {
        super("Matrícula já existe");
    }
}
