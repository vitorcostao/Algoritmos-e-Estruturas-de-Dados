package model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.time.LocalDate;

import aeds3.Entidade;

public class Livro implements Entidade {
    private int id;
    private String isbn;
    private String titulo;
    private String autor;
    private byte edicao;
    private LocalDate dataPublicacao;

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

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void setID(int id) {
        this.id = id;        
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public byte getEdicao() {
        return edicao;
    }

    public void setEdicao(byte edicao) {
        this.edicao = edicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] toByteArray() throws Exception {
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

    public void fromByteArray(byte[] vb) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(vb);
        DataInputStream dis = new DataInputStream(bais);
        this.id = dis.readInt();
        byte[] vb_isbn = new byte[13];
        dis.read(vb_isbn);
        this.isbn = new String(vb_isbn);
        this.titulo = dis.readUTF();
        this.autor = dis.readUTF();
        this.edicao = dis.readByte();
        this.dataPublicacao = LocalDate.ofEpochDay(dis.readInt());
    }

    public String toString() {
        return 
            "\nISBN..............: " + this.isbn +
            "\nTitulo............: " + this.titulo +
            "\nAutor.............: " + this.autor + 
            "\nEdição............: " + this.edicao +
            "\nData de publicação: " + this.dataPublicacao
        ;
    }

}