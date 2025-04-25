package excecoes;

//Exceções do sistema acadêmico
public class SistemaAcademicoException extends RuntimeException {
    public SistemaAcademicoException(String mensagem) {
        super(mensagem);
    }
}