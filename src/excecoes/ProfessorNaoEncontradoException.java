package excecoes;

//Para professores não encontrados
public class ProfessorNaoEncontradoException extends ProfessorException {
    public ProfessorNaoEncontradoException() {
        super("Professor não encontrado");
    }
}
