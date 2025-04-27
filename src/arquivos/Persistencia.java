package arquivos;

import visualizacao.Faculdade;

import java.io.*;

public class Persistencia {

    public static void salvarSistema(Faculdade faculdade, String caminho) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(caminho))) {
            output.writeObject(faculdade);
            System.out.println("O sistema foi armazenado. ");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static Faculdade recuperarSistema(String caminho) throws IOException, ClassNotFoundException {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(caminho))) {
            return (Faculdade) input.readObject();
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
