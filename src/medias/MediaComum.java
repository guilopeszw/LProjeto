package medias;

import java.util.Map;

public class MediaComum implements CalculaMediaIF{

    @Override
    public double calculaMedia(Map<Integer, Double> notas, int quantUnidades) {
        if (notas.isEmpty()) throw new IllegalArgumentException("Sem notas");
        return notas.values().stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }
}
