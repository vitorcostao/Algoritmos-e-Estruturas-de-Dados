class No {

    // Definir dados
    public char elemento;
    public final int tamanho = 255;
    public No[] prox;
    public boolean folha;

    // Construtor padrão
    public No() {

        this(' ');
    }

    // Construtor alternativo
    public No(char elemento) {

        // Setar elemento
        this.elemento = elemento;

        // Array com nós
        prox = new No[tamanho];

        // Preencher array 
        for (int i = 0; i < tamanho; i++)
            prox[i] = null;

        // Folha como false
        folha = false;
    }

    public static int hash(char x) {

        return (int) x;
    }
}