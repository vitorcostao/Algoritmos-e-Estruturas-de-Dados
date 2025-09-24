public class Celula {

    public int elemento;
    public Celula prox;
    public int prio;

    public Celula() {

        this.elemento = -1;
        this.prox = null;
    }

    public Celula(int value) {

        this.elemento = value;
        this.prox = null;
    }

    public Celula(int value, int prio){

        this.elemento = value;
        this.prox = null;
        this.prio = prio;
    }
}
