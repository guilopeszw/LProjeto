import java.util.Objects;

public class Nota {
    private double nota;

    public Nota(double nota) {
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Nota nota1)) return false;
        return Double.compare(nota, nota1.nota) == 0;
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
