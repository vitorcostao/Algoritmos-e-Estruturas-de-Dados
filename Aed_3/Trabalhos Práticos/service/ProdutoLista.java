package service;

import java.io.*;
import interfaces.Entidade;

public class ProdutoLista implements Entidade {

    private int id;        // ID da associação
    private int idProduto; // ID do Produto
    private int idLista;   // ID da Lista

    // Construtor padrão
    public ProdutoLista() {
        this.id = -1;
        this.idProduto = -1;
        this.idLista = -1;
    }

    // Construtor parametrizado
    public ProdutoLista(int id, int idProduto, int idLista) {
        this.id = id;
        this.idProduto = idProduto;
        this.idLista = idLista;
    }

    // Getters e Setters
    @Override
    public int getId() { return id; }

    @Override
    public void setId(int id) { this.id = id; }

    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }

    public int getIdLista() { return idLista; }
    public void setIdLista(int idLista) { this.idLista = idLista; }

    // Serialização para arquivo binário
    @Override
    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        dos.writeInt(id);
        dos.writeInt(idProduto);
        dos.writeInt(idLista);

        return baos.toByteArray();
    }

    // Desserialização
    @Override
    public void fromByteArray(byte[] ba) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);

        id = dis.readInt();
        idProduto = dis.readInt();
        idLista = dis.readInt();
    }

    @Override
    public String toString() {
        return "ProdutoLista [id=" + id + ", idProduto=" + idProduto + ", idLista=" + idLista + "]";
    }
}
