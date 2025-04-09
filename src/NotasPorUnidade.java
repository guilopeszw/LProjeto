import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class NotasPorUnidade {
    private Map<Integer, Double> notas;

    public NotasPorUnidade() {

        this.notas = new HashMap<>();

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

    public Double calculaMedia(){
        if (notas.isEmpty() ){
            throw new IllegalArgumentException("É preciso uma unidade para ser atribuida uma nota");
        }

        double media = 0;
        int contador = 0;
        for (Double nota : notas.values()) {
            media += nota;
            contador++;
        }

        return media / contador;
    }



}
