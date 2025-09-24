class Celula {

    // Definir dados
    public int elemento;
    public Celula prox;
    public Celula ant;
    public Celula sup;
    public Celula inf;

    // Construtor padrão
    public Celula() {
        this.elemento = 0;
        this.prox = null;
        this.ant = null;
        this.sup = null;
        this.inf = null;
    }

    // Construtor alternativo
    public Celula(int elemento) {
        this.elemento = elemento;
        this.prox = null;
        this.ant = null;
        this.sup = null;
        this.inf = null;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }
}

class Matriz {

    // Definir dados
    private Celula inicio;
    private int rows;
    private int cols;

    public Matriz(int rows, int cols) {
        
        this.rows = rows;
        this.cols = cols;
        this.inicio = new Celula();
        Celula linhaAtual = inicio;
        Celula atual = linhaAtual;

        for (int i = 1; i < cols; i++) {
            atual.prox = new Celula();
            atual.prox.ant = atual;
            atual = atual.prox;
        }

        for (int j = 1; j < rows; j++) {

            linhaAtual.inf = new Celula();
            linhaAtual.inf.sup = linhaAtual;
            Celula atualLinha = linhaAtual.inf;
            Celula acima = linhaAtual.prox;
            Celula atualCol = atualLinha;


            for (int i = 1; i < cols; i++) {
                atualCol.prox = new Celula();
                atualCol.prox.ant = atualCol;
                atualCol = atualCol.prox;

                if (acima != null) {
                    atualCol.sup = acima;
                    acima.inf = atualCol;
                    acima = acima.prox;
                }
            }

            linhaAtual = linhaAtual.inf;
        }
    }

    public static Matriz SomarMatriz(Matriz matriz1, Matriz matriz2) {

        // Definir dados
        Matriz resp = new Matriz(matriz1.rows, matriz1.cols);
        Celula LinhaAtual1 = matriz1.inicio;
        Celula LinhaAtual2 = matriz2.inicio;
        Celula LinhaAtualResp = resp.inicio;
        Celula atual1 = LinhaAtual1;
        Celula atual2 = LinhaAtual2;
        Celula atualResp = LinhaAtualResp;

        for (int i = 0; i < matriz1.rows; i++) {
            for (int j = 0; j < matriz1.cols; j++) {

                atualResp.setElemento(atual1.getElemento() + atual2.getElemento());
                atual1 = atual1.prox;
                atual2 = atual2.prox;
                atualResp = atualResp.prox;
            }

            LinhaAtualResp = LinhaAtualResp.inf;
            LinhaAtual1 = LinhaAtual1.inf;
            LinhaAtual2 = LinhaAtual2.inf;
            atualResp = LinhaAtualResp;
            atual1 = LinhaAtual1;
            atual2 = LinhaAtual2;
        }

        return resp;
    }

    public static Matriz MultiplicarMatrix(Matriz matriz1, Matriz matriz2) {

        // Definir dados
        Matriz resp = new Matriz(matriz1.rows, matriz2.cols);
        Celula linhaResp = resp.inicio;
        Celula linha1 = matriz1.inicio;

        for (int i = 0; i < matriz1.rows; i++) {
            Celula colunaResp = linhaResp;

            for (int j = 0; j < matriz2.cols; j++) {
 
                int soma = 0;
                Celula atual1 = linha1;
                Celula atual2 = matriz2.inicio;
                
                for (int k = 0; k < j; k++) {

                    atual2 = atual2.prox;
                }

                for(int k = 0; k < matriz1.cols; k++){

                    soma += atual1.getElemento() * atual2.getElemento();
                    atual1 = atual1.prox;
                    atual2 = atual2.inf;
                }

                colunaResp.setElemento(soma);
                colunaResp = colunaResp.prox;
            }

            linhaResp = linhaResp.inf;
            linha1 = linha1.inf;
        }

        return resp;
    }



    public void DiagonalPrincipal() {

        // Definir dados
        Celula LinhaAtual = inicio;
        Celula atual = LinhaAtual;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i == j) {

                    System.out.print(atual.getElemento() + " ");
                }

                atual = atual.prox;
            }

            LinhaAtual = LinhaAtual.inf;
            atual = LinhaAtual;
        }

        System.out.println("");
    }

    public void DiagonalSecundaria() {

        // Definir dados
        Celula LinhaAtual = inicio;
        Celula atual = LinhaAtual;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i + j == rows - 1) {

                    System.out.print(atual.getElemento() + " ");
                }

                atual = atual.prox;
            }

            LinhaAtual = LinhaAtual.inf;
            atual = LinhaAtual;
        }

        System.out.println("");
    }

    public void PreencherMatriz() {

        // Definir dados
        Celula LinhaAtual = inicio;
        Celula atual = LinhaAtual;
        int dado;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                dado = MyIO.readInt();
                atual.setElemento(dado);
                atual = atual.prox;
            }

            LinhaAtual = LinhaAtual.inf;
            atual = LinhaAtual;
        }
    }

    public void imprimirMatriz() {

        // Definir dados
        Celula LinhaAtual = inicio;
        Celula atual = LinhaAtual;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                System.out.print(atual.getElemento() + " ");
                atual = atual.prox;
            }

            System.out.println();
            LinhaAtual = LinhaAtual.inf;
            atual = LinhaAtual;
        }
    }
}

public class Q11 {

    public static void main(String[] args) {

        // Definir dados
        int rows1, cols1;
        int rows2, cols2;
        int n;

        n = MyIO.readInt();

        for (int i = 0; i < n; i++) {

            // Matriz 1
            rows1 = MyIO.readInt();
            cols1 = MyIO.readInt();
            Matriz matriz1 = new Matriz(rows1, cols1);
            matriz1.PreencherMatriz();

            // Diagonal principal e secundária
            matriz1.DiagonalPrincipal();
            matriz1.DiagonalSecundaria();

            // Matriz 2
            rows2 = MyIO.readInt();
            cols2 = MyIO.readInt();
            Matriz matriz2 = new Matriz(rows2, cols2);
            matriz2.PreencherMatriz();

            Matriz matrizSoma = Matriz.SomarMatriz(matriz1, matriz2);
            matrizSoma.imprimirMatriz();

            Matriz matrizMultiplicacao = Matriz.MultiplicarMatrix(matriz1, matriz2);
            matrizMultiplicacao.imprimirMatriz();
        }
    }
}