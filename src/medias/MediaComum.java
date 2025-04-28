package medias;

import excecoes.SemNotaException;

import java.util.Map;

public class MediaComum implements CalculaMediaIF{

    @Override
    public double calculaMedia(Map<Integer, Double> notas, int quantUnidades) {
        if (notas.isEmpty()) throw new SemNotaException();
        return notas.values().stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }
}
