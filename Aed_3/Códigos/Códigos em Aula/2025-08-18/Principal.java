import java.io.File;
import java.time.LocalDate;
import aeds3.*;

public class Principal {
    
    public static void main(String[] args) {
        
        (new File("./dados/livros.db")).delete();
        Livro l1 = new Livro("9788550825021", "Fundamentos da Inteligência Artificial: o futuro é agora", "Ricardo Murer", 1, LocalDate.of(2025, 3, 30) );
        Livro l2 = new Livro("9788539654352", "A (r)evolução das habilidades para o futuro do trabalho na era da inteligência artificial", "Martha Gabriel", 1, LocalDate.of(2025, 5, 20) );
        Arquivo<Livro> arqLivros;

        try {
            arqLivros = new Arquivo<>("livros", Livro.class.getConstructor());

            arqLivros.create(l1);
            arqLivros.create(l2);


            Livro l3;
            l3 = arqLivros.read(2);
            System.out.println(l3);

            l2.autor = "Martha dos Santos Gabriel";
            arqLivros.update(l2);
            l3 = arqLivros.read(2);
            System.out.println(l3);

            arqLivros.delete(1);
            l3 = arqLivros.read(1);
            System.out.println(l3);



            arqLivros.close();

        } catch(Exception e) {
            e.printStackTrace();
        }        

    }

}
