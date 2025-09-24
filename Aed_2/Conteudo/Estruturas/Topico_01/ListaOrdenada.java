public class ListaOrdenada {
    
    // Definir dados
    private int n;
    private int[] array;

    // Construtor
    public ListaOrdenada(int capacidade) throws Exception{

        if(capacidade <= 0){

            throw new Exception("ERROR: Its not possible to declare a list - capacidade <= 0");
        }

        this.n = 0;
        this.array = new int[capacidade];
    }

    public int getLength(){

        return n;
    }

    // Inserção
    public void InserirO(int value) throws Exception{

        if(n >= array.length){

            throw new Exception("ERROR: The list is full");
        }

        int i = n;

        while(i > 0 && array[i - 1] > value){

            array[i] = array[i - 1];
            i--;
        }

        array[i] = value;
        n++;
    
    }

    // Remoção
    public int RemoverInicio() throws Exception{

        if(n == 0){

            throw new Exception("ERROR: The list is empty");
        }

        // Definir dados
        n--;
        int resp = array[0];

        for(int i = 0; i < n; i++){

            array[i] = array[i + 1];
        }

        return resp;
    }

    public int RemoverPos(int pos) throws Exception{

        if(n == 0 || pos < 0 || pos >= n){

            throw new Exception("ERROR: The list is empty");
        }

        // Definir dados
        n--;
        int resp = array[pos];

        for(int i = pos; i < n; i++){

            array[i] = array[i + 1];
        }

        return resp;
    }

    public int RemoverFim() throws Exception{

        if(n == 0){

            throw new Exception("ERROR: The list is empty");
        }

        return array[--n];
    }

    public boolean isOrdered(){

        // Definir dados
        boolean resp = true;

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){

                if(array[i] > array[j]){

                    resp = false;
                    j = n;
                    i = n - 1;
                }
            }
        }

        return resp;
    }

    public boolean Search(int value, int esq, int dir){
        
        if(esq > dir){

            System.out.println("O valor nao esta na lista");
            return false;
        }

        int meio = (esq + dir) / 2;
        if(array[meio] == value){

           System.out.println("O valor esta na lista");
           return true;
        } else if(array[meio] < value){

           return Search(value, meio + 1, dir);
        } else if(array[meio] > value){

           return Search(value, esq, meio - 1);
        }
        
        return false;
    }

    // Mostrar lista
    public void mostrarLista() throws Exception{

        if(n == 0){

            throw new Exception("ERROR: The list is empty");
        }

        for(int i = 0; i < n; i++){

            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception{
        
        // Definir dados
        ListaOrdenada lista = new ListaOrdenada(10);

        // InserirO dados
        lista.InserirO(6);
        lista.InserirO(3);
        lista.InserirO(1);
        lista.InserirO(4);
        lista.InserirO(7);
        lista.InserirO(10);
        lista.InserirO(8);
        lista.InserirO(9);
        lista.InserirO(2);
        lista.InserirO(5);
        lista.mostrarLista();

        System.out.println("");
        System.out.println("");

        lista.RemoverFim();
        lista.mostrarLista();
        System.out.println("");
        lista.RemoverInicio();
        lista.mostrarLista();
        System.out.println("");
        lista.RemoverPos(3);
        lista.mostrarLista();
        System.out.println("");

        System.out.println("");

        if(lista.isOrdered()){

            System.out.println("True");
        } else {

            System.out.println("False");
        }

        lista.Search(4, 0, lista.getLength());
    }

}
