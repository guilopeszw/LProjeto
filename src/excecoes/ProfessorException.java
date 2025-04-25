package excecoes;

// Exceção para operações inválidas com professores
public class ProfessorException extends SistemaAcademicoException {
    public ProfessorException(String mensagem) {
        super(mensagem);
    }
}
