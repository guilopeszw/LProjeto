package entidades;

import java.util.UUID;

public class Professor extends Pessoa {
    public Professor(String nome, String telefone, String email, boolean ativo, UUID codigo) {
        super(nome, telefone, email, ativo, codigo);
    }
}