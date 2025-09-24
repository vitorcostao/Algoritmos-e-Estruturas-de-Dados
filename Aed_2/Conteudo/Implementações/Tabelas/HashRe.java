public class HashRe {

    // Definir dados
    int tabela[]; // Tabela propriamente dita
    int tam; // Tamanho da tabela
    final int NULO = -1; // Indicador de nulicidade


    /**
     * Construtor padrão
     */
    public HashRe(){

        this.tabela = null;
        this.tam = -1;
    }

    /**
     * Construtor de inicialização da tabela
     * @param tam Tamanho da tabela
     */
    public HashRe(int tam){

        this.tabela = new int[tam];
        for(int i = 0; i < tam; i++){

            tabela[i] = NULO;
        }
    }

//------------------------------------------------------- Funções de pesquisa chave

    /**
     * Método para calcular chave de um elemento
     * @param elemento Elemento a ter posição procurada
     * @return Posição da chave do Elemento
     */
    public int hash(int elemento){

        return elemento % tam;
    }

    /**
     * Método para recalcular chave de um elemento
     * @param elemento Elemento a ter posição procurada
     * @return Posição da chave do Elemento
     */
    public int reHash(int elemento){

        return ++elemento % tam;
    }

    /**
     * Método para inserir elemento em uma tabela hash com rehash
     * @param elemento Elemento a ser inserido
     * @return Status da inserção
     * @throws Exception Tratamento de erros
     * 
     * Custo computacional O(1) -> Procura chave e insere corretamente
     * 
     */
    public boolean inserir(int elemento) throws Exception {

        // Definir dados
        boolean resp = false;

        if(elemento != NULO){
            int pos = hash(elemento);

            if(tabela[pos] == NULO){ 
               tabela[pos] = elemento;
               resp = true; 
            } else {

                pos = reHash(elemento);
                if(tabela[pos] != NULO){

                    tabela[pos] = elemento;
                    resp = true;
                }
            }
        }
        return resp;
    }

    /**
     * Método para pesquisar um elemento em uma tabela hash
     * @param elemento Elemento a ser pesquisado
     * @return Status da pesquisa
     * 
     * Custo computacional O(1) -> Procura a chave corretamente
     * 
     */
    public boolean pesquisar(int elemento){

        // Definir dados
        boolean resp = false;
        int pos = hash(elemento);

        if(tabela[pos] == elemento){

            resp = true;
        } else if(tabela[pos] != NULO){

            pos = reHash(elemento);
            if(tabela[pos] == elemento){

                resp = true;
            }
        }

        return resp;
    }

    public boolean remover(int elemento){

        // Definir dados
        boolean resp = false;

        if(elemento != NULO){

            int pos = hash(elemento);
            if(tabela[pos] == elemento){

               tabela[pos] = tabela[pos + 1];
               tabela[pos + 1] = NULO;
               resp = true; 
            } else {

                pos = reHash(elemento);
                if(tabela[pos] == elemento){

                    tabela[pos] = tabela[pos + 1];
                    tabela[pos + 1] = NULO;
                    resp = true;
                }
            }
        }

        return resp;
    }

}