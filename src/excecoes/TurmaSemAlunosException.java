package excecoes;

//Eceção para turmas sem alunos
public class TurmaSemAlunosException extends TurmaException{
    public TurmaSemAlunosException() {
        super("Turma sem alunos");
    }
}
