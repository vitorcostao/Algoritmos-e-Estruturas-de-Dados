package model;
import aeds3.*;

public class ArquivoLivro extends Arquivo<Livro> {

    HashExtensivel<ParISBNID> indiceIndiretoISBN;

    public ArquivoLivro() throws Exception {
        super("livro", Livro.class.getConstructor());
        indiceIndiretoISBN = new HashExtensivel<>(ParISBNID.class.getConstructor, 4, "./dados/livros.isbn.d.db", "./dados/livros.isbn.c.db");
    }

    public int create(Livro livro) {
        int id = super.create(livro);
        indiceIndiretoISBN.create(new ParISBNID(livro.getISBN(), id));
    }
    
}
