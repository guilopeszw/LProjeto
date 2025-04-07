public class Disciplina {
    private String nome;
    private int qtdHoras;
    private int codigo;
    private boolean ativo;

    public Disciplina(String nome, int qtdHoras, int codigo, boolean ativo) {
        this.nome = nome;
        this.qtdHoras = qtdHoras;
        this.codigo = codigo;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdHoras() {
        return qtdHoras;
    }

    public int getCodigo() {
        return codigo;
    }
}
