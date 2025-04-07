package Pessoas;

import Pessoas.infos.Telefone;

public class Aluno implements PessoaIF{
    @Override
    public String nome() {
        return "";
    }

    @Override
    public Telefone telefone() {
        return null;
    }

    @Override
    public String email() {
        return "";
    }

    @Override
    public boolean ativo() {
        return false;
    }
}
