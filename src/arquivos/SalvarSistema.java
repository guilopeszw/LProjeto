package arquivos;

import visualizacao.Faculdade;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SalvarSistema {
    public static void salvarSistema(Faculdade faculdade, String caminho) throws IOException {
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(caminho))) {
            output.writeObject(faculdade);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
