package visualizacao;

import entidades.Aluno;
import entidades.Professor;

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
                            case 1: // Adicionar Aluno
                                try {
                                    sc.nextLine();
                                    System.out.println("Nome do aluno:");
                                    String nome = sc.nextLine();

                                    System.out.println("Telefone:");
                                    String telefone = sc.nextLine();

                                    System.out.println("Email:");
                                    String email = sc.nextLine();

                                    System.out.println("Código de matrícula:");
                                    int matricula = sc.nextInt();

                                    Aluno novoAluno = new Aluno(nome, telefone, email, matricula, true);
                                    faculdade.addAluno(novoAluno);
                                    System.out.println("Aluno adicionado com sucesso!\n");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;

                            case 2: // Remover Aluno
                                try {
                                    System.out.println("Código de matrícula para remover:");
                                    int codigoRemover = sc.nextInt();
                                    faculdade.removeAluno(codigoRemover);
                                    System.out.println("Aluno removido com sucesso!\n");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;

                            case 3: // Listar Alunos
                                System.out.println("\n--- LISTA DE ALUNOS ---");
                                faculdade.listarAlunos().forEach(aluno ->
                                        System.out.printf(
                                                "Matrícula: %d | Nome: %-20s | Status: %s%n",
                                                aluno.getCodigo(),
                                                aluno.getNome(),
                                                aluno.getAtivo() ? "Ativo" : "Inativo"
                                        )
                                );
                                System.out.println("-----------------------\n");
                                break;

                            case 4: // Buscar Aluno
                                try {
                                    System.out.println("Código de matrícula para buscar:");
                                    int codigoBusca = sc.nextInt();
                                    Aluno alunoEncontrado = faculdade.buscaAlunoPeloCodigo(codigoBusca);
                                    System.out.printf(
                                            "\n--- ALUNO ENCONTRADO ---\nMatrícula: %d\nNome: %s\nEmail: %s\nStatus: %s%n%n",
                                            alunoEncontrado.getCodigo(),
                                            alunoEncontrado.getNome(),
                                            alunoEncontrado.getEmail(),
                                            alunoEncontrado.getAtivo() ? "Ativo" : "Inativo"
                                    );
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine(); // Limpar entrada inválida
                                }
                                break;

                            default:
                                System.out.println("Opção inválida!\n");
                        }
                        segundaEscolha = getSegundaEscolha(sc);
                    }
                    break;
                case 2:
                    System.out.println("PROFESSOR \n");
                    segundaEscolha = getSegundaEscolha(sc);

                    while (segundaEscolha < 5) {
                        switch(segundaEscolha) {
                            case 1: // Adicionar Professor
                                try {
                                    sc.nextLine();
                                    System.out.println("Nome do professor: ");
                                    String nomeProfessor = sc.nextLine();

                                    System.out.println("Telefone: ");
                                    String telefone = sc.nextLine();

                                    System.out.println("Email: ");
                                    String email = sc.nextLine();

                                    System.out.println("Código de mátricula do professor: ");
                                    int matricula = sc.nextInt();

                                    Professor novoProfessor = new Professor(nomeProfessor, telefone, email, matricula);
                                    faculdade.addProfessor(novoProfessor);
                                    System.out.println("Professor adicionado com sucesso!\n");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;

                            case 2: // Remover Professor
                                try {
                                    System.out.println("Código de mátricula para remover: ");
                                    int codigoRemover = sc.nextInt();
                                    faculdade.removeProfessor(codigoRemover);
                                    System.out.println("Professor removido com sucesso!\n");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;

                            case 3: //Listar professores
                                System.out.println("\n--- LISTA DE PROFESSORES ---");
                                faculdade.listarProfessores().forEach(professor ->
                                        System.out.printf(
                                            "Matrícula: %d | Nome: %-20s | Status: %s%n",
                                            professor.getCodigo(),
                                            professor.getNome(),
                                            professor.getAtivo() ? "Ativo" : "Inativo"
                                            )
                                );
                                System.out.println("-----------------------\n");
                                break;
                            case 4: //Buscar professor pelo código
                                try {
                                    System.out.println("Código de matrícula para buscar:");
                                    int codigoBusca = sc.nextInt();
                                    Professor professorEncontrado = faculdade.buscarProfessorPeloCodigo(codigoBusca);
                                    System.out.printf(
                                            "\n--- ALUNO ENCONTRADO ---\nMatrícula: %d\nNome: %s\nEmail: %s\nStatus: %s%n%n",
                                            professorEncontrado.getCodigo(),
                                            professorEncontrado.getNome(),
                                            professorEncontrado.getEmail(),
                                            professorEncontrado.getAtivo() ? "Ativo" : "Inativo"
                                    );
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine(); // Limpar entrada inválida
                                }
                                break;

                            default:
                                System.out.println("Opção inválida!\n");

                        }
                    }

                case 3: //Turma

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
