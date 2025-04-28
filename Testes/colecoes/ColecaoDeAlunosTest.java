package colecoes;

import entidades.Aluno;
import excecoes.AlunoNaoEncontradoException;
import excecoes.TurmaCodigoExistenteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ColecaoDeAlunosTest {
    private ColecaoDeAlunos colecao;
    private Aluno aluno1;
    private Aluno aluno2;

    @BeforeEach
    void setUp() {
        colecao = new ColecaoDeAlunos();
        aluno1 = new Aluno(
                "Maria Oliveira",
                "1198888-8888",
                "maria@email.com",
                "Direito",
                1001,
                true
        );
        aluno2 = new Aluno(
                "Pedro Souza",
                "1197777-7777",
                "pedro@email.com",
                "Medicina",
                1002,
                true
        );
    }

    @Test
    void addAlunoDeveAdicionarAlunoComSucesso() {
        colecao.addAluno(aluno1);
        assertDoesNotThrow(() -> colecao.buscaAlunoPeloCodigo(1001));
    }

    @Test
    void addAlunoDeveLancarExcecaoParaMatriculaDuplicada() {
        colecao.addAluno(aluno1);
        assertThrows(TurmaCodigoExistenteException.class, () -> colecao.addAluno(aluno1));
    }

    @Test
    void removeAlunoDeveMarcarAlunoComoInativo() {
        colecao.addAluno(aluno1);
        colecao.removeAluno(1001);

        Aluno alunoRemovido = colecao.buscaAlunoPeloCodigo(1001);
        assertFalse(alunoRemovido.getAtivo());
    }

    @Test
    void removeAlunoDeveLancarExcecaoParaMatriculaInexistente() {
        assertThrows(AlunoNaoEncontradoException.class, () -> colecao.removeAluno(9999));
    }

    @Test
    void listarAlunosDeveRetornarApenasAtivos() {
        colecao.addAluno(aluno1);
        colecao.addAluno(aluno2);
        colecao.removeAluno(1001);

        Set<Aluno> alunosAtivos = colecao.listarAlunos();
        assertEquals(1, alunosAtivos.size());
        assertTrue(alunosAtivos.contains(aluno2));
    }

    @Test
    void buscaAlunoPeloCodigo_DeveEncontrarInativos() {
        colecao.addAluno(aluno1);
        colecao.removeAluno(1001);

        assertDoesNotThrow(() -> colecao.buscaAlunoPeloCodigo(1001));
        assertFalse(colecao.buscaAlunoPeloCodigo(1001).getAtivo());
    }
}