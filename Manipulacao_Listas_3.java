package estruturados;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manipulacao_Listas_3 {

    public static Integer encontrarNElementosMaior(List<Integer> lista, int num) {
        // Verifica se a lista é vazia ou se tem menos de 'num' elementos
        if (lista == null || lista.size() < num) {
            return null; // Não possui o enésimo maior elemento
        }

        // Ordena a lista em ordem crescente
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i) > lista.get(j)) {
                    int aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

        // O enésimo maior elemento estará na posição (copiaLista.size() - num)
        return lista.get(lista.size() - num);
    }
    
    
    public static List<Integer> PegaLista() {
    	// Recebe os elementos da lista
    	Scanner scanner = new Scanner(System.in);
    	List<Integer> lista = new ArrayList<>();
    	System.out.println("Digite os números da lista (Digite 'FIM' para parar):");
    	
    	//Verifica se finalizou os numeros e para caso o usuário tenha digitado "FIM"
    	while (true) {
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("FIM")) {
                break; // Sai do loop quando o usuário digitar 'FIM'
            }

            try {
                int numero = Integer.parseInt(entrada);
                lista.add(numero);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido ou 'FIM' para parar.");
            }
        }
        return lista;
    }
    

    public static void main(String[] args) {
        List<Integer> lista = PegaLista();

        // Criar um novo scanner para ler o número para verificar a posicao maior
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a enésima colocação: ");
        int numero = scanner.nextInt();
        
        // Chama a função que verifica a lista de numeros e o n maior
        Integer NMaior = encontrarNElementosMaior(lista, numero);
        
        // Imprime os valores possiveis
        if (NMaior != null) {
            System.out.println("O " + numero + "º maior elemento é: " + NMaior);
        } else {
            System.out.println("Não há o " + numero + "º maior elemento na lista.");
        }

        // Fechar o scanner depois de usá-lo
        scanner.close();
    }
}
