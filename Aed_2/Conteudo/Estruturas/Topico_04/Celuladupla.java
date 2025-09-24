public class Celuladupla {

    public int elemento;
    public Celuladupla prox;
    public Celuladupla ant;

    public Celuladupla() {

        this.elemento = -1;
        this.prox = null;
        this.ant = null;
    }

    public Celuladupla(int value) {

        this.elemento = value;
        this.prox = null;
        this.ant = null;
    }
}