package visualizacao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Faculdade faculdade = new Faculdade();

        System.out.println("Sistema Acadêmico \n");

        int primeiraEscolha = getPrimeiraEscolha(sc);

        while (primeiraEscolha < 4) {
            switch(primeiraEscolha) {
                case 1:
                    System.out.println("ALUNO \n");
                    int segundaEscolha = getSegundaEscolha(sc);

                    while (segundaEscolha < 5) {
                        switch(segundaEscolha) {
                            case 1:

                        }
                    }
            }
            primeiraEscolha = getPrimeiraEscolha(sc);
        }
    }

    private static int getPrimeiraEscolha(Scanner sc) throws Exception {
        String prompt = "1. Aluno; \n2. Professor; \n3. Turma; \n4. Sair \nInsira o que deseja acessar: \n";
        int primeiraEscolha = sc.nextInt();

        if (primeiraEscolha < 0 || primeiraEscolha > 4) {
            throw new Exception("Escolha inválida");
        }
        return primeiraEscolha;
    }

    private static int getSegundaEscolha(Scanner sc) throws Exception {
        String promptDois = """
                1. Adicionar;\s
                2. Remover;\s
                3. Listar;\s
                4. Buscar pelo código;\s
                5. Sair\s
                Insira o que deseja:\s
                """;
        int segundaEscolha = sc.nextInt();

        if (segundaEscolha < 0 || segundaEscolha > 5) {
            throw new Exception("Escolha inválida");
        }
        return segundaEscolha;
    }
}
