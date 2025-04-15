import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NotaPorUnidade {
    private Map<Integer, Double> notas;

    public NotaPorUnidade() {
        this.notas = new HashMap<>();
    }

    public Map<Integer, Double> getNotas() {
        return new HashMap<>(notas);
    }

    public void addNota(int unidade, double nota){
        if (nota < 0 || nota > 10){
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10");
        }
        notas.put(unidade, nota);
    }

    public void removeNota(int unidade){
        notas.remove(unidade);
    }

    public Double getNota(int unidade){
        return notas.get(unidade);
    }

    public double calculaMedia() {
        if (notas.isEmpty()) {
            throw new IllegalArgumentException("Não há notas registradas");
        }
        double soma = 0;
        for (Double nota : notas.values()) {
            soma += nota;
        }
        return soma / notas.size();
    }

    public double calculaMediaUltimaProva(int quantUnidades) {
        if (notas.isEmpty()) {
            throw new IllegalArgumentException("Não há notas registradas");
        }
        if (!notas.containsKey(quantUnidades)) {
            throw new IllegalArgumentException("Última prova não registrada");
        }

        double ultimaNota = notas.get(quantUnidades);
        double somaRestante = 0;
        int contador = 0;

        for (Map.Entry<Integer, Double> entry : notas.entrySet()) {
            if (entry.getKey() != quantUnidades) {
                somaRestante += entry.getValue();
                contador++;
            }
        }

        double mediaRestante = (contador > 0) ? somaRestante / contador : 0;
        return (0.5 * ultimaNota) + (0.5 * mediaRestante);
    }

    // Nova estratégia 2: Remove a menor nota e calcula a média
    public double calculaMediaRemoveMenor() {
        if (notas.isEmpty()) {
            throw new IllegalArgumentException("Não há notas registradas");
        }
        if (notas.size() == 1) {
            return notas.values().iterator().next(); // Retorna a única nota
        }

        double menorNota = Collections.min(notas.values());
        double soma = 0;
        for (Double nota : notas.values()) {
            soma += nota;
        }

        return (soma - menorNota) / (notas.size() - 1);
    }

}
