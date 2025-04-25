package excecoes;

//Exceção para unidades inválidas
public class UnidadeInvalidaException extends SistemaAcademicoException {
    public UnidadeInvalidaException(int unidade) {
        super("Unidade " + unidade + " é inválida");
    }
}
