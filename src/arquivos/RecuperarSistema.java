package arquivos;

import visualizacao.Faculdade;

import java.io.*;

public class RecuperarSistema {
    public static Faculdade recuperarSistema(String caminho) throws IOException, ClassNotFoundException {
        try(ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream(caminho))) {
            return (Faculdade) recuperar.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
