/**
 * Classe para ser Nó de uma árvore trie
 * 
 * -> Elemento(char)
 * -> Tamanho de possíveis sufixos
 * -> No[] (Possíveis sufixos)
 * -> Folha (Status do Nó)
 * 
 */
class No {

    // Definir dados
    public char elemento;
    public final int tamanho = 255;
    public No[] prox;
    public boolean folha;

    /**
     * Construtor padrão
     */
    public No() {

        this(' ');
    }

    /**
     * Construtor alternativo
     * 
     * @param elemento Elemento a ser criado
     * 
     *                 -> Reservar espaço na memória para possíveis nós futuros
     * 
     */
    public No(char elemento) {

        this.elemento = elemento;
        this.prox = new No[tamanho];

        for (int i = 0; i < tamanho; i++) {

            this.prox[i] = null;
        }

        this.folha = false;
    }

    /**
     * Método estático para calcular posição númerica de um caractere
     * 
     * @param x Caractere a ter posição procurada
     * @return Hash desse caractere
     */
    public static int hash(char x) {

        return (int) x;
    }
}

public class ArvoreTrie {

    // Definir dados
    @SuppressWarnings("FieldMayBeFinal")
    private No raiz;

    /**
     * Construtor padrão
     */
    public ArvoreTrie() {

        raiz = new No();
    }

    /**
     * Método para pesquisar Palavra em árvore
     * 
     * @param s String a ser procurada
     * @return Status da busca
     * @throws Exception Tratamento de erros
     */
    public boolean pesquisar(String s) throws Exception {

        return pesquisar(s, raiz, 0);
    }

    /**
     * Método para pesquisar Palavra em árvore
     * 
     * @param s  String a ser procurada
     * @param no Nó em análise
     * @param i  Índice da String
     * @return Status da pesquisa
     * @throws Exception Tratamento de erros
     * 
     *                   -> Se o no.prox[No.hash(s.charAt(i)) == null], ou seja, se
     *                   o Nó em análise for null, a palavra não existe
     *                   -> Senão, se (i == s.length() - 1), ou seja, se o Índice i
     *                   tiver o tamanho da String procurada e o Nó for uma folha,
     *                   encontramos
     *                   -> Senão, se (i < s.length() - 1), ou seja, se o Índice i
     *                   for menor que o tamanho da String, não encontramos,
     *                   logo resp = pesquisar(s, no.prox[No.Hash(s.charAt(i))], i +
     *                   1);
     *                   -> Senão, throw new Exception
     * 
     */
    private boolean pesquisar(String s, No no, int i) throws Exception {

        boolean resp;

        if (no.prox[(s.charAt(i))] == null) {

            resp = false;
        } else if (i == s.length() - 1) {

            resp = (no.prox[s.charAt(i)].folha == true);
        } else if (i < s.length() - 1) {

            resp = pesquisar(s, no.prox[(s.charAt(i))], i + 1);
        } else {

            throw new Exception("Erro ao pesquisar!");
        }

        return resp;
    }

    public void inserir(String s) throws Exception{

        inserir(s, raiz, 0);
    }

    private void inserir(String s, No no, int i) throws Exception{

        // Caso o nó não exista naquela posição, insira.
        // Senão, se não for uma folha e não tiver preenchindo inteiramente, insira.
        // Senão, erro
        if(no.prox[s.charAt(i)] == null){

            // Inserção
            no.prox[(s.charAt(i))] = new No(s.charAt(i));
            
            // Se ja tiver inserido a palavra completamente, o último nó é uma folha.
            // Senão apenas inserir
            if(i == s.length() - 1){

                no.prox[(s.charAt(i))].folha = true;
            } else {

                inserir(s, no.prox[(s.charAt(i))], i + 1);
            }
        } else if(no.prox[(s.charAt(i))].folha == false && i < s.length()){

            inserir(s, no.prox[(s.charAt(i))], i + 1);
        } else {

            throw new Exception("Erro ao inserir");
        }
    }

    public void mostrar(){

        mostrar("", raiz);
    }

    private void mostrar(String s, No i){

        if(i.folha == true){

            System.out.println("Palavra: " + (s + i.elemento));
        } else {

            for (No prox : i.prox) {
                if (prox != null) {
                    mostrar(s + i.elemento, prox);
                }
            }
        }
    }

    public int contarAs(){

        int resp = 0;
        if(raiz != null){

            resp = contarAs(raiz);
        }

        return resp;
    }

    private int contarAs(No i){

        int resp = (i.elemento == 'A') ? 1 : 0;

        if(i.folha == false){

            for (No prox : i.prox) {
                if (prox != null) {
                    resp += contarAs(prox);
                }
            }
        }

        return resp;
    }

}
