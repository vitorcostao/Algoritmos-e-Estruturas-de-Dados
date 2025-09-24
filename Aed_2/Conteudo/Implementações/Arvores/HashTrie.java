class No {

    public char elemento;
    public final int tamanho = 255;
    public No[] prox;
    public boolean folha;

    public No() {

        this(' ');
    }

    public No(char elemento) {
        this.elemento = elemento;
        this.prox = new No[tamanho];

        for (int i = 0; i < tamanho; i++) {

            prox[i] = null;
        }

        this.folha = false;
    }

    public static int Hash(char elemento) {

        return (int) elemento;
    }
}

public class HashTrie {

    private No raiz;

    public HashTrie() {

        this.raiz = new No();
    }

    public void inserir(String s) {

        inserir(s, raiz, 0);
    }

    private void inserir(String s, No no, int i) {

        if (no.prox[s.charAt(i)] == null) {

            no.prox[s.charAt(i)] = new No(s.charAt(i));

            if (i == s.length() - 1) {

                no.prox[s.charAt(i)].folha = true;
            } else {

                inserir(s, no.prox[s.charAt(i)], i + 1);
            }
        } else if (i < s.length() - 1) {

            inserir(s, no.prox[s.charAt(i)], i + 1);
        } else if (i == s.length() - 1) {

            no.prox[s.charAt(i)].folha = true;
        }
    }

    public boolean pesquisar(String s) throws Exception {

        return pesquisar(s, raiz, 0);
    }

    private boolean pesquisar(String s, No no, int i) throws Exception {

        boolean resp;

        if (no.prox[s.charAt(i)] == null) {

            resp = false;
        } else if (i == s.length() - 1) {

            resp = true;
        } else if (i < s.length() - 1) {

            resp = pesquisar(s, no.prox[s.charAt(i)], i + 1);
        } else {

            throw new Exception("Erro ao pesquisar");
        }

        return resp;
    }

    public void mostrar() {

        mostrar("", raiz);
    }

    private void mostrar(String s, No i) {

        if (i.folha == true) {

            System.out.println("Palavra: " + (s + i.elemento));
        }

        for (int j = 0; j < i.prox.length; j++) {

            if (i.prox[j] != null) {

                mostrar(s + i.elemento, i.prox[j]);
            }
        }

    }
}
