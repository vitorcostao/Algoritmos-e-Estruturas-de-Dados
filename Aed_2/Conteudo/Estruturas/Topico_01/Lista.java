public class Lista{

    // Dados
    private int n;
    private int[] array;

    // Construtor
    public Lista(int capacidade) throws Exception{
        
        if(capacidade <= 0){

            throw new Exception("ERROR: " + capacidade + " is an invalid number to initialize the list");
        }

        this.n = 0;
        this.array = new int[capacidade];
    }

    // Inserir no inicio
    public void InserirInicio(int value) throws Exception{

        if(n >= array.length){

            throw new Exception("ERROR: The list is full");
        }

        // Deslocamento da esquerda para direita
        for(int i = n; i > 0; i--){

            array[i] = array[i - 1];
        }

        array[0] = value;
        n++;
    }

    // Inserir no fim
    public void InserirFim(int value) throws Exception{

        if(n >= array.length){

            throw new Exception("ERROR: The list is full");
        }

        array[n] = value;
        n++;
    }

    // Inserir na posição 
    public void InserirPos(int value, int pos) throws Exception{

        if(n >= array.length || (pos < 0 || pos > n)){

            throw new Exception("ERROR: The list is full or the position is invalid");
        }

        for(int i = n; i > pos; i--){

            array[i] = array[i - 1];
        }

        array[pos] = value;
        n++;
    }

    // Remover no inicio
    public int RemoverInicio() throws Exception{

        if(n == 0){

            throw new Exception("ERROR: The list is empty");
        }

        int resp = array[0];
        n--;

        for(int i = 0; i < n; i++){

            array[i] = array[i + 1];
        }

        return resp;
    }

    // Remover no fim
    public int RemoverFim() throws Exception{
        
        if(n == 0){

            throw new Exception("ERROR: The list is empty");
        }

        return array[--n];
    }

    // Remover em uma posição
    public int RemoverPos(int pos) throws Exception{
        
        if(n == 0 || (pos < 0 || pos >= n)){

            throw new Exception("ERROR: The list is empty");
        }

        int resp = array[pos];
        n--;

        for(int i = pos; i < n; i++){

            array[i] = array[i + 1];
        }

        return resp;
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

    // Pesquisar elemento em uma lista
    public boolean Pesquisar(int ele){

        // Definir dados
        boolean resp = false;

        for(int i = 0; i < n; i++){

            if(array[i] == ele){

                resp = true;
                i = n;
            }
        }

        return resp;
    }

    public void InverterListaI() throws Exception{
        
        if(n == 0){

            throw new Exception("ERROR: The list is empty");
        }

        for(int i = 0; i < n / 2; i++){

            int tmp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = tmp;
        }

        System.out.println("\n");
        mostrarLista();
    }

    public void InverterListaR(int i) throws Exception{
        
        if(i == n / 2){

            System.out.println("\n");
            mostrarLista();
        } else {

            int tmp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = tmp;

            InverterListaR(i + 1);
        }
    }

    public static void main(String[] args) throws Exception{
        
        // Definir dados
        Lista lista = new Lista(10);

        
        // Inserir dados
        lista.InserirInicio(1);
        lista.InserirFim(3);
        lista.InserirPos(2, 1);

        // Mostrar Lista
        System.out.println("Lista com valores inseridos: ");
        lista.mostrarLista();
        
        /*
            // Pesquisar
            System.out.println("\n\nPesquisa Sequencial da lista: ");
            if(lista.Pesquisar(2)){

                System.out.println("Valor " + 2 + " encontrado!");
            } else {

                System.out.println("Valor " + 2 + " nao encontrado!");
            }

            // Remover dados
            System.out.println("\nRemocao dos dados: ");
            lista.RemoverPos(1);
            lista.mostrarLista();

            System.out.println("\n");

            lista.RemoverFim();
            lista.mostrarLista();

            System.out.println("\n");

            lista.RemoverInicio();
            lista.mostrarLista();

            System.out.println("\n");

            lista.RemoverInicio();
        */

        lista.InverterListaI();
        lista.InverterListaR(0);
    }
}