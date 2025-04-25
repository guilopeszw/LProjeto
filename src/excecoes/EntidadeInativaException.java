package excecoes;

//Exceção para tentativa de utilizar entidades inativas
public class EntidadeInativaException extends SistemaAcademicoException {
    public EntidadeInativaException(String entidade) {
        super(entidade + " está inativa e não pode ser modificada");
    }
}
