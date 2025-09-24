public class CelulaM {

    // Definir dados
    public int elemento;
    public CelulaM sup, inf, ant, prox;

    public CelulaM(){

        this.elemento = -1;
        this.sup = null;
        this.inf = null;
        this.ant = null;
        this.prox = null;
    }

    public CelulaM(int elemento){

        this.elemento = elemento;
        this.sup = null;
        this.inf = null;
        this.ant = null;
        this.prox = null;
    }
}