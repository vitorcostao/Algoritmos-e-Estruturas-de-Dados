/**
 * Classe que implementa o algoritmo Merge Sort para ordenação de arrays inteiros.
 */
public class MergeSort {

    // Array a ser ordenado
    private static int[] array;

    /**
     * Método principal do Merge Sort que divide o array recursivamente.
     *
     * @param esq Índice da esquerda do subarray.
     * @param dir Índice da direita do subarray.
     */
    public static void mergeSort(int esq, int dir){
        
        if(esq < dir){

            // Definir meio do array
            int meio = (esq + dir) / 2;

            // Divide o array em duas metades
            mergeSort(esq, meio);
            mergeSort(meio + 1, dir);

            // Intercala as duas metades ordenadas
            intercalar(esq, meio, dir); 
        }
    }

    /**
     * Método que intercala duas metades ordenadas do array.
     *
     * @param esq  Índice da esquerda do subarray.
     * @param meio Índice do meio do subarray.
     * @param dir  Índice da direita do subarray.
     */
    public static void intercalar(int esq, int meio, int dir){

        // Definir dados
        int n1, n2, i, j, k;

        // Tamanhos dos subarrays
        n1 = meio - esq + 1;
        n2 = dir - meio;

        // Arrays auxiliares com sentinela no final
        int[] a1 = new int[n1 + 1];
        int[] a2 = new int[n2 + 1];

        // Copia os elementos para os arrays auxiliares
        for(i = 0; i < n1; i++){
           
            a1[i] = array[esq + i];
        }
        for(j = 0; j < n2; j++){

            a2[j] = array[meio + j + 1];
        }

        // Sentinelas
        a1[i] = a2[j] = 0x7FFFFFFF;

        // Intercala os elementos de a1 e a2 de volta no array original
        i = j = 0;
        for(k = esq; k <= dir; k++){

            array[k] = (a1[i] <= a2[j]) ? a1[i++] : a2[j++];
        }
    }

    /**
     * Método utilitário para imprimir o array.
     *
     * @param array O array a ser impresso.
     */
    public static void Imprimir(int[] array){

        for(int i = 0; i < array.length; i++){

            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    /**
     * Método principal para executar o algoritmo.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args){

        // Inicializar dados
        array = new int[] {5, 2, 9, 1, 3, 6};

        // Mostrar array original
        System.out.println("Array original:");
        Imprimir(array);

        // Ordenar com merge sort
        mergeSort(0, array.length - 1);

        // Mostrar array ordenado
        System.out.println("Array ordenado:");
        Imprimir(array);
    }
}