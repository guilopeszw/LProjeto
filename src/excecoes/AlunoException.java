package excecoes;

// Exceção para operações inválidas com alunos
public class AlunoException extends SistemaAcademicoException {
    public AlunoException(String mensagem) {
        super(mensagem);
    }
}

