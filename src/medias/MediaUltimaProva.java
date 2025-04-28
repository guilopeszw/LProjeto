package medias;

import excecoes.SemUltimaNotaException;

import java.io.Serializable;
import java.util.Map;

public class MediaUltimaProva implements CalculaMediaIF, Serializable {

    @Override
    public double calculaMedia(Map<Integer, Double> notas, int quantUnidades) {
        if (notas.size() == 1) {
            return notas.values().iterator().next();
        }
        if (!notas.containsKey(quantUnidades)) throw new SemUltimaNotaException();
        double ultima = notas.get(quantUnidades);
        double mediaRestante = notas.entrySet().stream()
                .filter(e -> e.getKey() != quantUnidades)
                .mapToDouble(Map.Entry::getValue)
                .average().orElse(0);
        return (ultima + mediaRestante) / 2;
    }

}
