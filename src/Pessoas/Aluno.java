package Pessoas;

import Pessoas.infos.Matricula;
import Pessoas.infos.Telefone;

public class Aluno extends Pessoa {
    private final Matricula matricula;

    public Aluno(String nome, Telefone telefone, String email, boolean ativo,
                 Matricula matricula) {
        super(nome, telefone, email, ativo);
        this.matricula = matricula;
    }

    public Matricula getMatricula() {
        return matricula;
    }


}
