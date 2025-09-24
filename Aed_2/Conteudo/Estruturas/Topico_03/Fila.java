public class Fila {
    
    private int n;
    private int[] array;

    Fila(int capacidade){

        this.n = 0;
        this.array = new int [capacidade];
    }

    public void enfilerar(int value) throws Exception{

        // Verificação
        if(n >= array.length){

            throw new Exception("ERRO E");
        }

        array[n++] = value;
    }

    public int desenfilerar() throws Exception{

        if(n == 0){

            throw new Exception("ERRO D");
        }

        int resp = array[0];

        for(int i = 1; i < n; i++){

            array[i] = array[i + i];
        }

        n--;

        return resp;
    }

    public void mostrarFila(){

        if(n == 0){

            System.out.println("Fila vazia");
            return;
        }

        for(int i = 0; i < n; i++){

            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception{
        
        // Definir dados
        Fila fila = new Fila(6);

        fila.enfilerar(1);
        fila.enfilerar(2);
        fila.enfilerar(3);
        fila.enfilerar(4);
        fila.enfilerar(5);

        fila.desenfilerar();
        fila.desenfilerar();
        fila.desenfilerar();

        fila.mostrarFila();
    }
}
