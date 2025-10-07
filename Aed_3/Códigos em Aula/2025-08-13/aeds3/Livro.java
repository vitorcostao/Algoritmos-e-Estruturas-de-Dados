package aeds3;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.time.LocalDate;

public class Livro {
    public int id;
    public String isbn;
    public String titulo;
    public String autor;
    public byte edicao;
    public LocalDate dataPublicacao;

    public Livro() {
        this(-1, "", "", "", -1, LocalDate.now());
    }
        
    public Livro(String isbn, String titulo, String autor, int edicao, LocalDate data) {
        this(-1, isbn, titulo, autor, edicao, data);
    }

    public Livro(int id, String isbn, String titulo, String autor, int edicao, LocalDate data) {
        if(isbn.length()!=0 && isbn.length()!=13)
            throw new RuntimeException("ISBN inválido");
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = (byte)edicao;
        this.dataPublicacao = data;
    }

    /**
     * Método que converte livro em vetor de bytes
     * @return Retorna vetor de bytes
     * @throws Exception Tratamento de erros
     */
    public byte[] toByteArray() throws Exception {

        // Auxiliar de fluxo de saída de vetor de bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(this.id);
        dos.write(this.isbn.getBytes());
        dos.writeUTF(this.titulo);
        dos.writeUTF(this.autor);
        dos.writeByte(this.edicao);
        dos.writeInt((int)this.dataPublicacao.toEpochDay());
        
        return baos.toByteArray();
    }

}