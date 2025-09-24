import java.util.TreeSet;

public class Principal {
    
    public static void main(String[] args) throws Exception{
        
        // Definir dados
        Alvinegra arvore = new Alvinegra();
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(4);
    

        // Inserir
        arvore.inserir(1);
        arvore.inserir(2);
        arvore.inserir(3);
        arvore.inserir(4);
        arvore.inserir(5);

        arvore.caminharCentral();

    }
}
