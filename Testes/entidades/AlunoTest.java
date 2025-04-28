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
        assertFalse(aluno.getAtivo());

        aluno.setAtivo(true);
        assertTrue(aluno.getAtivo());
    }

    @Test
    void getCursoDeveRetornarCursoCorreto() {
        assertEquals("Ciência da Computação", aluno.getCurso());
    }

    @Test
    void getAtivoDeveRetornarStatusInicial() {
        assertTrue(aluno.getAtivo());
    }

    @Test
    void desligarAlunoDeveMarcarComoInativo() {
        aluno.desligarAluno();
        assertFalse(aluno.getAtivo());
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