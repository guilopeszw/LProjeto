package entidades;

public class Disciplina {

    private String nome;
    private Professor professor;
    private int qtdHoras;
    private int codigo;
    private boolean ativo;

    public Disciplina(String nome,Professor professor, int qtdHoras, int codigo) {
        this.nome = nome;
        this.professor = professor;
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

    public Professor getProfessor() {
        return professor;
    }
}
