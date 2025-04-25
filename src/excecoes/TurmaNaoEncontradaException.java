package excecoes;

//Exceção para turmas não encontradas
public class TurmaNaoEncontradaException extends TurmaException {
    public TurmaNaoEncontradaException() {
        super("Turma não encontrada");
    }
}