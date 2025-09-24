public class Principal {
    
    public static void main(String[] args) throws Exception{
        
        HashTrie arvore = new HashTrie();

        arvore.inserir("batata");
        arvore.inserir("batatao");

        arvore.mostrar();
    }
}
