package entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {
    private Aluno aluno;

    @BeforeEach
    void setUp() {

        aluno = new Aluno(
                "João Silva",
                "1199999-9999",
                "joao@email.com",
                "Ciência da Computação",
                12345,
                true
        );
    }

    @Test
    void setAtivoDeveAlterarStatusCorretamente() {
        aluno.setAtivo(false);
        assertFalse(aluno.isAtivo());

        aluno.setAtivo(true);
        assertTrue(aluno.isAtivo());
    }

    @Test
    void getCursoDeveRetornarCursoCorreto() {
        assertEquals("Ciência da Computação", aluno.getCurso());
    }

    @Test
    void getAtivoDeveRetornarStatusInicial() {
        assertTrue(aluno.isAtivo());
    }

    @Test
    void desligarAlunoDeveMarcarComoInativo() {
        aluno.desligarAluno();
        assertFalse(aluno.isAtivo());
    }

    @Test
    void equalsDeveConsiderarCurso() {
        Aluno outroAluno = new Aluno(
                "João Silva",
                "1199999-9999",
                "joao@email.com",
                "Engenharia", // Curso diferente
                12345,
                true
        );
        assertNotEquals(aluno, outroAluno);
    }
}