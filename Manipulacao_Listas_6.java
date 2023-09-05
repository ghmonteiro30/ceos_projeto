package estruturados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manipulacao_Listas_6 {

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
	
	public static void ListaFatorial(List<Integer> lista1, List<Integer> lista2){
		int i=0, j=0, aux=0;
		//FUNÇÃO QUE VERIFICA AS 2 LISTAS E MUDA OS ELEMENTOS, NA LISTA 1 APENAS OS MAIORES, NA LISTA 2 OS MENORES
				while(i<lista1.size()) {
					if (j==lista2.size()) {
						i++;
						j=0;
					}else {
						if(lista1.get(i)<=lista2.get(j)) {
							aux = lista1.get(i);
		                    lista1.set(i, lista2.get(j));
							//vetor1[i] = vetor2[j];
		                    lista2.set(j, aux);
							//vetor2[j] = aux;
							j++;
		                    
							
						}else {
							j++;
						}
					}
				}
	}
	
	public static void main(String[] args) {
	    //RECEBENDO AS LISTAS
		List<Integer> lista1 = PegaLista();
	    List<Integer> lista2 = PegaLista();
	    
	    System.out.println("Lista 1 antes da ordenação: " + lista1);
	    System.out.println("Lista 2 antes da ordenação: " + lista2);
	    
	    //VERIFICANDO SE AS DUAS LISTAS POSSUEM O MESMO TAMANHO
	    if (lista1.size() != lista2.size()) {
	        System.out.println("As listas não possuem o mesmo tamanho.");
	        return; // Sai do método main
	    }
	    
	    //CHAMA A FUNÇÃO QUE MUDA OS ELEMENTOS
	    ListaFatorial(lista1, lista2);
	    
	    //IMPRIME AS DUAS LISTAS APOS O PROCESSAMENTO DOS ELEMENTOS
	    System.out.println("Lista 1 após a ordenação: " + lista1);
	    System.out.println("Lista 2 após a ordenação: " + lista2);
	}

}
