package visualizacao;

import abstrato.Disciplina;
import abstrato.Turma;
import entidades.Aluno;
import entidades.Professor;
import medias.CalculaMediaIF;
import medias.MediaComum;
import medias.MediaUltimaProva;
import medias.RemoveMenorMedia;

import entidades.Aluno;
import excecoes.DadoInvalidoException;

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

                                    int matricula = faculdade.listarAlunos().size();

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


                                    int matricula = faculdade.listarProfessores().size();

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
                                sc.nextLine();
                                System.out.println("Informe o nome: ");
                                String nome = sc.nextLine();
                                System.out.println("Informe o telefone: ");
                                String telefone = sc.nextLine();
                                System.out.println("Informe o e-mail: ");
                                String email = sc.nextLine();
                                try {
                                    faculdade.addAluno(new Aluno(nome, telefone, email, faculdade.listarAlunos().size(), true));
                                } catch (DadoInvalidoException e) {
                                    if (nome.isEmpty()) {
                                        throw new DadoInvalidoException("nome");
                                    }
                                    if (telefone.length() != 11) {
                                        throw new DadoInvalidoException("telefone");
                                    }
                                    if (email.isEmpty() || !email.contains("@gmail.com") || !email.contains("@email.com") ||
                                            !email.contains("@hotmail.com")) {
                                        throw new DadoInvalidoException("E-mail");
                                    }
                                }
                        }
                    }

                case 3: //Turma
                    System.out.println("TURMA \n");
                    int segundaEscolhaTurma = getSegundaEscolhaTurma(sc);

                    while (segundaEscolhaTurma != 5) {
                        switch (segundaEscolhaTurma) {
                            case 1: // Adicionar Turma
                                try {
                                    sc.nextLine();
                                    System.out.println("Código da disciplina:");
                                    Disciplina disciplina = faculdade.buscarDisciplinaPorCodigo(sc.nextInt());

                                    System.out.println("Código do professor:");
                                    Professor professor = faculdade.buscarProfessorPeloCodigo(sc.nextInt());

                                    System.out.println("Quantidade de unidades:");
                                    int unidades = sc.nextInt();

                                    int codigoTurma = faculdade.listarTurmas().size();

                                    Turma novaTurma = new Turma(disciplina, professor, unidades, codigoTurma);
                                    faculdade.adicionarTurma(novaTurma);
                                    System.out.println("Turma criada!\n");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;

                            case 2: // Remover Turma
                                try {
                                    System.out.println("Código da turma:");
                                    faculdade.removerTurma(sc.nextInt());
                                    System.out.println("Turma removida!\n");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;

                            case 3: // Listar Turmas
                                System.out.println("\n--- LISTA DE TURMAS ---");
                                faculdade.listarTurmas().forEach(t ->
                                        System.out.printf(
                                                "Código: %d | Disciplina: %-15s | Professor: %-20s | Alunos: %d%n",
                                                t.getCodigo(),
                                                t.getDisciplina().getNomeDisciplina(),
                                                t.getProfessor().getNome(),
                                                t.getAlunosMatriculados().size()
                                        )
                                );
                                System.out.println("-----------------------\n");
                                break;

                            case 4: // Buscar Turma pelo código
                                try {
                                    System.out.println("Código da turma para buscar:");
                                    int codigoBusca = sc.nextInt();
                                    Turma turmaEncontrada = faculdade.buscarTurmaPorCodigo(codigoBusca);

                                    System.out.printf(
                                            "\n--- TURMA ENCONTRADA ---\nCódigo: %d\nDisciplina: %s\nProfessor: %s\nAlunos Matriculados: %d\nStatus: %s%n%n",
                                            turmaEncontrada.getCodigo(),
                                            turmaEncontrada.getDisciplina().getNomeDisciplina(),
                                            turmaEncontrada.getProfessor().getNome(),
                                            turmaEncontrada.getAlunosMatriculados().size(),
                                            turmaEncontrada.getAtivo() ? "Ativa" : "Inativa"
                                    );
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;

                            case 5: // Matricular Aluno
                                try {
                                    System.out.println("Código da turma:");
                                    int codTurma = sc.nextInt();

                                    System.out.println("Matrícula do aluno:");
                                    int matricula = sc.nextInt();

                                    faculdade.matricularAlunoEmTurma(codTurma, matricula);
                                    System.out.println("Matrícula realizada com sucesso!\n");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;

                            case 6: // Atribuir Nota
                                try {
                                    System.out.println("Código da turma:");
                                    int codTurma = sc.nextInt();

                                    System.out.println("Matrícula da turma:");
                                    int matricula = sc.nextInt();

                                    System.out.println("Unidade:");
                                    int unidade = sc.nextInt();

                                    System.out.println("Nota:");
                                    double nota = sc.nextDouble();

                                    faculdade.atribuirNotaEmTurma(codTurma, matricula, unidade, nota);
                                    System.out.println("Nota atribuída com sucesso!\n");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;

                            case 7: // Calcular Média
                                try {
                                    System.out.println("Código da turma:");
                                    int codTurma = sc.nextInt();
                                    System.out.println("Estratégia (1-Comum, 2-Remove Menor, 3-Última Prova):");
                                    CalculaMediaIF estrategia = switch(sc.nextInt()) {
                                        case 1 -> new MediaComum();
                                        case 2 -> new RemoveMenorMedia();
                                        case 3 -> new MediaUltimaProva();
                                        default -> throw new Exception("Estratégia inválida!");
                                    };

                                    System.out.println("Matrícula (0 para média geral):");
                                    int matricula = sc.nextInt();

                                    double media = (matricula == 0)
                                            ? faculdade.calcularMediaGeralDaTurma(codTurma, estrategia)
                                            : faculdade.calcularMediaAlunoEmTurma(codTurma, matricula, estrategia);

                                    System.out.printf("Média: %.2f%n%n", media);
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;
                        }
                        int escolhaTurma = getSegundaEscolhaTurma(sc);
                    }
                    break;

                case 4: // Disciplina
                    System.out.println("DISCIPLINA \n");
                    int segundaEscolhaDisciplina = getSegundaEscolha(sc);

                    while (segundaEscolhaDisciplina != 5) {
                        switch (segundaEscolhaDisciplina) {
                            case 1: // Adicionar Disciplina
                                try {
                                    sc.nextLine();
                                    System.out.println("Nome da disciplina:");
                                    String nome = sc.nextLine();

                                    System.out.println("Carga horária:");
                                    int horas = sc.nextInt();

                                    int codigoDisciplina = faculdade.listarDisciplinas().size();

                                    Disciplina novaDisciplina = new Disciplina(nome, horas, codigoDisciplina);
                                    faculdade.adicionarDisciplina(novaDisciplina);
                                    System.out.println("Disciplina adicionada com sucesso!\n");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;

                            case 2: // Remover Disciplina
                                try {
                                    System.out.println("Código da disciplina para remover:");
                                    faculdade.buscarDisciplinaPorCodigo(sc.nextInt()); // Verifica existência
                                    System.out.println("Operação não implementada (segundo requisito)\n");
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;

                            case 3: // Listar Disciplinas
                                System.out.println("\n--- LISTA DE DISCIPLINAS ---");
                                faculdade.listarDisciplinas().forEach(d ->
                                        System.out.printf(
                                                "Código: %d | Nome: %-20s | Carga Horária: %dh%n",
                                                d.getCodigoDisciplina(),
                                                d.getNomeDisciplina(),
                                                d.getHorasDisciplina()
                                        )
                                );
                                System.out.println("---------------------------\n");
                                break;

                            case 4: // Buscar Disciplina
                                try {
                                    System.out.println("Código da disciplina:");
                                    Disciplina disciplina = faculdade.buscarDisciplinaPorCodigo(sc.nextInt());
                                    System.out.printf(
                                            "\n--- DISCIPLINA ENCONTRADA ---\nCódigo: %d\nNome: %s\nCarga Horária: %dh%n%n",
                                            disciplina.getCodigoDisciplina(),
                                            disciplina.getNomeDisciplina(),
                                            disciplina.getHorasDisciplina()
                                    );
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage() + "\n");
                                    sc.nextLine();
                                }
                                break;
                        }
                        segundaEscolhaDisciplina = getSegundaEscolha(sc);
                    }

            }
            primeiraEscolha = getPrimeiraEscolha(sc);
        }
    }

    private static int getPrimeiraEscolha(Scanner sc) throws Exception {
      
        String prompt = "1. Aluno; \n2. Professor; \n3. Turma; \n4. Disciplina; \n5. Sair \nInsira o que deseja acessar: \n";
        System.out.println(prompt);
        int primeiraEscolha = sc.nextInt();

        if (primeiraEscolha < 0 || primeiraEscolha > 5) {
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
        System.out.println(promptDois);
        int segundaEscolha = sc.nextInt();

        if (segundaEscolha < 0 || segundaEscolha > 5) {
            throw new Exception("Escolha inválida");
        }
        return segundaEscolha;
    }

    private static int getSegundaEscolhaTurma(Scanner sc) throws Exception {
        String promptTurma = """
        1. Adicionar Turma;\s
        2. Remover Turma;\s
        3. Listar Turmas;\s
        4. Buscar Turma;\s
        5. Matricular Aluno;\s
        6. Atribuir Nota;\s
        7. Calcular Média;\s
        8. Voltar\s
        Insira a operação:\s
        """;
        System.out.println(promptTurma);
        int escolha = sc.nextInt();

        if (escolha < 1 || escolha > 8) {
            throw new Exception("Escolha inválida");
        }
        return escolha;
    }
}
