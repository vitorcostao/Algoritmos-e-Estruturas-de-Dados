/**
 * Classe que implementa o algoritmo Selection Sort para ordenação de arrays inteiros.
 *
 * <p><strong>Custo computacional:</strong></p>
 *
 * <p><strong>Comparações:</strong></p>
 * C(n) = (n² - n) / 2  
 * Pois a cada iteração do laço externo, o interno realiza (n - i - 1) comparações.
 *
 * <p><strong>Movimentações:</strong></p>
 * M(n) = 3(n - 1)  
 * A cada iteração principal, ocorre 1 troca (3 movimentações: tmp, atribuição dupla).
 */
public class SelectionSort {

    // Array estático encapsulado na classe
    private static int[] array;

    /**
     * Imprime os elementos do array no console.
     */
    public static void imprimir(){

        for(int i = 0; i < array.length; i++){
            
            System.out.print(array[i] + " ");
        }
        System.out.println(); 
    }

    /**
     * Executa o algoritmo Selection Sort no array da classe.
     */
    public static void selectionSort(){

        // Definir dados
        int n = array.length;

        for(int i = 0; i < n - 1; i++){
           
            int menor = i;
            for(int j = i + 1; j < n; j++){
                
                if(array[j] < array[menor]){

                    menor = j;
                }
            }

            // Troca
            int tmp = array[i];
            array[i] = array[menor];
            array[menor] = tmp;
        }
    }

    /**
     * Método principal que define os dados e executa a ordenação.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args){

        // Inicializar dados
        array = new int[] { 56, 12, 73, 98, 114 };

        System.out.println("Array desordenado:");
        imprimir();

        selectionSort();

        System.out.println("Array ordenado:");
        imprimir();
    }
}
