

public class ListaDupla {
    
    public Celuladupla primeiro;
    public Celuladupla ultimo;

    public ListaDupla(){

        primeiro = new Celuladupla();
        ultimo = primeiro;
    }

    public void InserirInicio(int elemento){

        // Definir dados
        Celuladupla tmp = new Celuladupla(elemento);
        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;

        if(primeiro == ultimo){

            ultimo = primeiro.prox;
        } else {

            tmp.prox.ant = tmp;
        }
    }

    public int RemoverInicio() throws Exception{

        if(primeiro == ultimo){

            throw new Exception("ERROR");
        }

        // Definir dados
        int resp = primeiro.prox.elemento;
        primeiro = primeiro.prox;
        primeiro.ant = null;

        return resp;
    }

    public void InserirFim(int elemento){

        // Definir dados
        Celuladupla tmp = new Celuladupla(elemento);
        ultimo.prox = tmp;
        tmp.ant = ultimo;

        ultimo = ultimo.prox;
    }

    public int RemoverFim() throws Exception{

        if(primeiro == ultimo){

            throw new Exception("ERROR U");
        }

        // Definir dados
        int resp = ultimo.elemento;
        ultimo = ultimo.ant;
        ultimo.prox = null;

        return resp;
    }

    public int getTam(){

        int cont = 0;

        for(Celuladupla i = primeiro; i.prox != null; i = i.prox){

            cont++;
        }   

        return cont;
    }

    public void InserirPos(int elemento, int pos) throws Exception{

        // Definir dados
        int tam = getTam();

        if(pos < 0 || pos > tam){

            throw new Exception("ERROR: U");
        }

        if(pos == 0){

            InserirInicio(elemento);
        } else if(pos == tam){

            InserirFim(elemento);
        } else {

            Celuladupla i = primeiro;
            for(int j = 0; j < pos; j++){

                i = i.prox;
            }

            Celuladupla tmp = new Celuladupla(elemento);
            tmp.prox = i.prox;
            tmp.prox.ant = tmp;
            tmp.ant = i;
            i.prox = tmp;

        }
    }

    public int RemoverPos(int pos) throws Exception{

        // Definir dados
        int tam = getTam();

        if(pos < 0 || pos > tam){

            throw new Exception("ERROR: U");
        }

        if(pos == 0){

            return RemoverInicio();
        } else if(pos == tam){

            return RemoverFim();
        } else {

            Celuladupla i = primeiro;
            for(int j = 0; j < pos; j++){

                i = i.prox;
            }

            // Capturar elemento
            Celuladupla tmp = i.prox;
            int resp = tmp.prox.elemento;

            tmp.prox.ant = tmp.ant;
            tmp.ant.prox = tmp.prox;


            return resp;
        }
    }

    public void imprimir()  throws Exception{

        if(primeiro == ultimo){

            throw new Exception("Nada");
        }

        for (Celuladupla i = primeiro.prox; i != null; i = i.prox) {
            
            System.out.print(i.elemento + " ");
        }

        System.out.println();
    }

    public static void main(String[] args)  throws Exception{
        
        ListaDupla lista = new ListaDupla();

        lista.InserirInicio(5);
        lista.InserirInicio(4);
        lista.InserirInicio(3);
        lista.InserirFim(199);

        lista.imprimir();

        lista.RemoverInicio();

        lista.imprimir();

        lista.RemoverFim();

        lista.imprimir();

        lista.InserirPos(3423, 1);

        lista.imprimir();

        lista.RemoverPos(1);

        lista.imprimir();
    }

}
