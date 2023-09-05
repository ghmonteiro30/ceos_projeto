package estruturados;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class VetoresComNumerosIguais {
	
	//FUNÇÃO QUE ORDENA A LISTA
	public static List<Integer> ordenaVetor (List<Integer> lista){
		
		// ORDENA A LISTA EM ORDEM CRESCENTE
		for (int i = 0; i < lista.size(); i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                if (lista.get(i) > lista.get(j)) {
                    int aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }

		return lista;		
	}
	
	//FUNÇÃO QUE COMPARA AS LISTAS
	public static void comparaLista(List<Integer> lista1, List<Integer> lista2) {
		boolean igual = true;
		// VERIFICA SE AS LISTAS SÃO IGUAIS
        for(int i = 0; i<lista1.size(); i++) {        	
        	if (lista1.get(i)!=lista2.get(i)) {
        		igual = false;
        	}
        }
        
        // IMPRIME O RESULTADO
        if(igual) {
        	System.out.println("As listas são iguais");
        }else {
        	System.out.println("As listas são diferentes");
        }
	}
	
	//FUNÇÃO QUE LÊ OS ELEMENTOS DAS LISTAS
	public static List<Integer> PegaLista() {
    
		// RECEBE OS ELEMENTOS DA LISTA
    	Scanner scanner = new Scanner(System.in);
    	List<Integer> lista = new ArrayList<>();
    	System.out.println("Digite os números da lista (Digite 'FIM' para parar):");
    	
    	// VERIFICA SE FINALIZOU OS NUMEROS E PARA CASO O USUÁRIO TENHA DIGITADO "FIM"
    	while (true) {
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("FIM")) {
                break; // SAI DO LOOP QUANDO O USUARIO DIGITAR 'FIM'
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
    	//RECEBENDO AS LISTAS
    	List<Integer> lista1 = PegaLista();
    	List<Integer> lista2 = PegaLista();

        //IMPRIME AS LISTAS
        System.out.println("Vetor 1: " + lista1);
        System.out.println("Vetor 2: " + lista2);
        if(lista1.size()==lista2.size()) {
        	//ORDENA AS LISTAS
            lista1 = ordenaVetor(lista1);
            lista2 = ordenaVetor(lista2);
            
            //COMPARA AS LISTAS E IMPRIME OS RESULTADOS
            comparaLista(lista1, lista2);
        }else {
        	System.out.println("As listas não possuem o mesmo tamanho");
        	return;
        }
        
        
    }
}
