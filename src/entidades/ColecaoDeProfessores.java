package entidades;

import java.util.HashMap;
import java.util.UUID;

public class ColecaoDeProfessores {
    HashMap<UUID, Professor> colecaoDeProfessores;

    public ColecaoDeProfessores(HashMap<UUID, Professor> colecaoDeProfessores) {
        this.colecaoDeProfessores = colecaoDeProfessores;
    }

    public HashMap<UUID, Professor> addProfessor(Professor professor) {
        colecaoDeProfessores.put(UUID.randomUUID(), professor);
        return colecaoDeProfessores;
    }

    public HashMap<UUID, Professor> removeProfessor(String codigo) {
        colecaoDeProfessores.remove(UUID.fromString(codigo));
        return colecaoDeProfessores;
    }

    public HashMap<UUID, Professor> listarProfessores() {
        return colecaoDeProfessores;
    }

    // Usando hashmap, podemos atribuir um código a um professor, facilitando a identificação
    // Usando a classe UUID, podemos criar ID's inviduais para cada professor, que por sua vez,
    // podem ser utilizadas para removê-los


}
