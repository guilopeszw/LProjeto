package excecoes;

// Exceção para código de turma duplicado
public class TurmaCodigoExistenteException extends TurmaException {
    public TurmaCodigoExistenteException() {
        super("Código de turma já existe");
    }
}
