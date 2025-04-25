package exceções;

//Para professores que já existem
public class ProfessorExistenteException extends ProfessorException {
    public ProfessorExistenteException() {
        super("Código de professor já existe");
    }
}
