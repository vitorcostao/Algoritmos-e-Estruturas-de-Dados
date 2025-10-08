import java.io.File;
import java.time.LocalDate;
import model.*;

public class Principal {
    
    public static void main(String[] args) {
        
        (new File("./dados/livro.db")).delete();
        (new File("./dados/livro.c.db")).delete();
        (new File("./dados/livro.d.db")).delete();
        (new File("./dados/livro.isbn.d.db")).delete();
        (new File("./dados/livro.isbn.c.db")).delete();
        Livro l1 = new Livro("9788550825021", "Fundamentos da Inteligência Artificial: o futuro é agora", "Ricardo Murer", 1, LocalDate.of(2025, 3, 30) );
        Livro l2 = new Livro("9788539654352", "A (r)evolução das habilidades para o futuro do trabalho na era da inteligência artificial", "Martha Gabriel", 1, LocalDate.of(2025, 5, 20) );
        Livro l3 = new Livro("9781732439146", "Create the Future: Tactics for Disruptive Thinking", "Jeremy Gutsche", 1, LocalDate.of(2020, 3, 10) );
        Livro l4 = new Livro("9788550807560", "Hábitos Atômicos: método fácil para criar bons hábitos", "James Clear", 1, LocalDate.of(2019, 8, 8) );
        ArquivoLivro arqLivros;

        try {
            arqLivros = new ArquivoLivro();

            arqLivros.create(l1);
            arqLivros.create(l2);
            arqLivros.create(l3);
            arqLivros.create(l4);

            Livro l = arqLivros.read("9788550825021");
            System.out.println(l);

            arqLivros.delete("9788550825021");

            arqLivros.close();

        } catch(Exception e) {
            e.printStackTrace();
        }        

    }

}
