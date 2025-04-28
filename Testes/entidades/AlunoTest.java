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
    void setAtivo_DeveAlterarStatusCorretamente() {
        aluno.setAtivo(false);
        assertFalse(aluno.getAtivo());

        aluno.setAtivo(true);
        assertTrue(aluno.getAtivo());
    }

    @Test
    void getCurso_DeveRetornarCursoCorreto() {
        assertEquals("Ciência da Computação", aluno.getCurso());
    }

    @Test
    void getAtivo_DeveRetornarStatusInicial() {
        assertTrue(aluno.getAtivo());
    }

    @Test
    void desligarAluno_DeveMarcarComoInativo() {
        aluno.desligarAluno();
        assertFalse(aluno.getAtivo());
    }

    @Test
    void equals_DeveConsiderarCurso() {
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