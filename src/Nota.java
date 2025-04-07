import java.util.Objects;

public class Nota {
    private int nota;

    public Nota(int nota) {
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Nota nota1)) return false;
        return nota == nota1.nota;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nota);
    }

    @Override
    public String toString() {
        return "nota = " + nota;
    }
}
