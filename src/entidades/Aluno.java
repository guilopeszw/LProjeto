package entidades;

import entidades.infos.Matricula;

public class Aluno extends Pessoa {
    private final Matricula matricula;

    public Aluno(String nome, String telefone, String email, boolean ativo,
                 Matricula matricula) {
        super(nome, telefone, email, ativo);
        this.matricula = matricula;
    }

    public Matricula getMatricula() {
        return matricula;
    }
}
