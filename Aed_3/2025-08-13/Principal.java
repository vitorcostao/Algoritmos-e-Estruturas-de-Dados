import java.io.File;
import java.time.LocalDate;
import aeds3.*;

public class Principal {
    
    public static void main(String[] args) {
        
        (new File("./dados/livros.db")).delete();
        Livro l1 = new Livro("9788550825021", "Fundamentos da Inteligência Artificial: o futuro é agora", "Ricardo Murer", 1, LocalDate.of(2025, 3, 30) );
        Livro l2 = new Livro("9788539654352", "A (r)evolução das habilidades para o futuro do trabalho na era da inteligência artificial", "Martha Gabriel", 1, LocalDate.of(2025, 5, 20) );
        Arquivo arqLivros;

        try {
            arqLivros = new Arquivo("livros");

            arqLivros.create(l1);
            arqLivros.create(l2);

            arqLivros.close();

        } catch(Exception e) {
            e.printStackTrace();
        }        

    }

}
