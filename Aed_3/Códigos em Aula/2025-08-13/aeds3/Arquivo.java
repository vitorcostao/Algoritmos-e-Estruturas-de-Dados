package aeds3;

import java.io.*;

/**
 * Classe para tratar Arquivos
 */
public class Arquivo {

    // Definir dados
    RandomAccessFile arquivo; // Ponteiro de acesso aleatório de dados
    String nomeArquivo; // Nome do arquivo

    /**
     * Construtor que recebe nome do arquivo
     * 
     * @param nomeArquivo Nome do arquivo
     * @throws Exception Tratamento de erros
     */
    public Arquivo(String nomeArquivo) throws Exception {

        // Atribuição
        this.nomeArquivo = nomeArquivo;
        arquivo = new RandomAccessFile("./dados/" + nomeArquivo + ".db", "rw"); // Cria ponteiro para acesso aleatório

        if (arquivo.length() < 4) {
            arquivo.writeInt(0);
        }
    }

    /**
     * Método para criar um livro e adicionar em arquivo
     * @param livro Livro a ser adicionado
     * @throws Exception Tratamento de erros
     */
    public void create(Livro livro) throws Exception {

        // Obtem o ID para esta entidade
        arquivo.seek(0); // Ponteiro para posição inicial do arquivo
        int novoId = arquivo.readInt() + 1; // Novo ID
        arquivo.seek(0); // Ponteiro para posição inicial do arquivo
        arquivo.writeInt(novoId); // Escreve maior valor de Id
        livro.id = novoId; // Atribuição dos dados

        // Escreve o novo registro no fim do arquivo
        arquivo.seek(arquivo.length()); // Acessa última posição do arquivo
        byte[] vb = livro.toByteArray(); // Converte livro em vetor de bytes
        arquivo.writeShort(vb.length); // Escreve tamanho
        arquivo.write(vb); // Escreve dados
    }

    /**
     * Método para fechar arquivo
     * @throws Exception Tratamento de erros
     */
    public void close() throws Exception {
        arquivo.close();
    }

}