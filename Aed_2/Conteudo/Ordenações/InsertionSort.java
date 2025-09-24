/**
 * Classe que implementa o algoritmo Insertion Sort para ordenação de arrays inteiros.
 *
 * <p><strong>Custo computacional:</strong></p>
 *
 * <p><strong>Comparações:</strong></p>
 * Melhor caso: C(n) = n - 1, pois o array já está ordenado e o `while` nunca é executado.  
 * Pior caso: C(n) = (n² - n)/2, quando o array está ordenado de forma decrescente.
 *
 * <p><strong>Movimentações:</strong></p>
 * Melhor caso: M(n) = 2(n - 1), apenas a movimentação para `tmp` e `array[j + 1] = tmp`.  
 * Pior caso: M(n) = [(n² + n)/2] - 1, somando movimentações do `for` e do `while`.
 */
public class InsertionSort {

    // Array estático encapsulado na classe
    private static int[] array;

    /**
     * Método utilitário para imprimir os elementos do array.
     */
    public static void imprimir(){

        for(int i = 0; i < array.length; i++){

            System.out.print(array[i] + " ");
        }
    
        System.out.println();
    }

    /**
     * Algoritmo de ordenação Insertion Sort.
     */
    public static void insertionSort(){
        
        // Definir dados
        int n = array.length;

        for(int i = 1; i < n; i++){

            int tmp = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > tmp){
                
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = tmp;
        }
    }

    /**
     * Método principal que executa o algoritmo de ordenação.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args){

        // Inicializar dados
        array = new int[] { 56, 12, 73, 98, 114 };

        System.out.println("Array desordenado:");
        imprimir();

        insertionSort();

        System.out.println("\nArray ordenado:");
        imprimir();
    }
}
