package Pessoas;

import Pessoas.infos.Telefone;

public interface PessoaIF {
    String nome();
    Telefone telefone();
    String email();
    boolean ativo();
}
