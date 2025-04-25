package exceções;

//Exceção para a inserção de dados inválidos
public class DadoInvalidoException extends SistemaAcademicoException {
    public DadoInvalidoException(String campo) {
        super("Campo inválido: " + campo);
    }
}
