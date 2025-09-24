/**
 * Classe que implementa o algoritmo QuickSort para ordenação de arrays inteiros.
 *
 * <p><strong>Custo computacional:</strong></p>
 *
 * <p><strong>Comparações:</strong></p>
 * Melhor caso: C(n) = n * log(n), quando o pivô divide o array em metades iguais.  
 * Pior caso: C(n) = n², quando o pivô é o menor ou o maior elemento, tornando a divisão desequilibrada.
 *
 * <p><strong>Movimentações:</strong></p>
 * Melhor caso: M(n) ≈ 3 por chamada (quando i == j).  
 * Pior caso: M(n) = n / 2, pois o pivô pode estar mal posicionado, exigindo muitas trocas.
 */
public class QuickSort {

    // Array estático encapsulado na classe
    private static int[] array;

    /**
     * Realiza a troca de posição entre dois elementos do array.
     *
     * @param i Índice do primeiro elemento.
     * @param j Índice do segundo elemento.
     */
    public static void swap(int i, int j){

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Imprime os elementos do array.
     */
    public static void imprimir(){
        
        for(int i = 0; i < array.length; i++){
            
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Algoritmo de ordenação QuickSort.
     *
     * @param esq Índice inicial do subarray.
     * @param dir Índice final do subarray.
     */
    public static void quickSort(int esq, int dir){

        // Definir dados
        int i = esq, j = dir;
        int pivo = array[(esq + dir) / 2]; 

        // Implementação
        while(i <= j){
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;

            if(i <= j){
                swap(i, j);
                i++;
                j--;
            }
        }

        // Recursão
        if (esq < j) quickSort(esq, j);
        if (i < dir) quickSort(i, dir);
    }

    /**
     * Método principal para execução do algoritmo.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args){
        
        // Inicializar dados
        array = new int[] { 56, 12, 73, 98, 114 };

        System.out.println("Array desordenado:");
        imprimir();

        quickSort(0, array.length - 1);

        System.out.println("\nArray ordenado:");
        imprimir();
    }
}
