package medias;

import excecoes.SemNotaException;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

public class RemoveMenorMedia implements CalculaMediaIF, Serializable {

    @Override
    public double calculaMedia(Map<Integer, Double> notas, int quantUnidades) {
        if (notas.isEmpty()) throw new SemNotaException();
        if (notas.size() == 1) return notas.values().iterator().next();
        double menor = Collections.min(notas.values());
        return (notas.values().stream().mapToDouble(Double::doubleValue).sum() - menor) / (notas.size() - 1);
    }

}
