package excecoes;

public class NotasIncompletasException extends IllegalStateException {
  public NotasIncompletasException() {
    super("Notas incompletas. ");
  }
}
