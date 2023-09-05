package estruturados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerMatrizDoUsuario {
	//FUNÇÃO PARA LER A MATRIZ DO ARQUIVO
    public static List<String[]> lerMatrizDoArquivo(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            List<String[]> matriz = new ArrayList<>();
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(" ");
                matriz.add(valores);
            }

            return matriz;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //FUNÇAO PARA LER O ARQUIVO QUE CONTEM A MATRIZ
    public static void LerArquivo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o caminho completo do arquivo de matriz (com extensão .txt): ");
        String caminhoArquivo = scanner.nextLine();

        if (caminhoArquivo.toLowerCase().endsWith(".txt")) {
            File arquivo = new File(caminhoArquivo);

            if (arquivo.exists() && arquivo.isFile()) {
                System.out.println("Nome do arquivo: " + caminhoArquivo);

                List<String[]> matriz = lerMatrizDoArquivo(caminhoArquivo);

                if (matriz != null) {
                    imprimirMatriz(matriz);
                    substituirRepetidosPorZero(matriz); // Substitui elementos repetidos por "0"
                    imprimirMatriz(matriz); // Imprime a matriz resultante
                } else {
                    System.out.println("Erro ao ler o arquivo: " + caminhoArquivo);
                }
            } else {
                System.out.println("O arquivo especificado não existe ou não é um arquivo válido.");
            }
        } else {
            System.out.println("O arquivo deve ter a extensão .txt.");
        }

        scanner.close();
    }
    
    //FUNÇAO PARA IMPRIMIR A MATRIZ
    public static void imprimirMatriz(List<String[]> matriz) {
        for (String[] linha : matriz) {
            for (String valor : linha) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
        System.out.println("_______________________________________________");
    }
    
    //FUNÇÃO QUE SUBSTITUI OS ELEMENTOS REPETIDOS QUE ESTÁ DENTRO DA MATRIZ
    public static void substituirRepetidosPorZero(List<String[]> matriz) {
        int linhas = matriz.size();

        for (int i = 0; i < linhas; i++) {
            String[] linhaAtual = matriz.get(i);

            for (int j = 0; j < linhaAtual.length; j++) {
                String elementoAtual = linhaAtual[j];

                boolean repetido = false;

                for (int x = 0; x < linhas; x++) {
                    if (x != i) {
                        String[] linhaComparada = matriz.get(x);
                        for (int y = 0; y < linhaComparada.length; y++) {
                            if (elementoAtual.equals(linhaComparada[y])) {
                                repetido = true;
                                break;
                            }
                        }
                    }
                    if (repetido) {
                        break;
                    }
                }

                if (repetido) {
                    linhaAtual[j] = "0";
                }
            }
        }
    }

    public static void main(String[] args) {
        LerArquivo();
    }
}
