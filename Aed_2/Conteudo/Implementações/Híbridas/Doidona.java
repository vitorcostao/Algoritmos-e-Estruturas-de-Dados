class Celula {

    // Definir dados
    public int elemento;
    public Celula prox;

    public Celula() {

        this(-1);
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

class Lista {

    public Celula primeiro, ultimo;

    public Lista() {

        this.primeiro = new Celula();
        this.ultimo = primeiro;
    }

    public void InserirFim(int elemento) {

        ultimo.prox = new Celula(elemento);
        ultimo = ultimo.prox;
    }

    public int removerInicio() throws Exception {

        if (ultimo == primeiro) {

            throw new Exception("Erro ao remover");
        }

        Celula tmp = primeiro.prox;
        int resp = tmp.elemento;
        primeiro.prox = tmp.prox;

        return resp;
    }
}

class No {

    public int elemento;
    public No esq, dir;

    public No() {
        this(-1);
    }

    public No(int elemento) {
        this.elemento = elemento;
        this.esq = this.dir = null;
    }
}

class Arvore {

    public No raiz;

    public Arvore() {
        
        this.raiz = new No();
    }

    public void inserir(int elemento) throws Exception{
        raiz = inserir(elemento, raiz);
    }

    private No inserir(int elemento, No i) throws Exception{

        if(i == null){

            i = new No(elemento);
        } else if(elemento < i.elemento){

            i.esq = inserir(elemento, i.esq);
        } else if(elemento > i.elemento){

            i.dir = inserir(elemento, i.dir);
        } else {

            throw new Exception("Erro ao inserir");
        }

        return i;
    }
    
    public boolean pesquisar(int elemento){

        return pesquisar(elemento, raiz);
    }

    private boolean pesquisar(int elemento, No i){

        boolean resp;

        if(i == null){

            resp = false;
        } else if(i.elemento == elemento){

            resp = true;
        } else if(elemento < i.elemento){

            resp = pesquisar(elemento, i.esq);
        } else {

            resp = pesquisar(elemento, i.dir);
        }

        return resp;
    }
}

class Doidona {

    // Constantes para determinar tamanho das tabelas
    final int TAM1 = 100;
    final int TAM3 = 100;
    final int NULO = -0X7FFFFF;

    // Arranjos das tabelas
    int[] t1;
    int[] t3;

    // Estruturas envolvidas
    Celula primeiroListaT2, ultimoListaT2;
    No raizArvoreT2, raizArvoreT3;

    /**
     * Construtor padrão
     */
    public Doidona(){

        t1 = new int[TAM1];
        t3 = new int[TAM3];

        for(int i = 0; i < TAM1; i++){

            t1[i] = NULO;
        }

        for(int i = 0; i < TAM3; i++){

            t3[i] = NULO;
        }

        primeiroListaT2 = ultimoListaT2 = new Celula();
        raizArvoreT2 = raizArvoreT3 = null;
    }

    public int hashT1(int elemento){
        
        return elemento % TAM1;
    }

    public int hashT2(int elemento){

        return ++elemento % TAM1;
    }

    public int hashT3(int elemento){

        return elemento % TAM3;
    }

    public int rehashT3(int elemento){

        return ++elemento % TAM3;
    }

    public void inserir(int elemento) throws Exception{

        int i = hashT1(elemento);

        if(elemento == NULO){

            throw new Exception("Erro ao inserir");
        } else if(t1[i] == NULO){

            t1[i] = elemento;
        } else if(hashT2(elemento) == 0){

            inserirT3(elemento);
        } else if(hashT2(elemento) == 1){

            inserirLista(elemento);
        } else if(hashT2(elemento) == 2){

            raizArvoreT2 = inserirArvore(elemento, raizArvoreT2);
        } else {

            throw new Exception("Erro ao inserir");
        }
    }

    public void inserirT3(int elemento) throws Exception{

        int i = hashT3(elemento);

        if(t3[i] == NULO){

            t3[i] = elemento;
        } else {

            i = rehashT3(elemento);
            if(t3[i] == NULO){

                t3[i] = elemento;
            } else {

                raizArvoreT3 = inserirArvore(elemento, raizArvoreT3);
            }
        }
    }

    public void inserirLista(int elemento){

        ultimoListaT2.prox = new Celula(elemento);
        ultimoListaT2 = ultimoListaT2.prox;
    }

    public No inserirArvore(int elemento, No i) throws Exception{

        if(i == null){

            i = new No(elemento);
        } else if(elemento < i.elemento){

            i.esq = inserirArvore(elemento, i.esq);
        } else if(elemento > i.elemento){

            i.dir = inserirArvore(elemento, i.dir);
        } else {

            throw new Exception("Erro ao inserir");
        }

        return i;
    }

    public boolean pesquisar(int elemento) {

        boolean resp;
        int i = hashT1(elemento);
        if(t1[i] == NULO){

            resp = false;
        } else if(t1[i] == elemento){

            return true;
        } else if(hashT2(elemento) == 0){

            resp = pesquisar3(elemento);
        } else if(hashT2(elemento) == 1){

            resp = pesquisarLista(elemento);
        } else if(hashT2(elemento) == 2){

            resp = pesquisarArvore(raizArvoreT2, elemento);
        } else {

            resp = false;
        }

        return resp;
    }

    public boolean pesquisar3(int elemento){

        boolean resp;
        int i = hashT3(elemento);

        if(t3[i] == NULO){

            resp = false;
        } else if(t3[i] == elemento){

            resp = true;
        } else {

            i = rehashT3(elemento);
            if(t3[i] == NULO){

                resp = false;
            } else if(t3[i] == elemento){

                return true;
            } else {

                resp = pesquisarArvore(raizArvoreT3, elemento);
            }
        }

        return resp;
    }

    public boolean pesquisarArvore(No i, int elemento){

        boolean resp;
        if(i == null){

            resp = false;
        } else if(i.elemento == elemento){

            resp = true;
        } else if(elemento < i.elemento){

            resp = pesquisarArvore(i.esq, elemento);
        } else {

            resp = pesquisarArvore(i.dir, elemento);
        }

        return resp;
    }

    public boolean pesquisarLista(int elemento){

        boolean resp = false;

        for(Celula i = primeiroListaT2.prox; i != null; i = i.prox){

            if(i.elemento == elemento){

                resp = true;
                i = ultimoListaT2;
            }
        }

        return resp; 
    }
}