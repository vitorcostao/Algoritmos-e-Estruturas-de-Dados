public class CountingSort {
    
    // Array estático encapsulado na classe
    private static int[] array;

    /**
     * Retorna o maior elemento do array.
     *
     * @return O maior valor presente no array.
     */
    public static int getMaior() {

        int maior = array[0];
        int n = array.length;

        for(int i = 1; i < n; i++){
            
            if(array[i] > maior){
                maior = array[i];
            }
        }
        return maior;
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public static void countingSort(){

        // Definir dados
        int n = array.length;
        int n2 = getMaior() + 1;
        int count[] = new int[getMaior() + 1];
        int[] ordenado = new int[n];

        // Inicializar array
        for(int i = 0; i < n2; i++){

            count[i] = 0;
        }

        // Contabilizar ocorrências dentro do array
        for(int i = 0; i < n; i++){

            count[array[i]]++;
        }

        // Count[i] possui número de elementos menor ou igual a i
        for(int i = 1; i < count.length; i++){

            count[i] += count[i - 1];
        }

        // Ordenado
        for(int i = n - 1; i >= 0; i--){

            ordenado[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copiando para array original
        for(int i = 0; i < n; i++){

            array[i] = ordenado[i];
        }
    }

    /**
     * Método utilitário para imprimir os elementos do array.
     */
    public static void imprimir() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(); // quebra de linha após a impressão
    }

    /**
     * Método principal para testar o Counting Sort.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        
        // Definir dados
        array = new int[] {56, 12, 73, 98, 114, 12, 73};

        System.out.println("Array desordenado:");
        imprimir();

        // Ordenação
        countingSort();
        

        System.out.println("\nArray ordenado:");
        imprimir();
    }
}

