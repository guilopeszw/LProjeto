package arquivos;

import entidades.Aluno;
import abstrato.Turma;
import excecoes.NotasIncompletasException;
import visualizacao.Faculdade;

import java.io.FileWriter;
import java.io.IOException;

public class Relatorio {

    public static void gerarRelatorioFinalTurma(Faculdade faculdade, int codigoTurma, String caminhoArquivo) {
        try {
            Turma turma = faculdade.buscarTurmaPorCodigo(codigoTurma);

            if (turma == null) {
                System.out.println("Turma não encontrada.");
                return;
            }

            StringBuilder relatorio = new StringBuilder();
            relatorio.append(String.format("--- RELATÓRIO FINAL DA TURMA %d ---\n", turma.getCodigo()));
            // recebe o nome
            for (Aluno aluno : turma.getAlunosMatriculados().values()) {
                relatorio.append(String.format("Aluno: %s\n", aluno.getNome()));

                double somaNotas = 0;
                int unidades = turma.getQuantUnidades();

                // recebe as notas de cada unidade
                for (int unidade = 1; unidade <= unidades; unidade++) {
                    Double nota;
                    nota = turma.getNotaPorUnidade(aluno.getCodigo(), unidade);
                    if (nota == null) {
                        String faltaNota = "-";
                        relatorio.append(String.format("  Unidade %d: %.2f\n", unidade, faltaNota));
                        throw new NotasIncompletasException();
                    }
                    else {
                        relatorio.append(String.format("  Unidade %d: %.2f\n", unidade, nota));
                    }
                    somaNotas += nota;
                }

                double mediaFinal = somaNotas / unidades;
                String resultado = mediaFinal >= 7.0 ? "APROVADO" : "REPROVADO";

                relatorio.append(String.format("  Média Final: %.2f\n", mediaFinal));
                relatorio.append(String.format("  Resultado: %s\n\n", resultado));
            }

            System.out.println(relatorio.toString()); // Imprime na tela

            // Salvar no arquivo TXT
            try (FileWriter writer = new FileWriter(caminhoArquivo)) {
                writer.write(relatorio.toString());
                System.out.println("Relatório salvo em " + caminhoArquivo);
            }
        } catch (Exception e) {
            System.out.println("Erro ao gerar relatório: " + e.getMessage());
            e.printStackTrace();
        }
    }
}