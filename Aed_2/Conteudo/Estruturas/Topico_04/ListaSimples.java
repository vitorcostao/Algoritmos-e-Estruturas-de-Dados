
public class ListaSimples extends Celula{

    @SuppressWarnings("FieldMayBeFinal")
    private Celula primeiro;
    private Celula ultimo;

    /**
     * Construtor para reservar espaço
     */
    public ListaSimples() {

        primeiro = new Celula();
        ultimo = primeiro;
    }

    /**
     * Inserir no inicio
     * 
     * @param x Valor a ser inserido
     */
    public void InserirInicio(int x) {

        // Definir dados
        Celula tmp = new Celula(x);

        // Atribuições
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;

        // Caso a lista esteja vazia
        if (primeiro == ultimo) {

            ultimo = tmp;
        }
    }

    /**
     * Inserir no fim
     * 
     * @param x Valor a ser inserido
     */
    public void InserirFim(int x) {

        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int getTam() {

        // Definir dados
        int cont = 0;

        for (Celula i = primeiro.prox; i != null; i = i.prox) {

            cont++;
        }

        return cont;
    }

    /**
     * Inserir em uma posição
     * 
     * @param x   Valor a ser inserido
     * @param pos Posição
     */
    public void InserirPos(int x, int pos) throws Exception {

        // Definir dados
        int tam = getTam();

        if (pos < 0 || pos > tam) {

            throw new Exception("ERROR: Posição inválida!\n");
        } else if (pos == 0) {

            InserirInicio(x);
        } else if (pos == tam) {

            InserirFim(x);
        } else {

            Celula i = primeiro;
            for (int j = 0; j < pos; j++) {

                i = i.prox;
            }

            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
        }
    }

    public int RemoverInicio() throws Exception {

        if (primeiro == ultimo) {

            throw new Exception("ERROR: Lista vazia!");
        }
    
        primeiro = primeiro.prox;
        int resp = primeiro.elemento;

        if (primeiro.prox == null) {

            ultimo = primeiro;
        }

        return resp;
    }

    public int RemoverPos(int pos) throws Exception {

        // Definir dados
        int tam = getTam();

        if (primeiro == ultimo) {

            throw new Exception("ERROR: Lista vazia!");
        }

        if (pos < 0 || pos > tam) {

            throw new Exception("ERROR: Posição inválida!");
        } else if (pos == 0) {

            return RemoverInicio();
        } else if (pos == tam) {

            return RemoverFim();
        } else {

            Celula i = primeiro;
            for (int j = 0; j < pos; j++) {

                i = i.prox;
            }

            int resp = i.prox.elemento;
            i.prox = i.prox.prox;

            return resp;
        }
    }

    public int RemoverFim() throws Exception {

        if (primeiro == ultimo) {

            throw new Exception("ERROR: Lista vazia!");
        }

        Celula i;
        for (i = primeiro; i.prox != ultimo; i = i.prox) {
        }

        int resp = ultimo.elemento;
        ultimo = i;
        ultimo.prox = null;

        return resp;
    }

    public void Imprimir() {

        Celula i;

        for (i = primeiro.prox; i != null; i = i.prox) {

            System.out.print(i.elemento + " ");
        }

        System.out.println("");
    }

    public static void main(String[] args) throws Exception {

        // Definir dados
        ListaSimples lista = new ListaSimples();

        // Métodos
        lista.InserirInicio(2);
        lista.InserirInicio(1);
        lista.InserirFim(4);
        lista.InserirPos(3, 2);
        lista.InserirInicio(0);

        lista.Imprimir();

        lista.RemoverInicio();
        lista.RemoverPos(2);
        lista.RemoverFim();

        lista.Imprimir();

        lista.InserirInicio(0);
        lista.InserirFim(4);
        lista.InserirPos(3, 2);

        lista.Imprimir();
    }

}