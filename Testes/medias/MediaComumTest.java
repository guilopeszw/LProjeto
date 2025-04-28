package medias;

import excecoes.SemNotaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class MediaComumTest {
    private MediaComum mediaComum;

    @BeforeEach
    void setUp() {
        mediaComum = new MediaComum();
    }

    @Test
    void calculaMediaDeveLancarExcecaoQuandoSemNotas() {
        Map<Integer, Double> notas = new HashMap<>();
        assertThrows(SemNotaException.class, () ->
                mediaComum.calculaMedia(notas, 3)
        );
    }

    @Test
    void calculaMediaDeveRetornarMediaCorretaComUmaNota() {
        Map<Integer, Double> notas = new HashMap<>();
        notas.put(1, 8.5);

        double media = mediaComum.calculaMedia(notas, 2);
        assertEquals(8.5, media, 0.001);
    }

    @Test
    void calculaMediaDeveIgnorarQuantUnidades() {
        Map<Integer, Double> notas = new HashMap<>();
        notas.put(1, 7.0);
        notas.put(2, 8.0);


        double media = mediaComum.calculaMedia(notas, 5);
        assertEquals(7.5, media, 0.001);
    }

    @Test
    void calculaMediaDeveCalcularCorretamenteComNotasZeradas() {
        Map<Integer, Double> notas = new HashMap<>();
        notas.put(1, 0.0);
        notas.put(2, 0.0);

        double media = mediaComum.calculaMedia(notas, 2);
        assertEquals(0.0, media, 0.001);
    }

    @Test
    void calculaMediaDeveCalcularMediaComNotasDecimais() {
        Map<Integer, Double> notas = new HashMap<>();
        notas.put(1, 6.5);
        notas.put(2, 7.5);
        notas.put(3, 8.5);

        double media = mediaComum.calculaMedia(notas, 3);
        assertEquals(7.5, media, 0.001);
    }
}