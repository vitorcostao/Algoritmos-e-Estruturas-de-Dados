class No {

    int elemento;
    No esq, dir;

    public No() {

        this(-1);
    }

    public No(int elemento) {
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
    }
}

class Celula {

    int elemento;
    Celula prox;

    public Celula() {
        this(-1);
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

class CelulaT1 {

    int item;
    T2 t2;

    public CelulaT1() {

        this(-1);
    }

    public CelulaT1(int item) {
        this.item = item;
        this.t2 = new T2();
    }
}

class T3 {

    No raiz;
    Celula primeiro;

    public T3() {

        raiz = null;
        primeiro = null;
    }

    public int hashT3(int x) {

        return x % 2;
    }

    public boolean pesquisarArvore(int x, No i) {

        boolean resp;

        if (i == null) {

            resp = false;
        } else if (x == i.elemento) {

            resp = true;
        } else if (x < i.elemento) {

            resp = pesquisarArvore(x, i.esq);
        } else {

            resp = pesquisarArvore(x, i.dir);
        }

        return resp;
    }

    public boolean pesquisarLista(int x) {

        boolean resp = false;

        for (Celula i = primeiro.prox; i != null; i = i.prox) {

            if (i.elemento == x) {

                resp = true;
                i = null;
            }
        }

        return resp;
    }

    public void inserirArvore(int x) throws Exception {

        raiz = inserirArvore(x, raiz);
    }

    private No inserirArvore(int x, No i) throws Exception {

        if (i == null) {

            i = new No(x);
        } else if (x < i.elemento) {

            i.esq = inserirArvore(x, i.esq);
        } else if (x > i.elemento) {

            i.dir = inserirArvore(x, i.dir);
        } else {

            throw new Exception("Erro ao inserir");
        }

        return i;
    }

    public void inserirLista(int x) {

        if (primeiro.prox == null) {
            primeiro.prox = new Celula(x);
        } else {

            Celula i;
            for (i = primeiro.prox; i.prox != null; i = i.prox)
                ;
            i.prox = new Celula(x);
        }
    }
}

class T2 {

    int[] tabela;
    T3 t3;

    public T2() {
        tabela = new int[5];
        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = -1;
        }
        t3 = new T3();
    }

    public int hashT2(int x) {

        return x % 5;
    }

    public int rehashT2(int x) {

        return ++x % 5;
    }
}

class T1 {

    CelulaT1[] tabela;

    public T1() {
        tabela = new CelulaT1[5];
        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = new CelulaT1(i);
            tabela[i].t2 = new T2();
        }
    }

    public int hash(int x) {

        return x % 5;
    }
}

class Hibrida {

    T1 t1;

    public Hibrida() {
        t1 = new T1();
    }

    public boolean pesquisar(int x) throws Exception {

        boolean resp;
        int i = t1.hash(x);

        if (t1.tabela[i].item == -1) {

            resp = false;
        } else if (t1.tabela[i].item == x) {

            resp = true;
        } else {

            int j = t1.tabela[i].t2.hashT2(x);
            int dado = t1.tabela[i].t2.tabela[j];

            if (dado == -1) {

                resp = false;
            } else if (dado == x) {

                resp = true;
            } else if (t1.tabela[i].t2.rehashT2(x) == 0) {

                resp = t1.tabela[i].t2.t3.pesquisarArvore(x, t1.tabela[i].t2.t3.raiz);
            } else if (t1.tabela[i].t2.rehashT2(x) == 1) {

                resp = t1.tabela[i].t2.t3.pesquisarLista(x);
            } else {

                throw new Exception("Erro ao pesquisar");
            }
        }

        return resp;
    }

    public void inserir(int x) throws Exception {
        int i = t1.hash(x); // índice T1

        if (t1.tabela[i].item == -1) {
            // T1 livre: insere direto
            t1.tabela[i].item = x;
        } else {
            // T1 ocupado: tenta T2
            int j = t1.tabela[i].t2.hashT2(x);

            if (t1.tabela[i].t2.tabela[j] == -1) {
                // Posição T2 livre: insere
                t1.tabela[i].t2.tabela[j] = x;
            } else {
                // Colisão em T2: usa rehash para decidir reserva em T3
                int r = t1.tabela[i].t2.rehashT2(x);

                if (r == 0) {
                    // Insere na árvore
                    t1.tabela[i].t2.t3.inserirArvore(x);
                } else if (r == 1) {
                    // Insere na lista
                    t1.tabela[i].t2.t3.inserirLista(x);
                } else {
                    throw new Exception("Erro ao inserir: valor inválido para rehashT2");
                }
            }
        }
    }

}

public class Exercicio {

    public static void main(String[] args) throws Exception {

        Hibrida estruHibrida = new Hibrida();

        estruHibrida.inserir(1);

        if (estruHibrida.pesquisar(2)) {

            System.out.println("A");
        } else {

            System.out.println("B");
        }
    }
}
