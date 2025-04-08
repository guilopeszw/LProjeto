package Pessoas;

import Pessoas.infos.Telefone;

public interface PessoaIF {
    String getNome();
    Telefone getTelefone();
    String getEmail();
    boolean isAtivo();
}
