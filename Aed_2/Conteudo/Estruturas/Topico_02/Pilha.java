public class Pilha {

    // Definir dados
    private int n;
    private int[] array;

    // Construtor
    public Pilha(int capacidade) throws Exception{
        
        if(capacidade <= 0){

            throw new Exception("ERROR: " + capacidade + " is an invalid number to initialize the list");
        }

        this.n = 0;
        this.array = new int[capacidade];
    }

    // Empilhar -> Inserir no fim
    public void Empilhar(int value) throws Exception{

        if(n >= array.length){

            throw new Exception("ERROR: The stack is full");
        }

        array[n] = value;
        n++;
    }

    // Desempilhar -> Remover no fim
    public int Desempilhar() throws Exception{

        if(n == 0){

            throw new Exception("ERROR: The stack is empty");
        }

        return array[--n];
    }

    // Mostrar
    public void mostrarPilha() throws Exception{

        if(n == 0){

            throw new Exception("ERROR: The stack is empty");
        }

        System.out.println("Pilha em ordem de remocao: ");

        for(int i = 0; i < n; i++){

            System.out.print(array[n - i - 1] + " ");
        }

        System.out.println("");
    }

    // Mostrar ordem de inserção
    public void MostrarOrdemInsercao(int i) throws Exception{

        if(n == 0){

            throw new Exception("ERROR: The stack is empty");
        }

        if(i == n){

        } else {

           System.out.print(array[i] + " "); 
           MostrarOrdemInsercao(i + 1); 
        }
    }

    // Pesquisar elemento em uma pilha
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

    public Lista toLista() throws Exception{
        
        Lista lista = new Lista(this.array.length);

        for(int i = 0; i < n; i++){

            lista.InserirFim(array[n - i - 1]);
        }

        return lista;
    }

    public static void main(String[] args) throws Exception{
        
        // Definir dados
        Pilha pilha = new Pilha(10);

        pilha.Empilhar(1);
        pilha.Empilhar(2);
        pilha.Empilhar(3);
        pilha.Empilhar(4);
        pilha.Empilhar(5);
        pilha.Empilhar(6);
        pilha.Empilhar(7);
        pilha.Empilhar(8);
        pilha.Empilhar(9);
        pilha.Empilhar(10);
        pilha.mostrarPilha();

        pilha.Desempilhar();
        pilha.Desempilhar();
        pilha.Desempilhar();
        pilha.Desempilhar();
        pilha.Desempilhar();
        pilha.mostrarPilha();

        if(pilha.Pesquisar(5)){

            System.out.println("\nTrue para o elemento " + 5);
        } else {

            System.out.println("\nFalse para o elemento " + 5);
        }

        Lista lista = pilha.toLista();

        System.out.println("\nPilha convertida");
        lista.mostrarLista();

        System.out.println("\n");
        pilha.MostrarOrdemInsercao(0);
    }
}

class Lista {

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
}
