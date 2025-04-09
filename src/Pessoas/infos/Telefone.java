package Pessoas.infos;

import java.util.Objects;

public class Telefone {
    private String numero;

    public Telefone(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String criaTelefone(String numero) {
        return "+55 " + numero;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Telefone telefone)) return false;
        return Objects.equals(numero, telefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "numero='" + numero + '\'' +
                '}';
    }
}