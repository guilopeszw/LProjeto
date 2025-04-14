public class Disciplina {

    private String nome;
    private int qtdHoras;
    private final int codigo;
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

    public void setNomeDisciplina(String novoNome) {
        this.nome = novoNome;
    }

    public int getHorasDisciplina() {
        return qtdHoras;
    }

    public void setHorasDisciplina(int novaQuantHoras) {
        this.qtdHoras = novaQuantHoras;
    }

    public int getCodigoDisciplina() {
        return codigo;
    }

    public Boolean getAtivoDisciplina() {
        return ativo;
    }

    public void excluirDisciplina() {
        this.ativo = false;
    }

}
