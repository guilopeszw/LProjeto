package visualização;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seja bem-vindo(a) \n" +
                "Sistema Acadêmico 2024.2 - UFPB");
        int primeiraEscolha = getPrimeiraEscolha(sc);

        while (primeiraEscolha < 4) {
            switch(primeiraEscolha) {
                case 1:
                    System.out.println("ALUNO\n");
                    int segundaEscolha = getSegundaEscolha(sc);
                    while (segundaEscolha < 5) {
                        switch(segundaEscolha) {
                            case 1:

                        }
                    }
            }
            getPrimeiraEscolha(sc);
        }


    }

    private static int getSegundaEscolha(Scanner sc) throws Exception {
        String promptDois = """
                1. Adicionar;\s
                2. Remover;\s
                3. Listar; \
                4. Buscar pelo código\s
                5. Sair\s
                Insira o que deseja:\s""";
        System.out.println(promptDois);
        int segundaEscolha = sc.nextInt();

        if (segundaEscolha < 0 || segundaEscolha > 5) {
            throw new Exception("Escolha inválida");
        }
        return segundaEscolha;
    }

    private static int getPrimeiraEscolha(Scanner sc) throws Exception {
        String prompt = "1. Alunos; \n2. Professores; \n3. Turmas; \n4. Sair \nInsira o que deseja acessar: \n";
        System.out.println(prompt);
        int primeiraEscolha = sc.nextInt();

        if (primeiraEscolha < 0 || primeiraEscolha > 4) {
            throw new Exception("Escolha inválida.");
        }
        return primeiraEscolha;
    }
}
