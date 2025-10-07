package model;

import java.io.*;
import interfaces.Entidade;

public class Produto implements Entidade {

    private int id;
    private String nome;
    private String GTIN;
    private String descricao;

    // Construtor padrão
    public Produto() {
        this.id = -1;
        this.nome = " ";
        this.GTIN = " ";
        this.descricao = " ";
    }

    // Construtor com parâmetros
    public Produto(int id, String nome, String GTIN, String descricao) {
        this.id = id;
        this.nome = nome;
        this.GTIN = GTIN;
        this.descricao = descricao;
    }

    // Getters e Setters
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGTIN() {
        return GTIN;
    }

    public void setGTIN(String GTIN) {
        this.GTIN = GTIN;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Serialização para bytes
    @Override
    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        dos.writeInt(id);
        dos.writeUTF(nome);
        dos.writeUTF(GTIN);       // Corrigido: agora o GTIN é gravado
        dos.writeUTF(descricao);

        return baos.toByteArray();
    }

    // Desserialização de bytes
    @Override
    public void fromByteArray(byte[] ba) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);

        id = dis.readInt();
        nome = dis.readUTF();
        GTIN = dis.readUTF();     // Corrigido: agora o GTIN é lido
        descricao = dis.readUTF();
    }

    @Override
    public String toString() {
        return "\nNome: " + nome +
               "\nGTIN: " + GTIN +
               "\nDescrição: " + descricao +
               "\n--------------------------------------------";
    }
}
