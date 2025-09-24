public class Pilha extends Celula{
    
    // Definir dados
    public Celula topo;

    // Construtor
    public Pilha(){

        topo = null;
    }

    // Empilhar
    public void Empilhar(int x){

        // Definir dados
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
    }

    // Desempilhar
    public int Desempilhar(){

        // Definir dados
        int resp = topo.elemento;
        topo = topo.prox;

        return resp;
    }

    public void Imprimir(){

        Celula i;

        for(i = topo; i.prox != null; i = i.prox){

            System.out.print(i.elemento + " ");
        }

        System.out.println("");
    }

    

    public static void main(String[] args) {
        
        Pilha pilha = new Pilha();

        pilha.Empilhar(1);
        pilha.Empilhar(2);
        pilha.Empilhar(3);
        pilha.Empilhar(4);
        pilha.Empilhar(5);

        pilha.Imprimir();

        pilha.Desempilhar();
        pilha.Desempilhar();

        pilha.Imprimir();

    }
}
