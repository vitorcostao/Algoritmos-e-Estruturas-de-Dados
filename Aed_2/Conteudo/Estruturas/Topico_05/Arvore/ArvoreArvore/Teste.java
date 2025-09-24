/**
 * Nó para palavras em árvore
 */
class No2 {

    public String elemento;
    public No2 esq;
    public No2 dir;

    public No2(String elemento) {

        this.elemento = elemento;
        this.esq = this.dir = null;
    }

    public No2(String elemento, No2 esq, No2 dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }

}

/**
 * Nó para letras chave da árvore
 */
class No {

    public char elemento;
    public No esq, dir;
    public No2 outro;

    public No() {

        this.elemento = ' ';
        this.esq = null;
        this.dir = null;
        this.outro = null;
    }

    public No(char elemento, No esq, No dir) {

        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.outro = null;
    }
}

/**
 * Classe para implementar árvore de árvore binária de Caracteres e Strings
 * 
 * Lógica para inserção -> No e No2
 * No: Possui como dados um carctere, ponteiros para esquerda e direita e
 * ponteiro para árvore de strings
 * No2: Possui como dados uma string, ponteiros para esquerda e direita
 * 
 * Inserir primeiro caracteres da mesma forma que em uma árvore binária
 * tradicional
 * Para inserir uma String na posição correta é necessário que se procure a
 * chave usando s.charAt(0) para inserir no local correto.
 * Ao achar a chave correta, chama i.outro = inserir(s, i.outro).
 * 
 * A chamada da função (i.outro = inserir(s, i.outro)) executa igual a árvore
 * normal, porém usando compareTo.
 */
class ArvoreArvore {

    private No raiz;

    public ArvoreArvore() throws Exception{

        raiz = null;
        this.inserir('M');
        this.inserir('T');
        this.inserir('F');
        this.inserir('A');
        this.inserir('B');
        this.inserir('C');
        this.inserir('D');
        this.inserir('E');
        this.inserir('G');
        this.inserir('H');
        this.inserir('I');
        this.inserir('J');
        this.inserir('K');
        this.inserir('L');
        this.inserir('N');
        this.inserir('O');
        this.inserir('P');
        this.inserir('Q');
        this.inserir('R');
        this.inserir('S');
        this.inserir('U');
        this.inserir('V');
        this.inserir('W');
        this.inserir('X');
        this.inserir('Y');
        this.inserir('Z');
    }

    /**
     * Método para inserir caractere
     * 
     * @param elemento Elemento a ser inserido
     * @throws Exception Tratamento de erros
     */
    public void inserir(char elemento) throws Exception {

        raiz = inserir(elemento, raiz);
    }

    /**
     * Método privado para inserção de caractere
     * 
     * @param elemento Elemento a ser inserido
     * @param i        Nó em análise
     * @return Nó em análise alterado ou não
     * @throws Exception Tratamento de erros
     */
    private No inserir(char elemento, No i) throws Exception {

        if (i == null) {

            i = new No(elemento, null, null);
        } else if (elemento < i.elemento) {

            i.esq = inserir(elemento, i.esq);
        } else if (elemento > i.elemento) {

            i.dir = inserir(elemento, i.dir);
        } else {

            throw new Exception("Erro: elemento ja inserido");
        }

        return i;
    }

    /**
     * Método público para inserção de uma String
     * 
     * @param s String a ser inserida
     * @throws Exception Tratamento de erros
     */
    public void inserirString(String s) throws Exception {

        inserirString(s, raiz);
    }

    /**
     * Método privado para inserção de uma String
     * 
     * @param s String a ser inserida
     * @param i Nó em análise
     * @throws Exception Tratamento de erros
     * 
     * -> Pesquisar a chave correta e enviar a recursão
     * 
     */
    public void inserirString(String s, No i) throws Exception {

        if (i == null) {

            throw new Exception("Erro: caractere invalido");
        } else if(s.charAt(0) == i.elemento) {
            
            i.outro = inserirStringNo(s, i.outro);
        } else if (s.charAt(0) < i.elemento) {

            inserirString(s, i.esq);
        } else {

            inserirString(s, i.dir);
        }
    }

    /**
     * Método privado para inserir String
     * 
     * @param s Elemento a ser inserido
     * @param i Nó em análise
     * @return Nó em análise alterado ou não
     * @throws Exception Tratamento de erros
     * 
     *                   -> Buscar posição correta da String e insere
     * 
     */
    private No2 inserirStringNo(String s, No2 i) throws Exception {

        if (i == null) {

            i = new No2(s);
        } else if (s.compareTo(i.elemento) < 0) {

            i.esq = inserirStringNo(s, i.esq);
        } else if (s.compareTo(i.elemento) > 0) {

            i.dir = inserirStringNo(s, i.dir);
        } else {

            throw new Exception("Erro: elemento já inserido");
        }

        return i;
    }

    public void mostrar() {

        mostrar(raiz);
    }

    public void mostrar(No i) {

        if (i != null) {

            mostrar(i.esq);
            mostrar(i.outro);
            mostrar(i.dir);
        }
    }

    public void mostrar(No2 i) {

        if (i != null) {

            mostrar(i.esq);
            System.out.println(i.elemento + " ");
            mostrar(i.dir);
        }
    }

}

public class Teste {

    public static void main(String[] args) throws Exception {

        // Definir dados e inserções no construtor
        ArvoreArvore arvore = new ArvoreArvore();

        // Inserir palavras
        arvore.inserirString("Banana");
        arvore.inserirString("Acai");
        arvore.inserirString("Maca");

        arvore.mostrar();
    }

}
