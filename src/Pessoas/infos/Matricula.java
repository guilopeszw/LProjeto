package Pessoas.infos;

import java.time.LocalDate;
import java.util.Objects;

public class Matricula {
    private int qtdVagas;
    private int posicao;
    private LocalDate anoDeEntrada = LocalDate.now();

    public Matricula(int qtdVagas, int posicao, LocalDate anoDeEntrada) {
        this.qtdVagas = qtdVagas;
        this.posicao = posicao;
        this.anoDeEntrada = anoDeEntrada;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    public int getPosicao() {
        return posicao;
    }

    public LocalDate getAnoDeEntrada() {
        return anoDeEntrada;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Matricula matricula)) return false;
        return qtdVagas == matricula.qtdVagas && posicao == matricula.posicao && Objects.equals(anoDeEntrada, matricula.anoDeEntrada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qtdVagas, posicao, anoDeEntrada);
    }

    public String criaMatricula(LocalDate anoDeEntrada, int qtdVagas, int posicao) {
        int ano = anoDeEntrada.getYear();
        int vagaPreenchida = qtdVagas + posicao;
        return String.valueOf(ano) + String.valueOf(vagaPreenchida);
    }

    @Override
    public String toString() {
        return "Pessoas.informações.Matricula: " + criaMatricula(anoDeEntrada, qtdVagas, posicao);
    }
}
