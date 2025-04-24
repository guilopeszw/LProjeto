package abstrato;

import java.io.Serializable;

public class Disciplina implements Serializable {

    private String nome;
    private int qtdHoras;
    private int codigo;
    private boolean ativo;

    public Disciplina(String nome, int qtdHoras, int codigo) {
        this.nome = nome;
        this.qtdHoras = qtdHoras;
        this.codigo = codigo;
        this.ativo = true;
    }

    public String getNomeDisciplina() {
        return nome;
    }

    public int getHorasDisciplina() {
        return qtdHoras;
    }

    public int getCodigoDisciplina() {
        return codigo;
    }

}
