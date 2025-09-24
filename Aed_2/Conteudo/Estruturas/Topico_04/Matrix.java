public class Matrix {
 
    // Definir dados
    public CelulaM inicio;
    public int rows;
    public int cols;

    public Matrix(){

        this.inicio = null;
        this.rows = 0;
        this.cols = 0;
    }


    public Matrix(int r, int c){

        // Alocar espaço para a Matrix
        this.inicio = new CelulaM();
        this.rows = r;
        this.cols = c;

        // 1) Alocar para a primeira Linha
        CelulaM atual = inicio;

        for(int i = 1; i < rows; i++){

            // Criar células e liga-las
            atual.prox = new CelulaM();
            atual.prox.ant = atual;
            atual = atual.prox;
        }


        // 2) Criar outras linhas usando Célula auxiliar para apontar para cima
        CelulaM linhaAnterior = inicio;

        for(int i = 1; i < rows; i++){

            // Criar células e liga-las verticalmente
            CelulaM NovaLinha = new CelulaM();
            NovaLinha.sup = linhaAnterior;
            linhaAnterior.inf = NovaLinha;

            // Criar células e liga-las horizontalmente
            atual = NovaLinha;
            CelulaM acima = linhaAnterior.prox;   
            
            for(int j = 1; j < cols; j++){

                // Ligando horizontalmente
                atual.prox = new CelulaM();
                atual.prox.ant = atual;

                // Andar para célula criada
                atual = atual.prox;

                // Ligar verticalmente
                atual.sup = acima;
                acima.inf = atual;

                // Andar para próxima coluna
                acima = acima.prox;
            }

            // Atualizar linha
            linhaAnterior = linhaAnterior.inf;
        }
    }

    public void InserirInicio(int value){

        inicio.elemento = value;
    }

    public void InserirFim(int value){

        // Definir dados
        CelulaM j = inicio;

        for(int i = 1; i < cols; i++){

            j = j.prox;
        }

        for(int k = 1; k < rows; k++){

            j = j.inf;
        }

        j.elemento = value;
    }

    public void Imprimir(){
        
        
        // Definir dados
        CelulaM linhaAtual = inicio;
        
        // Percorrer as linhas
        for(int i = 0; i < rows; i++){
            
            CelulaM colunaAtual = linhaAtual;
            
            // Percorrer as colunas de cada linha
            for(int j = 0; j < cols; j++){
                
                // Imprimir o valor da célula atual
                System.out.print(colunaAtual.elemento + " ");
                
                // Mover para a próxima célula na horizontal
                colunaAtual = colunaAtual.prox;
            }
    
            // Pular para a próxima linha e imprimir nova linha após as colunas
            System.out.println("");
            
            // Mover para a próxima linha
            linhaAtual = linhaAtual.inf;
        }
    }

    public void preencher(){

        // Definir dados
        CelulaM LinhaAtual = inicio;

        for(int i = 0; i < rows; i++){

            CelulaM ColunaAtual = LinhaAtual;
            for(int j = 0; j < cols; j++){

                ColunaAtual.elemento = 4;
                ColunaAtual = ColunaAtual.prox;
            }

            LinhaAtual = LinhaAtual.inf;
        }
    }

    public void DiagonalP(){

        // Definir dados
        CelulaM LinhaAtual = inicio;


        for(int i = 0; i < rows; i++){

            CelulaM ColunaAtual = LinhaAtual;
            for(int j = 0; j < cols; j++){

                if(j == i){

                    System.out.print(ColunaAtual.elemento);
                } else {

                    System.out.print(".");
                }

                ColunaAtual = ColunaAtual.prox;
            }

            System.out.println("");

            LinhaAtual = LinhaAtual.inf;
        }

        System.out.println("");
    }

    public void DiagonalS(){

        // Definir dados
        CelulaM LinhaAtual = inicio;


        for(int i = 0; i < rows; i++){

            CelulaM ColunaAtual = LinhaAtual;
            for(int j = 0; j < cols; j++){

                if(j == cols - i - 1){

                    System.out.print(ColunaAtual.elemento);
                } else {

                    System.out.print(".");
                }

                ColunaAtual = ColunaAtual.prox;
            }

            System.out.println("");

            LinhaAtual = LinhaAtual.inf;
        }

        System.out.println("");
    }

    public int getMaior(){

        // Definir dados
        CelulaM LinhaAtual = inicio;
        int resp = LinhaAtual.elemento;

        for(int i = 0; i < rows; i++){

            CelulaM colunaAtual = LinhaAtual;
            for(int j = 0; j < cols; j++){

                if(j == 0){


                } else {

                    if(resp < colunaAtual.elemento){

                        resp = colunaAtual.elemento;
                    }    
                }
                colunaAtual = colunaAtual.prox;
            }

            LinhaAtual = LinhaAtual.inf;
        }

        return resp;
    }
    
    

    public static void main(String[] args) {
        
        Matrix matrix = new Matrix(3, 3);

        matrix.preencher();
        matrix.InserirFim(32);

        matrix.Imprimir();
        matrix.DiagonalP();
        matrix.DiagonalS();
    
        int resp = matrix.getMaior();

        System.out.println(resp);

    }

}
