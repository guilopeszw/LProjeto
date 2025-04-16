package entidades;

import java.util.Collections;
import java.util.Map;

public class RemoveMenorMedia implements CalculaMediaIF {

    @Override
    public double calculaMedia(Map<Integer, Double> notas, int quantUnidades) {
        if (notas.isEmpty()) throw new IllegalArgumentException("Sem notas");
        if (notas.size() == 1) return notas.values().iterator().next();
        double menor = Collections.min(notas.values());
        return (notas.values().stream().mapToDouble(Double::doubleValue).sum() - menor) / (notas.size() - 1);
    }

}
