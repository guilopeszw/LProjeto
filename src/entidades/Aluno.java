package entidades;


public class Aluno extends Pessoa {


    public Aluno(String nome, String telefone, String email, int matricula, boolean ativo) {
        super(nome,telefone,email,matricula,true);
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean getAtivo() {
        return ativo;
    }