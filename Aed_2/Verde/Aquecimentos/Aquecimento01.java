
public class Aquecimento01 {
    

    public static int Espelho(int n, int invertido){

        if(n == 0){

            return invertido;
        } else {

            return Espelho(n / 10, invertido * 10 + (n % 10));
        }
    }


    public static void main(String[] args){

        int[] array = {12, 43, 10, 55, 7, 99, 26, 78, 34, 61};
        int n = 10;

        // Seleção
        for(int i = 0; i < n - 1; i++){

            int menor = i;
            for(int j = i + 1; j < n; j++){

                if(array[j] < array[menor]){

                    menor = j;
                }
            }

            int tmp = array[i];
            array[i] = array[menor];
            array[menor] = tmp;
        }

        for(int i = 0; i < n; i++){

            System.out.print(array[i] + " ");
        }


        int[] array2 = {12, 43, 10, 55, 7, 99, 26, 78, 34, 61};

        for(int i = 0; i < n / 2; i++){

            int menor = i;
            int maior = i;
            for(int j = i + 1; j < n - i; j++){

                if(array2[j] < array2[menor]){

                    menor = j;
                }

                if(array2[j] > array2[maior]){

                    maior = j;
                }
            }

            if(menor != i){

                int tmp = array2[menor];
                array2[menor] = array2[i];
                array2[i] = tmp;
            }

            if(maior == i){

                maior = menor;
            }

            if(maior != n - i - 1){

                int tmp = array2[maior];
                array2[maior] = array2[n - i - 1];
                array2[n - i - 1] = tmp;
            }
        }

        System.out.println("\n");

        for(int i = 0; i < n; i++){

            System.out.print(array2[i] + " ");
        }
    }
}
