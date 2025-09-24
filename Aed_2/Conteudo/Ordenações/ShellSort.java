public class ShellSort {

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

    public static void Shell(){

        // Definir dados
        int h = 1;
    
        // Gap
        do { h = (h * 3) + 1;} while(h < array.length);

        // Ordenar
        do {

            h /= 3;

            for(int cor = 0; cor < h; cor++){

                InsercaoPorCor(cor, h);
            }

        } while(h != 1);
    }

    public static void InsercaoPorCor(int cor, int h){

        for(int i = (cor + h); i < array.length; i+=h){

            int tmp = array[i];
            int j = (i - h);

            while(j >= 0 && array[j] > tmp){

                array[j + h] = array[j];
                j-=h;
            }

            array[j + h] = tmp;
        }
    }

    public static void main(String[] args) {
        
        // Definir dados
        array = new int[] {5, 2, 9, 1, 3, 6};

        // Inicializar dados
        array = new int[] { 56, 12, 73, 98, 114 };

        System.out.println("Array desordenado:");
        imprimir();

        Shell();

        System.out.println("Array ordenado:");
        imprimir();
        
    }
}